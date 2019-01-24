/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.IOException;
import java.io.PrintWriter;
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //Sets up database connection
        Database db = new Database();
        db.connect();

        //Creates a new user
        boolean created;
        try {
            db.updateQuery("INSERT INTO testuser (username, password, firstName, lastName) VALUES ('" + email + "', '" + password + "', '" + firstName + "', '" + lastName + "');");
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