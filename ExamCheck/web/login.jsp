<%-- 
    Document   : login
    Created on : 22-Jan-2019, 14:16:23
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
        <br><br>
        <a href="createAccount.jsp">Create Account</a>

    </body>
</html>