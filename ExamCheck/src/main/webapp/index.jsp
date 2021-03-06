<%--
  Created by IntelliJ IDEA.
  User: Keiren
  Date: 27/01/2019
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>

<%
    String userPK = "";
    String username = "";
    String base64 = "";
    String sessionVar = "";
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userPK = cookie.getValue();
                Database db = new Database();

                ResultSet rs = db.executeQuery("select username from users where user_pk = '" + userPK + "';");
                rs.first();
                username = rs.getString("username");
            }
            if (cookie.getName().equals("secretClass")) {
                base64 = cookie.getValue();
            }
        }
    }

    sessionVar = request.getSession().getId();
    Permissions permsInstance = new Permissions();

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



if(permsInstance != null){
%>

<html>
    <head>
        <title>ExamCheck Home</title>
        <!-- JQUERY !-->
        <script src="./vendor/jquery/jquery.min.js"></script>
        <!-- BOOTSTRAP !-->
        <link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css">
        <script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- FONT AWESOME !-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    </head>

    <script>
        function resizeText(multiplier) {
            if (document.body.style.fontSize === "") {
                document.body.style.fontSize = "1.0em";
            }
            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
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

    <body>
        <!-- Navbar !-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <a class="navbar-brand" href="#">Dundee Computing Examination Board</a>
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
                <% if (permsInstance.admin) { %>
                <!-- Notifications !-->
                <li class="nav-item dropdown" style="padding-right: 10px">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                        <i class="fas fa-bell fa-lg"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="AuditLog.jsp"><i class="fas fa-comment"></i> View Audit Log</a>
                    </div>
                </li>
                <%  }%>
                <!-- User !-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                        <i class="fas fa-user fa-lg"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#"><i class="fas fa-user"></i> <%=username%></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Log-in.jsp" onclick="deleteAllCookies()"><i class="fas fa-sign-out-alt"></i> Log out</a>
                    </div>
                </li>
            </ul>
        </nav>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Exams</h1>
                    <hr>
                </div>
            </div>
            <br>
            <div class="row">
                <!-- Completed Exams !-->
                <div class="col-sm-4">
                    <div class="card border-success">
                        <div class="card-header bg-success text-light">
                            <div class="col-xs-3">
                                <i class="fas fa-check fa-5x fa-pull-left"></i>
                            </div>
                            <div class="col-xs-9 text-right text-light">
                                <span style="font-size: 40px;">
                                    <%
                                        Database db = new Database();
                                        db.connect();
                                        String numberOfCompletedExams = db.number_of_completed_exams("1");
                                        out.print(numberOfCompletedExams);
                                    %>
                                </span>
                                <p class="text-right"> Completed Exams </p>
                            </div>
                        </div>
                        <a href="listExams.jsp" class="text-success text-decoration-none">
                            <div class="card-footer">
                                <span>View Exams</span>
                                <i class="fa fa-arrow-circle-right fa-pull-right"></i>
                            </div>
                        </a>
                    </div>
                </div>
                <% if (permsInstance.examSetter || permsInstance.internalModerator || permsInstance.examVetCommittee || permsInstance.externalModerator) { %>
                <!-- In Progress Exams !-->
                <div class="col-sm-4">
                    <div class="card border-warning">
                        <div class="card-header bg-warning text-light">
                            <div class="col-xs-3">
                                <i class="fas fa-tasks fa-5x fa-pull-left"></i>
                            </div>
                            <div class="col-xs-9 text-right text-light">
                                <span style="font-size: 40px;">
                                    <%
                                        String numberOfInProgressExams = db.number_of_in_progress_exams("1");
                                        out.print(numberOfInProgressExams);
                                        db.close();
                                    %>
                                </span>
                                <p class="text-right">In Progress Exams</p>
                            </div>
                        </div>
                        <a href="listExams.jsp" class="text-warning text-decoration-none">
                            <div class="card-footer">
                                <span>View Exams</span>
                                <i class="fa fa-arrow-circle-right fa-pull-right"></i>
                            </div>
                        </a>
                    </div>
                </div>
                <% } %>
                <% if (permsInstance.examSetter) { %>
                <!-- New Exams !-->
                <div class="col-sm-4">
                    <div class="card border-danger">
                        <div class="card-header bg-danger text-light">
                            <div class="col-xs-3">
                                <i class="fa fa-file fa-5x fa-pull-left"></i>
                            </div>
                            <div class="col-xs-9 text-right text-light">
                                <span style="font-size: 40px;">|</span>
                                <p class="text-right">Create New Exam</p>
                            </div>
                        </div>
                        <a href="CreateExam.jsp" class="text-danger text-decoration-none">
                            <div class="card-footer">
                                <span>Create Exam</span>
                                <i class="fa fa-arrow-circle-right fa-pull-right"></i>
                            </div>
                        </a>
                    </div>
                </div>
                <% } %>
            </div>
            <br>
            <% if (permsInstance.admin) { %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Administrator tools</h1>
                    <hr>
                </div>
            </div>
            <br>
            <div class="row">






                <!--
                        ADMIN
                !-->
                <!-- Add new user !-->
                <div class="col-sm-4">
                    <div class="card border-dark">
                        <div class="card-header text-center text-light bg-dark">
                            <h4 class="card-title">Add new user</h4>
                        </div>
                        <div class="card-body">
                            <form id="newUser" action="createAccount" method="POST">
                                <div class="form-group">
                                    <label for="firstName">First name(s)</label>
                                    <input type="text" class="form-control" id="firstName" required>
                                </div>
                                <div class="form-group">
                                    <label for="surname">Surname</label>
                                    <input type="text" class="form-control" id="surname" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">Dundee University E-mail</label>
                                    <input type="email" class="form-control" id="email" required>
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" required>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="Exam Setter" value="1" id="Setter"> Exam Setter<br>
                                    <input type="checkbox" name="Internal Moderator" value="1" id="IntMod"> Internal Moderator<br>
                                    <input type="checkbox" name="Exam Vet" value="1" id="Vetting"> Exam Vetting Committee<br>
                                    <input type="checkbox" name="External Moderator" value="1" id="ExtMod"> External Moderator<br>
                                    <input type="checkbox" name="SchoolOffice" value="1" id="Office"> School Office<br>
                                </div>

                                <button type="submit" class="btn btn-block btn-success">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Assign user !-->
                <div class="col-sm-4">
                    <div class="card border-dark">
                        <div class="card-header text-center text-light bg-dark">
                            <h4 class="card-title">Assign user</h4>
                        </div>
                        <div class="card-body">
                            <form id="assignUser">
                                <div class="form-group">
                                    <label for="role">Role</label>

                                    <select class="custom-select" id="role">
                                        <option selected>Select role</option>
                                        <option>Internal Moderator</option>
                                        <option>External Moderator</option>
                                        <option>Exam Vetting Committee Member</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="user">User</label>
                                    <select class="custom-select" id="user">
                                        <option selected>Select user</option>
                                        <option>User 1</option>
                                        <option>User 2</option>
                                        <option>Cont...</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="examAssign">Exam</label>
                                    <select class="custom-select" id="examAssign">
                                        <option selected>Select exam</option>
                                        <option>AC31007 - Exam</option>
                                        <option>AC31007 - Resit</option>
                                        <option>Cont...</option>
                                    </select>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-block btn-success">Assign</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- View unsigned exams !-->
                <div class="col-sm-4">
                    <div class="card border-dark">
                        <div class="card-header text-center text-light bg-dark">
                            <h4 class="card-title">View in progress exams</h4>
                        </div>
                        <div class="card-body">
                            <form id="viewExam">
                                <div class="form-group">
                                    <label for="stage">Stage</label>
                                    <select class="custom-select" id="stage">
                                        <option selected>Select stage</option>
                                        <option>Internal Moderating</option>
                                        <option>External Moderating</option>
                                        <option>Exam Vetting Committee</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="examView">Exam</label>
                                    <select class="custom-select" id="examView">
                                        <option selected>Select exam</option>
                                        <option>AC31007 - Exam</option>
                                        <option>AC31007 - Resit</option>
                                        <option>Cont...</option>
                                    </select>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-block btn-success">View</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <br>
    </body>
</html>
<%}%>