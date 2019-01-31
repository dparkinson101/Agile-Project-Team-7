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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Create Account</title>
        <style>
            html,
            body {
                height: 100%;
            }

            body {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-align: center;
                align-items: center;
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #f5f5f5;
            }

            .login-form {
                width: 100%;
                max-width: 400px;
                padding: 15px;
                margin: auto;
            }
        </style>
    </head>
    <body class="text-center">
        <div class="container">
            <form class="login-form" action="createAccount" method="post">
                <h1 class="mb-4">👀</h1>
                <h1 class="h3 mb-3 font-weight-normal">Create an account</h1>
                <div class="form-group">
                    <label for="name">First name(s)</label>
                    <input type="text" name="name" class="form-control" placeholder="First name" required autofocus>
                </div>
                <div class="form-group">
                    <label for="lastName">Surname</label>
                    <input type="text" name="lastName" class="form-control" placeholder="Surname" required>
                </div>
                <div class="form-group">
                    <label for="email">Dundee University E-mail</label>
                    <input type="email" name="email" class="form-control" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <button type="submit" onclick="deleteAllCookies()" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </div>
                <div class="form-group">
                    <a href="Log-in.jsp" class="text-dark">Got an account? Sign in</a>
                </div>
                <hr>
                <span class="mt-5 mb-3 text-muted">Dundee Computing Examination Board</span>
            </form>
        </div>
    </body>
</html>
