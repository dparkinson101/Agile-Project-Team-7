<%-- 
    Document   : loginHandler
    Created on : 21-Jan-2019, 11:08:40
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BackEnd.Main" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    Main main = new Main();
    boolean login = main.loginHandle(username, password);
    
    if(login)
    {
        HttpSession sesh = request.getSession();
        sesh.setAttribute("username", username);
        response.sendRedirect("index.jsp");
    }
    else {
        username = null;
        password = null;
    }

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
