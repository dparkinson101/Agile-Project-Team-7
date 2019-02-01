<%--
    Document   : listExams
    Created on : 23-Jan-2019, 14:05:30
    Author     : stevenshearer
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

    Database db = new Database();
    db.connect();
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
        <!-- Jquery !-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- FONT AWESOME !-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">

            function resizeText(multiplier)
            {
                if (document.body.style.fontSize === "")
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
            function showIntMod()
            {
            <%
            %>
                if (hiddenComment.style.display === "none") {
                    hiddenComment.style.display = "block";
                } else {
                    hiddenComment.style.display = "none";
                }
            }

            function showExternalMod()
            {
            <%
            %>
                if (hiddenComment.style.display === "none") {
                    hiddenComment.style.display = "block";
                } else {
                    hiddenComment.style.display = "none";
                }
            }

            function showExamVet()
            {
            <%
            %>
                if (hiddenComment.style.display === "none") {
                    hiddenComment.style.display = "block";
                } else {
                    hiddenComment.style.display = "none";
                }
            }

            function sendReply()
            {
                //1234 (comment) , button 1 2 or 3,  primary key of logged in user 
                alert("Comment box value:");
            }
            }
        </script>
    </head>
    <body>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
                <a class="navbar-brand" href="index.jsp">Dundee Computing Examination Board</a>
                <ul class="navbar-nav ml-auto">
                    <!-- Accessibility !-->
                    <li class="nav-item dropdown" style="padding-right: 10px">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                            <i class="fas fa-universal-access fa-lg"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="#" onclick=resizeText(1)><i class="fas fa-text-height fa-2x"></i>
                                Increase text size</a>
                            <a class="dropdown-item" href="#" onclick=resizeText(-1)><i class="fas fa-text-height fa-fw"></i>
                                Decrease text size</a>
                            <a class="dropdown-item" href="listExams.jsp"><i class="fa fa-text-height fa-fw"></i> Normal text size</a>
                        </div>
                    </li>
                    <!-- Notifications !-->
                    <li class="nav-item dropdown" style="padding-right: 10px">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                            <i class="fas fa-bell fa-lg"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="#"><i class="fas fa-comment"></i> No new comments</a>
                        </div>
                    </li>
                    <!-- User !-->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                            <i class="fas fa-user fa-lg"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="#"><i class="fas fa-user"></i> <% out.print(username); %></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="Log-in.jsp"onclick=" if (confirm('Are you sure you want to log out?')) {
                                        deleteAllCookies();
                                    }"><i class="fas fa-sign-out-alt"></i> Log out</a>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
        <style>
            .borderComment
            {
                border-style:solid;
                border-color:#287EC7;
                border-width:8px;
            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
        </style>
        <table border="3">
            <tr>
                <th>Comments from Internal Moderator</th>
                <th>Comments from Exam Vetting Committee</th>
                <th>Comments from External Moderator</th>
            </tr>
            <tr>
                <td><%
                    //Database db = new Database();
                    //db.connect();
                    String pk = db.download_comments1(creds);
                    out.println(pk);%>
                </td><td><%
                    String pkk = db.download_comments2(creds);
                    out.println(pkk);%>
                </td><td><% String k = db.download_comments3(creds);
                    out.println(k);%>
                </td></tr>
            <tr>
                <td><button onclick="showIntMod()">Reply to Internal Moderator</button></td>
                <td><button onclick="showExamVet()">Reply to Exam Vetting Committee</button></td>
                <td><button onclick="showExternalMod()">Reply to External Moderator</button></td>
            </tr>
            <td>
                <form id="IntModForm" action="SendReply">
                    <textarea type="text" name="inputComment" id="inputComment" rows="4" cols="50">
                    </textarea>
                    <input hidden name="value" value="1"/>
                    <input hidden name="pk" value="<%=creds%>"/>
                    <input name="Submit"  type="submit" value="Send"/>
                </form>
            </td>

            <td>
                <form id="ExamVetForm" action="SendReply">
                    <textarea type="text" name="inputComment" id="inputComment" rows="4" cols="50">
                    </textarea>
                    <input hidden name="value" value="2"/>
                    <input hidden name="pk" value="<%=creds%>"/>
                    <input name="Submit"  type="submit" value="Send"/>
                </form>
            </td>

            <td>
                <form id="ExternalModForm" action="SendReply">
                    <textarea type="text" name="inputComment" id="inputComment" rows="4" cols="50">
                    </textarea>
                    <input hidden name="value" value="3"/>
                    <input hidden name="pk" value="<%=creds%>"/>
                    <input name="Submit"  type="submit" value="Send"/>
                </form>
            </td>
        </tr>
    </table>
    <form name="sendComment" action="SendReply" id="sendComm">
        <div id="hiddenComment" style="display: none" >
            <br><br>
            <p align="center">
                Reply to <%%>
                <br> 
                <textarea type="text" name="inputComment" id="inputComment" rows="4" cols="50">
                </textarea>
                <input name="Submit"  type="submit" />
            </p>
        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
