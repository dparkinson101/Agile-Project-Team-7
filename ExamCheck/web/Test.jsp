<%-- 
    Document   : Test
    Created on : 24-Jan-2019, 12:17:26
    Author     : matthewmcneil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
        function check(){
            if (document.body.style.fontSize == ""){
                document.body.style.fontSize = "1.0em";
                }
            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
        }    
        </script>
            
        <a onclick=check()><button>create exam</button></a>
        <p>Hello World!<p>
    </body>
</html>
