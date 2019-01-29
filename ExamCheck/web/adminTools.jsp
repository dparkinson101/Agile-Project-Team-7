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

        

        ResultSet rs = db.getallexams();
        for (int i = 0; i < db.gettotalnumberofexams(); i++) {  
           
            
rs.next();
                String mc = rs.getString("module_code");
                
                String pk = rs.getString("exam_pk");

        
        %>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <table style="width:60%">
            <tr>
                <th>Exam Setter</th>
                <th>Internal Moderator</th> 
                <th>Exam Vetting Comittee</th>
                <th>External Moderator</th>
            </tr>
            <tr>
                <td bgcolor="#FF0000"><% out.print(mc); %>
                    <br>
                    <button>Assign Us</button>
                    <button>Gorilla Warfare</button>
                </td>
                <td>Smith</td> 
                <td>50</td>
                <td>
            </tr>
            <%
                }
                %>
        </table>
    </body>
</html>
