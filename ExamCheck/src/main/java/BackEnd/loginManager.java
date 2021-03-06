/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        
        Database db = new Database();

        String loginResults = db.checkLogin(email, password);

        if (loginResults != null) {
            boolean loggedIn = false;
            String perms = "guest";

            String[] roles = new String[5];
            roles[0] = db.getexamsetter(loginResults);
            roles[1] = db.getinternalmod(loginResults);
            roles[2] = db.getexamvetcommit(loginResults);
            roles[3] = db.getexternal(loginResults);
            roles[4] = db.getoffice(loginResults);
            
            Permissions permsInstance = new Permissions();
            
            permsInstance.login = true;
            permsInstance.userPK = loginResults;

            for (int i = 0; i < roles.length; i++) {
                if (!"0".equals(roles[i])) {
                    loggedIn = true;
                    switch (i) {
                        case 0:
                            perms += " examSetter";
                            permsInstance.examSetter = true;
                            break;
                        case 1:
                            perms += " internalModerator";
                            permsInstance.internalModerator = true;
                            break;
                        case 2:
                            perms += " examVetCommittee";
                            permsInstance.examVetCommittee = true;
                            break;
                        case 3:
                            perms += " externalModerator";
                            permsInstance.externalModerator = true;
                            break;
                        case 4:
                            perms += " office";
                            permsInstance.office = true;
                            break;
                    }
                }
            }

            if (loginResults.equals("1")) {
                perms += " admin";
                permsInstance.admin = true;
            }
            
            Security secure = new Security();
            String sessionVar = request.getSession().getId();
            
            String encodedInstance = secure.convertObjectToEncodedBase64(permsInstance, sessionVar);

            Cookie login = new Cookie("login", String.valueOf(loggedIn));
            Cookie credentials = new Cookie("user", loginResults);
            Cookie permissions = new Cookie("permissions", perms);
            Cookie secretClass = new Cookie("secretClass", encodedInstance);

            //Sets cookie max age for log-in to 24 hours
            login.setMaxAge(60 * 60 * 24);
            credentials.setMaxAge(60 * 60 * 24);
            permissions.setMaxAge(60 * 60 * 24);
            secretClass.setMaxAge(60*60*24);

            response.addCookie(login);
            response.addCookie(credentials);
            response.addCookie(permissions);
            response.addCookie(secretClass);

            response.sendRedirect("index.jsp");

        } else {
            Cookie login = new Cookie("login", "false");
            response.addCookie(login);
            response.sendRedirect("Log-in.jsp");
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
        return "Used to verify login and distribute cookies.";
    }// </editor-fold>

}
