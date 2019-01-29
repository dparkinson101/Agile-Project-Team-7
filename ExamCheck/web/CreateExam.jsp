

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Create An Exam</title>

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

    <body>

        <script>
            function resizeText(multiplier) {
                if (document.body.style.fontSize === "") {
                    document.body.style.fontSize = "1.0em";
                }
                document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
            }
        </script>
       
        <%
            HttpSession spoons = request.getSession();
            String username = (String) spoons.getAttribute("email");
        %>

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
                        <a class="dropdown-item" href="index.jsp"><i class="fa fa-text-height fa-fw"></i> Normal text size</a>
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
                        <a class="dropdown-item" href="#"><i class="fas fa-user"></i> <% out.print(username);%></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Log-in.jsp"onclick=" if (confirm('Are you sure you want to log out?')) {
                                    deleteAllCookies();
                                }"><i class="fas fa-sign-out-alt"></i> Log out</a>
                    </div>
                </li>
            </ul>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create a new Exam</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>


            <form action="FileUpload" method="post" id="examDetails" enctype="multipart/form-data">
                Module Code: <br>
                <input type="text" name="moduleCode" id="modCode"><br><br>
                Module Title: <br>
                <input type="text" name="moduleTitle" id="modTitle"><br><br>
                <br>
                <input type="radio" name="examType" value="0" id="onlineRad"> Online<br> <!-- 0=Online 1=Written -->
                <input type="radio" name="examType" value="1" id="writtenRad"> Written<br>
                <br>
                <input type="radio" name="examChoice" value="0" id="mainRad"> Main Exam<br> <!-- 0=Main Exam 1=Resit Exam -->
                <input type="radio" name="examChoice" value="1" id="resitRad"> Resit Exam<br>
                <br>
                <input type="radio" name="examLevel" value="0" id="UndergradRad"> Undergrad Exam<br> <!-- 0=Undergrad 1=Postgrad -->
                <input type="radio" name="examLevel" value="1" id="PostgradRad"> Postgrad Exam<br>
                <br>
                <br>
                Select a file to upload: <br><br>
                <input type="file" name="fileToUpload" accept=".docx, .pdf"/>
                <br>
                <button type="submit" form="examDetails" value="submit">Submit Exam</button>
            </form>

            <br>
            <br>      
            <br>
            <br>
            <a href="index.jsp">Return to Homepage</a>

            <!-- jQuery -->
            <script src="vendor/jquery/jquery.min.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="vendor/bootstrap/js/bootstrap.min.js"></script>


            <!-- Custom Theme JavaScript -->
            <script src="dist/js/DCEC.js"></script>
        </div>
    </div>
</body>
</html>