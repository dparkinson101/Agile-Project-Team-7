<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
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

<html>
    <head>
        <title>jQuery DatePicker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker1").datepicker();
                     $("#datepicker2").datepicker();          
                    $("#datepicker3").datepicker();           
                    $("#datepicker4").datepicker();           
                    $("#datepicker5").datepicker();         
            });
        </script>

    </head>
    <body>
        <form  method="GET" action="showDate">
            <br />
            <label for="datepicker">Enter deadline for exam submission:</label>
            <input type="text" name="date1" id="datepicker1">
       
             <br /> 
            <br />
            <label for="datepicker">Enter deadline for exam moderation by internal moderator:</label>
            <input type="text" name="date2" id="datepicker2">
          
             <br /> 
            <br />
            <label for="datepicker">Enter deadline for approval by exam vetting comittiee:</label>
            <input type="text" name="date3" id="datepicker3">
                
             <br /> 
            <br />            
            <label for="datepicker">Enter  deadline for external examiners to finish :</label>
            <input type="text" name="date4" id="datepicker4" >
            
             <br /> 
            <br />
            <label for="datepicker">Enter  date for database cleanup (this should be after all exams have been downloaded):</label>
            <input type="text" name="date5" id="datepicker5">
                <br /> 
            <br />  
            <input type="submit" value="Submit">  
            
            
        </form>
            
    </body>
</html>

