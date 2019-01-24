/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
public class loginManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession spoons = request.getSession();
        spoons.setAttribute("email", email);

        Database db = new Database();
        db.connect();
        String loginResults = db.checkLogin(email, password);

        boolean loggedIn = false;
        String perms = "guest";

        String[] roles = new String[5];
        roles[0] = db.getexamsetter(loginResults);
        roles[1] = db.getexamvetcommit(loginResults);
        roles[2] = db.getexternal(loginResults);
        roles[3] = db.getinternalmod(loginResults);
        roles[4] = db.getoffice(loginResults);

        for (int i = 0; i < roles.length; i++) {
            if (!"0".equals(roles[i])) {
                loggedIn = true;
                switch (i) {
                    case 0:
                        perms += " examSetter";
                        break;
                    case 1:
                        perms += " internalModerator";
                        break;
                    case 2:
                        perms += " examVetCommittee";
                        break;
                    case 3:
                        perms += " externalModerator";
                        break;
                    case 4:
                        perms += " office";
                        break;
                }
            }
        }
        
        if(loginResults.equals("1")){
            perms += " admin";
        }

        Cookie login = new Cookie("login", String.valueOf(loggedIn));
        Cookie permissions = new Cookie("permissions", perms);

        //Sets cookie max age for log-in to 10 mins
        login.setMaxAge(60 * 10);
        permissions.setMaxAge(60 * 10);

        response.addCookie(login);
        response.addCookie(permissions);

        if(perms.contains("admin"))
        {
            response.sendRedirect("/ExamCheck/Admin.jsp");
        }
        else if(perms.contains("examSetter"))
        {
            response.sendRedirect("/ExamCheck/examSetter.jsp");
        }
        else
        {
            response.sendRedirect("/ExamCheck/Staff.jsp");
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
        return "Short description";
    }// </editor-fold>

}
