<%-- 
    Document   : createAccount
    Created on : 22-Jan-2019, 11:16:16
    Author     : Douglas
--%>

<%@page import="BackEnd.Security"%>
<%@page import="BackEnd.Permissions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //CODE FOR COOKIE CHECKING
    String base64 = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("secretClass")) {
                base64 = c.getValue();
            }
        }
    }

    String sessionVar = request.getSession().getId();
    Permissions permsInstance = null;

    Security secure = new Security();
    try {
        permsInstance = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
        if (permsInstance == null) {
            throw new NullPointerException("Perms Object Returned is Null");
        }
    } catch (NullPointerException e) {
        System.out.println("Error Getting Permissions Object: The Session Variable May Have Changed!");
        request.changeSessionId();

        //Deletes Cookies
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                Cookie cookie = new Cookie(c.getName(), "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("Log-in.jsp");
    }
%>

<%String email = request.getParameter("email");%>

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
