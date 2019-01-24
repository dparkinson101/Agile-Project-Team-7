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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author declaneparker
 */
public class AddComments extends HttpServlet 
{
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
            throws ServletException, IOException
    {
        String pk = request.getParameter("examPK");
        String comment = request.getParameter("comment");
        DateFormat dateFormat = new SimpleDateFormat("DD/mm/yyyy HH:mm:ss");
        Date date = new Date();
        String currentDateTime = dateFormat.format(date);
        
        Database db = new Database();
        db.connect();
        try
        {
            db.addcomment(comment, pk, currentDateTime);
            response.sendRedirect("index.jsp");
        }
        catch(Exception e)
        {
            e.getMessage();      
        }
        
    }
}
