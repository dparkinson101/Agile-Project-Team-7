<%-- 
    Document   : ExamUpload
    Created on : 23-Jan-2019, 14:50:10
    Author     : matthewmcneil
--%>
<%@page import="java.io.File"%>
<%@page import="BackEnd.Database" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            File file = request.getAttribute("fileToUpload");
            String code = request.getParameter("moduleCode");
            String level = request.getParameter("examLevel");
            String subject = request.getParameter("moduleTitle");
            String type = request.getParameter("examType");
            String choice = request.getParameter("examChoice");
        Database db = new Database();
                    db.connect();
                    // boolean test= db.updateQuery("INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(9,null);");
                    db.blobin( file, code, level, "34", subject, type, choice, "1");  
                    
        %>
    </body>
</html>
