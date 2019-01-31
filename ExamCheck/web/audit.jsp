<%-- 
    Document   : audit
    Created on : 31-Jan-2019, 15:49:09
    Author     : laptop
--%>
<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
        <table width='670'>
        <%
       
            Database db = new Database();
            db.connect();
int number_of_entrys = db.audit_rows();
    for (int i =1; i<=number_of_entrys;i++){
        %>


        <tr>    <td width='60'><%out.println(db.download_log_string(String.valueOf(i)) + "        at       "+ db.download_log_date(String.valueOf(i))  );%> </td>  </tr>
   <%}%>
</table>
    </body>
</html>

