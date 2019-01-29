<%--
  Created by IntelliJ IDEA.
  User: Keiren
  Date: 27/01/2019
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Log-In</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
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
    <body>
        <div class="login-form">
            <form action="loginManager" method="post">
                <h2 class="text-center">Log in</h2>       
                <div class="form-group">
                    <input type="text" name="email" class="form-control" placeholder="Email" required="required">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                </div>
                <%
                    Cookie[] cookies = request.getCookies();
                    for (Cookie c : cookies) {
                        if (c.getName().equals("login")) {
                            if (c.getValue().equals("false")) {
                                out.println("<p class='text-danger text-center'> Incorrect Login Credentials <br> Please try again</p>");
                            }
                        }
                    }
                %>
                <div class="form-group">
                    <button type="submit" onclick="deleteAllCookies()" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <a href="#" class="pull-right">Forgot Password?</a>
                </div>        
            </form>
            <p class="text-center"><a href="/ExamCheck/createAccount.jsp">Create an Account</a></p>
        </div>
    </body>
</html>
