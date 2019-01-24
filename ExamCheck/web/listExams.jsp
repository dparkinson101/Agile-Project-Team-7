<%-- 
    Document   : listExams
    Created on : 23-Jan-2019, 14:05:30
    Author     : stevenshearer
--%>

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
    </script>

    <%/*
        HttpSession sesh = request.getSession();
        String username = (String) sesh.getAttribute("username");
        */
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
                            <li><a href="Log-in.jsp" onclick="return confirm('Are you sure you want to log out?');"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Top Links -->

                <!-- /.navbar-static-side -->
            </nav>
        </div>

        <%
            /*
            Database db = new Database();
            db.connect();
            
            String user_pk = db.getUserPK();
            String result = db.number_examslinkedtopk("1");
            int count = Integer.getInteger(result);
            */
        %>
                          
        <div class="container">
            <div class="panel-group" id="exams">
                <% if (perms.contains("examSetter")) { %>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Exam Setter</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        
                        
                        <% for (int i=0; i< 5; i++){ %>
                        <div class="panel-body">
                            <p class="mb-1">Module Code</p>
                            <p class="mb-1">Date</p>
                            <p class="mb-1">Resit</p>
                            <a href=""><button class="fa fa-download" onclick="LoopExams()"> Download exam </button> </a>
                            <button class="fa fa-pencil "> Update exam </button>
                        </div>
                        <%} %>                     
                    </div>
                </div>
                <%} %>
                <% if (perms.contains("internalModerator")) { %>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Internal Moderator</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        
                        <% for (int i=0; i< 5; i++){ %>
                        <div class="panel-body">
                            <p class="mb-1">Module Code</p>
                            <p class="mb-1">Date</p>
                            <p class="mb-1">Resit</p>
                            <a href=""><button class="fa fa-download" onclick="LoopExams()"> Download exam </button> </a>
                            <button class="fa fa-pencil "> Update exam </button>
                        </div>
                        <%} %>
                        
                    </div>
                </div>
                <%} %>
                        <% if (perms.contains("examVetCommittee")) { %>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Exam Vetting Committee</a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <% for (int i=0; i< 5; i++){ %>
                        <div class="panel-body">
                            <p class="mb-1">Module Code</p>
                            <p class="mb-1">Date</p>
                            <p class="mb-1">Resit</p>
                            <a href=""><button class="fa fa-download" onclick="LoopExams()"> Download exam </button> </a>
                            <button class="fa fa-pencil "> Update exam </button>
                        </div>
                        <%} %>
                        
                    </div>
                </div>
                 <%} %>
                 <% if (perms.contains("externalModerator")) { %>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">External Moderator</a>
                        </h4>
                    </div>
                    <div id="collapse4" class="panel-collapse collapse">
                        <% for (int i=0; i< 5; i++){ %>
                        <div class="panel-body">
                            <p class="mb-1">Module Code</p>
                            <p class="mb-1">Date</p>
                            <p class="mb-1">Resit</p>
                            <a href=""><button class="fa fa-download" onclick="LoopExams()"> Download exam </button> </a>
                            <button class="fa fa-pencil "> Update exam </button>
                        </div>
                        <%} %>
                        
                    </div>
                </div>
                <%} %>
                <% if (perms.contains("office")) { %>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">School Office</a>
                        </h4>
                    </div>
                    <div id="collapse5" class="panel-collapse collapse">
                        <% for (int i=0; i< 5; i++){ %>
                        <div class="panel-body">
                            <p class="mb-1">Module Code</p>
                            <p class="mb-1">Date</p>
                            <p class="mb-1">Resit</p>
                            <a href=""><button class="fa fa-download" onclick="LoopExams()"> Download exam </button> </a>
                            <button class="fa fa-pencil "> Update exam </button>
                        </div>
                        <%} %>
                    </div>
                </div>
              <%} %>         
                

            </div> 
        </div>                   

        <!-- jQuery -->
        <script src="vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="dist/js/DCEC.js"></script>

    </body>
</html>
