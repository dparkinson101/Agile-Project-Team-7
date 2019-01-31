<%-- 
    Document   : createAccount
    Created on : 22-Jan-2019, 11:16:16
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <br><br>
        <form action="createAccount" method="POST">
            <h6>First Name:</h6>
            <input type="text" name="firstName"/>
            <br>
            <h6>Last Name</h6>
            <input type="text" name="lastName"/>
            <br>
            <h6>Dundee University Email</h6>
            <input type="text" name="email"/>
            <br>
            <h6>Password</h6>
            <input type="password" name="password"/>
            <br><br>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
