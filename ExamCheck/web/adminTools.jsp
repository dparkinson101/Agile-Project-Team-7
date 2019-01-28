<%-- 
    Document   : adminTools
    Created on : 28-Jan-2019, 13:16:36
    Author     : matthewmcneil
--%>
<%@page import="BackEnd.Database"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        Database db = new Database();
        db.connect();
        HttpSession spoons = request.getSession();
        String username = (String) spoons.getAttribute("email");

        String perms = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("permissions")) {
                    perms = cookie.getValue();
                }
            }
        }

        String creds = "";
        Cookie[] cookies2 = request.getCookies();

        if (cookies2 != null) {
            for (Cookie cookie2 : cookies2) {
                if (cookie2.getName().equals("user")) {
                    creds = cookie2.getValue();
                }
            }
        }

        ResultSet rs = db.info_examslinkedtopk(creds);
        
        %>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table style="width:60%">
            <tr>
                <th>Exam Setter</th>
                <th>Internal Moderator</th> 
                <th>Exam Vetting Comittee</th>
                <th>External Moderator</th>
            </tr>
            <tr>
                <td bgcolor="#FF0000"><% out.print(rs.getString("module_code")); %>
                    <br>
                    <button></button>
                    <button>Gorilla Warfare</button>
                </td>
                <td>Smith</td> 
                <td>50</td>
                <td>
            </tr>
            <tr>
                <td>Eve</td>
                <td>Jackson</td> 
                <td>94</td>
            </tr>
        </table>
    </body>
</html>
