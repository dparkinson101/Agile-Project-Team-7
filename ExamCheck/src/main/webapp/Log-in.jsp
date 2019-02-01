<%-- 
    Document   : Log-in
    Created on : 22-Jan-2019, 10:54:27
    Author     : andrewbrodrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Log-In</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
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
        <script>
            function deleteAllCookies() {
                var cookies = document.cookie.split(";");
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = cookies[i];
                    var eqPos = cookie.indexOf("=");
                    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
                    document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
                }
            }
        </script>
    </head>
    <body class="text-center">
        <div class="container">
            <form class="login-form" action="loginManager" method="post">
                <h1 class="mb-4">🐦</h1>
                <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
                <div class="form-group">
                    <label for="email" class="sr-only">Email address or Username</label>
                    <input type="text" name="email" class="form-control" placeholder="Email" required autofocus>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password" required>
                </div>
                <%
                    Cookie[] cookies = request.getCookies();
                    if (cookies == null) {
                        for (Cookie c : cookies) {
                            if (c.getName().equals("login")) {
                                if (c.getValue().equals("false")) {
                                    out.println("<p class='text-danger text-center'> Incorrect Login Credentials, <br> Please try again</p>");
                                }
                            }
                        }
                    }
                %>
                <div class="form-group">
                    <button type="submit" onclick="deleteAllCookies()" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </div>
                <div class="form-group">
                    <a href="createAccount.jsp" class="text-dark text-left" style="float: left;">Create an account</a>
                    <a href="#" class="text-dark text-right float-right" style="float: right;">Forgot password?</a>
                    <div class="clearfix"></div>
                </div>
                <hr>
                <span class="mt-5 mb-3 text-muted">Dundee Computing Examination Board</span>
            </form>
        </div>
    </body>
</html>