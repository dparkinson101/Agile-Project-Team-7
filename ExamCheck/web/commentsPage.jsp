<%--
    Document   : listExams
    Created on : 23-Jan-2019, 14:05:30
    Author     : stevenshearer
--%>
<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //Code for Cookie Validation
    
    String sessionVar = request.getSession().getId();
    String base64 = null;
    
    if (request.getCookies() != null) {
        for (Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals("secretClass")){
                base64 = cookie.getValue();
            }
        }
    }
    Security secure = new Security();
    try {
        Permissions permissionsObject = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
        if(permissionsObject == null){
            throw new NullPointerException("Error: Null Permissions Object Returned");
        }
    } catch (Exception e) {
        System.out.println("Error Getting Permissions Object: Session Variable may have changed.");
        System.out.println("Loggin Possible Tampering Detected With Following Credentials:");
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        System.out.println(request.getRequestedSessionId());
        request.changeSessionId();

        //Deletes Cookies
        for (Cookie c : request.getCookies()) {
            Cookie cookie = new Cookie(c.getName(), "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        response.sendRedirect("Log-in.jsp");
    }
%>

<%
    HttpSession spoons = request.getSession();
    String username = (String) spoons.getAttribute("email");

    String perms = "";
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("permissions")) {
                perms = cookie.getValue();
            }
        }
    }

    String creds = "";
    Cookie[] cookies2 = request.getCookies();

    if (cookies2 != null) {
        for (Cookie cookie2 : cookies2) {
            if (cookie2.getName().equals("user")) {
                creds = cookie2.getValue();
            }
        }
    }
%>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="The Mighty Morphin' Matthew Rangers" content="">

        <title>Exams</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="dist/css/DCEC.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <script>
        function resizeText(multiplier)
        {
            if (document.body.style.fontSize == "")
            {
                document.body.style.fontSize = "1.0em";
            }
            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
        }

        function submitForms(formUpload, formComment) {
            var f1 = document.getElementById(formUpload);
            var f2 = document.getElementById(formComment);

            //sendXMLRequest(f1, "FileUploadUpdate");
            sendXMLRequest(f2, "AddComments");
            f1.submit();
        }

        function sendXMLRequest(f, page) {
            var postData = [];
            for (var i = 0; i < f.elements.length; i++) {
                postData.push(f.elements[i].name + "=" + f.elements[i].value);
            }
            var xhr = new XMLHttpRequest();
            xhr.open("POST", page, true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.send(postData.join("&"));
        }

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
    <%
        Database db = new Database();
        db.connect();
        //String noCompletedExams = db.number_of_completed_exams("1");
    %>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="Admin.jsp">Dundee Computing Examination Board</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">
                    <!-- Accessibility -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-universal-access fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-access">
                            <li><a href="#" onclick=resizeText(1)><i class="fa fa-text-height fa-2x"></i>Increase Text Size</a></li>
                            <li><a href="#" onclick=resizeText(-1)><i class="fa fa-text-height fa-fw"></i>Decrease Text Size</a></li>
                            <li><a href="Admin.jsp"><i class="fa fa-text-height fa-fw"></i>Normal Text Size</a></li>
                        </ul>
                    </li>
                    <!-- Alerts Dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment fa-fw"></i> No New Comments
                                    </div>
                                </a>
                            </li>
                        </ul>

                    </li>
                    <!-- User Dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i><% out.print(username);%></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="Log-in.jsp" onclick=" if(confirm('Are you sure you want to log out?')){deleteAllCookies();}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Top Links -->

                <!-- /.navbar-static-side -->
            </nav>
        </div>
                            <style>
                                .borderComment
                                {
                                    border-style:solid;
                                    border-color:#287EC7;
                                    border-width:8px;
                                }
                            </style>
         <form>
                <div class="borderComment">
                    <p>From Internal Moderator: </p>
                    <p> (int mod message here)</p>
                    </div>
                <div class="borderComment">
                    <!--<p> Comment here: </p><br> -->
                    <textarea type="text" name="submitComment" value="Comment here" rows="4" cols="50">
                    </textarea>
                    <input type="submit" value="Reply" id="submitButton">          
                </div>
        </form>
                            


    </body>
</html>
