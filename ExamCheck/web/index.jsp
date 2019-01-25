<%--
    Document   : index
    Created on : 21-Jan-2019, 10:20:17
    Author     : Douglas
--%>
<%@page import="BackEnd.Database" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="The Mighty Morphin' Matthew Rangers" content="">

        <title>Homepage</title>

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
    </script>

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

        String examSetter = perms.substring(0, 16);
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
                    <a class="navbar-brand" href="Staff.jsp">Dundee Computing Examination Board</a>
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
                            <li><a href="index.jsp"><i class="fa fa-text-height fa-fw"></i>Normal Text Size</a></li>
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
                            <li><a href="#"><i class="fa fa-user fa-fw"></i><% out.print(username); %></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="Log-in.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Top Links -->

                <!-- /.navbar-static-side -->
            </nav>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Exams</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-check fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">
                                            <%                                            Database db = new Database();
                                                db.connect();
                                                String noCompletedExams = db.number_of_completed_exams("1");
                                                out.print(noCompletedExams);
                                            %>
                                        </div>
                                        <div>Completed Exams</div>
                                    </div>
                                </div>
                            </div>
                            <a href="listExams.jsp">
                                <div class="panel-footer">
                                    <span class="pull-left">View Exams</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">
                                            <%
                                                String noInProgressExams = db.number_of_in_progress_exams("1");
                                                out.print(noInProgressExams);
                                            %>
                                        </div>
                                        <div>Exams In Progress</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Exams</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>

                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-file fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">
                                            <%
                                                //String noNewExams = db
                                                //out.print(noNewExams);
                                            %>
                                        </div>
                                        <div>New Exams</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Add Exam</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                </div>

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <%                            if (perms.contains("admin")) {
                        %>
                        <div class="panel panel-white">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-13 text-center">
                                        <div><font size="5">Add New User</font></div>
                                    </div>
                                </div>
                            </div>
                            <a href="AddUser.jsp">
                                <div class="panel-footer">
                                    <span class="pull-left">Add User</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <% } %>

                    <div class="row">
                        <%
                            if (perms.contains("admin")) {
                        %>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-12 text-middle-center">
                                            <div><font size="5">View Unsigned Exams</font></div>
                                        </div>
                                    </div>
                                </div>
                                <a href="CreateExam.jsp">
                                    <div class="panel-footer">
                                        <span class="pull-left">View Exams</span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <% } %>

                        <% if (perms.contains("examSetter")) {%>
                        <div class="col-md-6 col-lg-3">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-12 text-center">
                                            <div><font size="5">Create New Exam</font></div>
                                        </div>
                                    </div>
                                </div>
                                <a href="CreateExam.jsp">
                                    <div class="panel-footer">
                                        <span class="pull-left">Create</span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <% }%>
                    </div>
                </div>
            </div>
            <!-- /#page-wrapper -->

        </div>

        <!-- jQuery -->
        <script src="vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="dist/js/DCEC.js"></script>

    </body>
</html>
