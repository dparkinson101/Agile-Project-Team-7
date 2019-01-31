/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
public class createAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods for creating a new account on the website.
     *
     * @param request servlet request for creating a new account
     * @param response servlet webpage shown when account created or when an
     * error occurs
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Sets up variables for POST varaible info
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("sName");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String exSeta = request.getParameter("exSet");
        String intMod = request.getParameter("intMod");
        String exVet = request.getParameter("exVet");
        String exMod = request.getParameter("exMod");
        String schOff = request.getParameter("schOff");

        System.out.println(exSeta);
        System.out.println(intMod);
        System.out.println(exVet);
        System.out.println(exMod);
        System.out.println(schOff);
      
        try {
            //Creates / Stores Salted Hash of Password
            Base64.Encoder enc = Base64.getEncoder();
            Security security = new Security();
            byte[] salt = security.getNewSalt();

            byte[] saltedHash = security.getSaltedHash(password, salt);
            
            //Sets up database connection
            Database db = new Database();

            //Creates a new user
            boolean created;
            try {
                db.updateQuery("INSERT INTO users (username, password, salt) VALUES ('" + email + "', '" + enc.encodeToString(saltedHash) + "', '" + enc.encodeToString(salt) + "');");
        //    out.println(db.user_rows());
        
            
        
                if(exSeta != null){
                  db.updateQuery("INSERT INTO exam_setter (lect_pk, user_user_pk)values("+db.user_rows()+","+db.user_rows()+");");
               }
                if(intMod != null)
               {
             //      out.println(db.user_rows());
                  db.updateQuery("INSERT INTO internal_moderator (int_mod_pk, user_user_pk)values("+db.user_rows()+","+db.user_rows()+");");
               }
                if(exVet != null)
               {
                //   out.println(db.user_rows());
                  db.updateQuery("INSERT INTO exmvetcomit (exmVet_pk, user_user_pk)values("+db.user_rows()+","+db.user_rows()+");");
               }      
                if(exMod != null)
               {
                //   out.println(db.user_rows());
                  db.updateQuery("INSERT INTO external_examiner (ext_exam_pk, user_user_pk)values("+db.user_rows()+","+db.user_rows()+");");
               }
                if(schOff != null)
               {
                  out.println("11111");
                  db.updateQuery("INSERT INTO school_office (school_office_pk, user_user_pk)values("+db.user_rows()+","+db.user_rows()+");");
               }  
               out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                created = true;
            } catch (Exception e) {
                created = false;
                System.out.println(e);
            }
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet createAccount</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet createAccount at " + request.getContextPath() + "</h1>");
                out.println("<p>" + firstName + " " + lastName + "</p>");
                if (created) {
                    out.println("<p>Account Created Successfully :)</p>");
                } else {
                    out.println("<p>Error Creating Account</p>");
                }
                out.println("</body>");
                out.println("</html>");
                response.sendRedirect("index.jsp");
            }
            catch(Exception e){
                System.out.println("ERROR PRINTING HTML");
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println("Account Creation Failed To Hash&Salt Password");
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Used to create a new user account.";
    }// </editor-fold>   
}
