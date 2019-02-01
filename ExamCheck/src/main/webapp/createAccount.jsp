<%-- 
    Document   : createAccount
    Created on : 22-Jan-2019, 11:16:16
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String email = request.getParameter("email");
%>

<html>
    <head>
        <!-- JQUERY !-->
        <script src="./vendor/jquery/jquery.min.js"></script>
        <!-- BOOTSTRAP !-->
        <link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css">
        <script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- FONT AWESOME !-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body style="text-align: center;">
        <h1>Create New Account</h1>
        <br><br>
        <form action="createAccount" method="POST">
            <h6>Dundee University Email</h6>
            <h6><%= email%></h6>
            <input type="hidden" name="email" value="<%= email%>"/>
            <br>
            <h6>Password</h6>
            <input type="password" name="password"/>
            <br><br>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
