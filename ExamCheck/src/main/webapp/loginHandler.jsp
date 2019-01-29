<%-- 
    Document   : loginHandler
    Created on : 21-Jan-2019, 11:08:40
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BackEnd.Main" %>
<%@page import="BackEnd.Database" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    
Database db = new Database();
db.connect();
String user_pk  =db.checkLogin(username, password);
String[] roles = new String[5];
roles[0] = db.getexamsetter(user_pk);
              roles[1] = db.getinternalmod(user_pk);
                roles[2] = db.getexamvetcommit(user_pk);
             roles[3] = db.getexternal(user_pk);
              roles[4] = db.getoffice(user_pk);

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Result</title>
    </head>
    <body>
        <h1>Username: <%= username%></h1>
        <h1>Password: <%= password%></h1>
    </body>
</html>
