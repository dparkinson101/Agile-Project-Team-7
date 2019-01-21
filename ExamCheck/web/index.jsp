<%-- 
    Document   : index
    Created on : 21-Jan-2019, 10:20:17
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="loginHandler.jsp" method="POST">
            <input type="text" name="username"/>
            <input type="password" name="password"/>
            <button type="submit">Login</button>
        </form>
    </body>
</html>
