package BackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import BackEnd.Database;
import java.nio.file.Paths;
import java.util.Random;
import javax.servlet.http.Cookie;

/**
 *
 * @author matthewmcneil
 */
@MultipartConfig
public class FileUpload extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        //get inputs
        //InputStream fileContent = filePart.getInputStream();
        Part filePart = request.getPart("fileToUpload");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        String docType = filePart.getSubmittedFileName();
        int i = docType.lastIndexOf('.');
        if (i > 0) {
            docType = docType.substring(i + 1);
        }

        //String filePath = request.getParameter("fileToUpload");
        String moduleCode = request.getParameter("moduleCode");
        String moduleTitle = request.getParameter("moduleTitle");
        String examType = request.getParameter("examType");
        String examChoice = request.getParameter("examChoice");
        String examLevel = request.getParameter("examLevel");
        Random Random = new Random();
        String examPK = Integer.toString(Random.nextInt(99999));

        //out.println(filePath);
        out.println(moduleCode);
        out.println(moduleTitle);
        out.println(examType);
        out.println(examChoice);
        out.println(examLevel);
        out.println(examPK);
        out.println(docType);

        //Connect to database
        Database db = new Database();
        db.connect();

        //
        //InputStream inputStream = new FileInputStream(new File(filePath));
        //out.println(inputStream);
        //db.updateQuery("INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(134,null);");
        db.blobin(fileContent, moduleCode, examLevel, "34", moduleTitle, examType, examChoice, "1", examPK, docType);
        out.println("end");
        response.sendRedirect("/ExamCheck/index.jsp");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<meta name=\"description\" content=\"\">");
            out.println("<meta name=\"author\" content=\"\">");
            out.println("<title>Servlet createAccount</title>");
            out.println("<link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"dist/css/DCEC.css\" rel=\"stylesheet\">");
            out.println("<link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("File passed");
            out.println("</head>");
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
        return "Short description";
    }// </editor-fold>

}
