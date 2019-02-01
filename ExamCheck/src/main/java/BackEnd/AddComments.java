/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author declaneparker
 */
public class AddComments extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int stage = 0;
        String pk = request.getParameter("examPK");
        String comment = request.getParameter("comment");
        int pointer = Integer.parseInt(request.getParameter("stage"));
        //int ryan = Integer.parseInt(request.getParameter("ryan"));
        String ryan = request.getParameter("ryan");
        System.out.println(ryan);
        if(ryan.equals("yes")){
            stage = pointer;
        }
        else if(ryan.equals("no"))
        {
            System.out.println(ryan);
            stage = 0;
        }
        System.out.println(stage);
        DateFormat dateFormat = new SimpleDateFormat("DD/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String currentDateTime = dateFormat.format(date);

        Database db = new Database();
        db.connect();
        try {
            System.out.println(comment);
            System.out.println(pk);
            System.out.println(currentDateTime);
            //Hardcoded to moving exam setter exam onto stage 2
            try {
                db.addcomment(comment, pk, currentDateTime, stage);
            } catch (Exception e) {
                System.out.println(e);
            }

            response.sendRedirect("index.jsp");
            db.close();
        } catch (IOException e) {
            e.getMessage();
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
        processComment(request, response);
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
        processComment(request, response);
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
