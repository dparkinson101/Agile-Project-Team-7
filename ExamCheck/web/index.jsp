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
        <form action="loginHandler.jsp">
            <input type="text" name="username"/>
            <input type="password" name="password"/>
            <button type="submit">Login</button>
        </form>
        <button onclick="fileBrowser()">Try it</button>

        <script>
            //Browse local files to upload MMcN
            function fileBrowser() {
                var x = document.createElement("INPUT");
                x.setAttribute("type", "file");
                document.body.appendChild(x);
            }
        </script>
    </body>  
</html>
