<%--
    Document   : listExams
    Created on : 23-Jan-2019, 14:05:30
    Author     : stevenshearer
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@page import="BackEnd.Permissions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession spoons = request.getSession();
    String username = (String) spoons.getAttribute("email");
    Permissions permsInstance = (Permissions) spoons.getAttribute("perms");

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
            <div class="accordion">
                <% if (permsInstance.examSetter) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopk(creds));%>
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                Exam Setter
                            </button>
                    </div>
                    <div id="collapseOne" class="collapse hide" aria-labelledby="headingOne" data-parent="#accordion">


                        <%
                            ResultSet rs = db.info_examslinkedtopk(creds);
                            for (int i = 1; i <= noOfExams; i++) {
                                int no = i;

                                if (rs.next()) {

                                    String mc = rs.getString("module_code");
                                    String title = rs.getString("title");
                                    String onlineorpaper;
                                    if ("0".equals(rs.getString("online_or_paper"))) {
                                        onlineorpaper = "Online Exam";
                                    } else {
                                        onlineorpaper = "Written Exam";
                                    }
                                    String resit;
                                    if ("0".equals(rs.getString("resit"))) {
                                        resit = "Main Exam";
                                    } else {
                                        resit = "Resit Exam";
                                    }
                                    String exam = rs.getString("exam");
                                    String grade;
                                    if ("0".equals(rs.getString("grade"))) {
                                        grade = "Undergraduate Exam";
                                    } else {
                                        grade = "Postgraduate Exam";
                                    }
                                    String pk = rs.getString("exam_pk");

                        %>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Number</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Method</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Exam</th>
                                        <th scope="col">Grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> <% out.print(no); %></th>
                                        <td> <% out.print(mc.toUpperCase()); %> </td>
                                        <td> <% out.print(title); %> </td>
                                        <td> <% out.print(onlineorpaper); %> </td>
                                        <td> <% out.print(resit); %> </td>
                                        <td> <% if (exam == "1") {
                                                out.print("Exam");
                                            } else {
                                                out.print("Exam Soultions");
                                            } %> </td>
                                        <td> <% out.print(grade);%> </td>

                                    </tr>
                                </tbody>
                            </table>
                            <form action="FileDownload" method="POST">
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <button class="btn btn-info btn-lg btn-block fa fa-download" type="submit"> Download Exam </button>
                            </form>
                            <br>
                            <button class="btn btn-info btn-lg btn-block" href=""><i class="fas fa-hotdog"></i> View Comments </button>
                            <br>
                        </div>
                        <br>
                        <%}
                            } %>
                    </div>
                </div>
                <%}%>
                <% if (permsInstance.internalModerator) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkintmod(creds));%>
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Internal Moderator
                            </button>
                    </div>
                    <div id="collapseTwo" class="collapse hide" aria-labelledby="headingTwo" data-parent="#accordion">

                        <%                                 ResultSet rs = db.info_examslinkedtopkintmod(creds);

                            for (int i = 1; i <= noOfExams; i++) {
                                int no = i;
                                if (rs.next()) {
                                    String mc = rs.getString("module_code");
                                    String title = rs.getString("title");
                                    String onlineorpaper;
                                    if ("0".equals(rs.getString("online_or_paper"))) {
                                        onlineorpaper = "Online Exam";
                                    } else {
                                        onlineorpaper = "Written Exam";
                                    }
                                    String resit;
                                    if ("0".equals(rs.getString("resit"))) {
                                        resit = "Main Exam";
                                    } else {
                                        resit = "Resit Exam";
                                    }
                                    String exam = rs.getString("exam");
                                    String grade;
                                    if ("0".equals(rs.getString("grade"))) {
                                        grade = "Undergraduate Exam";
                                    } else {
                                        grade = "Postgraduate Exam";
                                    }
                                    String pk = String.valueOf(rs.getInt("exam_pk"));
                        %>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Number</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Method</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Exam</th>
                                        <th scope="col">Grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> <% out.print(no); %></th>
                                        <td> <% out.print(mc.toUpperCase()); %> </td>
                                        <td> <% out.print(title); %> </td>
                                        <td> <% out.print(onlineorpaper); %> </td>
                                        <td> <% out.print(resit); %> </td>
                                        <td> <% if (exam == "1") {
                                                out.print("Exam");
                                            } else {
                                                out.print("Exam Soultions");
                                            } %> </td>
                                        <td> <% out.print(grade);%> </td>

                                    </tr>
                                </tbody>
                            </table>


                            <form action="FileDownload" method="POST">
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <button class="btn btn-info btn-lg btn-block fa fa-download" type="submit"> Download Exam </button>
                            </form>
                            <br>

                            <form id="fileUpload<%= pk%>" action="FileUploadUpdate" method="POST" enctype="multipart/form-data">
                                <h5>Upload Revised Exam</h5>
                                <input type="file" name="fileToUpload" accept=".docx, .pdf"/>
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <!--<button class="fa fa-pencil" type="submit"> Update exam </button>-->
                            </form>
                            <form id="comment<%= pk%>" action="AddComments" method="post">
                                <input type="hidden" name="examPK" value="<%= pk%>">
                                <input type="hidden" name="stage" value=1>
                                <br>Comment On Exam: <br>
                                <textarea name="comment"></textarea> <br> <br>
                            </form>
                            <button onclick="submitForms('fileUpload<%= pk%>', 'comment<%= pk%>')">Submit Exam Review</button>
                        </div>
                        <br>
                        <%}
                            }%>

                    </div>
                </div>
                <%} %>
                <% if (permsInstance.examVetCommittee) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkvetcommit(creds));%>
                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Exam Vetting Committee
                            </button>
                    </div>
                    <div id="collapseThree" class="collapse hide" aria-labelledby="headingThree" data-parent="#accordion">
                        <%                                 ResultSet rs = db.info_examslinkedtopkvetcommit(creds);

                            for (int i = 1; i <= noOfExams; i++) {
                                int no = i;
                                if (rs.next()) {
                                    String mc = rs.getString("module_code");
                                    String title = rs.getString("title");
                                    String onlineorpaper;
                                    if ("0".equals(rs.getString("online_or_paper"))) {
                                        onlineorpaper = "Online Exam";
                                    } else {
                                        onlineorpaper = "Written Exam";
                                    }
                                    String resit;
                                    if ("0".equals(rs.getString("resit"))) {
                                        resit = "Main Exam";
                                    } else {
                                        resit = "Resit Exam";
                                    }
                                    String exam = rs.getString("exam");
                                    String grade;
                                    if ("0".equals(rs.getString("grade"))) {
                                        grade = "Undergraduate Exam";
                                    } else {
                                        grade = "Postgraduate Exam";
                                    }
                                    String pk = rs.getString("exam_pk");
                        %>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Number</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Method</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Exam</th>
                                        <th scope="col">Grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> <% out.print(no); %></th>
                                        <td> <% out.print(mc.toUpperCase()); %> </td>
                                        <td> <% out.print(title); %> </td>
                                        <td> <% out.print(onlineorpaper); %> </td>
                                        <td> <% out.print(resit); %> </td>
                                        <td> <% if (exam == "1") {
                                                out.print("Exam");
                                            } else {
                                                out.print("Exam Soultions");
                                            } %> </td>
                                        <td> <% out.print(grade);%> </td>

                                    </tr>
                                </tbody>
                            </table>


                            <form action="FileDownload" method="POST">
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <button class="btn btn-info btn-lg btn-block fa fa-download" type="submit"> Download Exam </button>
                            </form>
                            <br>

                            <form id="fileUpload<%= pk%>" action="FileUploadUpdate" method="POST" enctype="multipart/form-data">
                                <h5>Upload Revised Exam</h5>
                                <input type="file" name="fileToUpload" accept=".docx, .pdf"/>
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <!--<button class="fa fa-pencil" type="submit"> Update exam </button>-->
                            </form>
                            <form id="comment<%= pk%>" action="AddComments" method="post">
                                <input type="hidden" name="examPK" value="<%= pk%>">
                                <input type="hidden" name="stage" value=2>
                                <br>Comment On Exam: <br>
                                <textarea name="comment"></textarea> <br> <br>
                            </form>
                            <button onclick="submitForms('fileUpload<%= pk%>', 'comment<%= pk%>')">Submit Exam Review</button>
                        </div>
                        <br>
                        <%}
                            } %>

                    </div>
                </div>
                <%} %>
                <% if (permsInstance.externalModerator) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkextmod(creds));
                %>
                <div class="card">
                    <div class="card-header" id="headingFour">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                External Moderator
                            </button>
                    </div>
                    <div id="collapseFour" class="collapse hide" aria-labelledby="headingFour" data-parent="#accordion">
                        <%                                 ResultSet rs = db.info_examslinkedtopkextmod(creds);
                            for (int i = 1; i <= noOfExams; i++) {
                                int no = i;
                                if (rs.next()) {
                                    String mc = rs.getString("module_code");
                                    String title = rs.getString("title");
                                    String onlineorpaper;
                                    if ("0".equals(rs.getString("online_or_paper"))) {
                                        onlineorpaper = "Online Exam";
                                    } else {
                                        onlineorpaper = "Written Exam";
                                    }
                                    String resit;
                                    if ("0".equals(rs.getString("resit"))) {
                                        resit = "Main Exam";
                                    } else {
                                        resit = "Resit Exam";
                                    }
                                    String exam = rs.getString("exam");
                                    String grade;
                                    if ("0".equals(rs.getString("grade"))) {
                                        grade = "Undergraduate Exam";
                                    } else {
                                        grade = "Postgraduate Exam";
                                    }
                                    String pk = rs.getString("exam_pk");
                        %>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Number</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Method</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Exam</th>
                                        <th scope="col">Grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> <% out.print(no); %></th>
                                        <td> <% out.print(mc.toUpperCase()); %> </td>
                                        <td> <% out.print(title); %> </td>
                                        <td> <% out.print(onlineorpaper); %> </td>
                                        <td> <% out.print(resit); %> </td>
                                        <td> <% out.print(exam); %> </td>
                                        <td> <% out.print(grade);%> </td>

                                    </tr>
                                </tbody>
                            </table>


                            <form action="FileDownload" method="POST">
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <button class="btn btn-info btn-lg btn-block fa fa-download" type="submit"> Download Exam </button>
                            </form>
                            <br>

                            <form id="fileUpload<%= pk%>" action="FileUploadUpdate" method="POST" enctype="multipart/form-data">
                                <h5>Upload Revised Exam</h5>
                                <input type="file" name="fileToUpload" accept=".docx, .pdf"/>
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <!--<button class="fa fa-pencil" type="submit"> Update exam </button>-->
                            </form>
                            <form id="comment<%= pk%>" action="AddComments" method="post">
                                <input type="hidden" name="examPK" value="<%= pk%>">
                                <input type="hidden" name="stage" value=3>
                                <br>Comment On Exam: <br>
                                <textarea name="comment"></textarea> <br> <br>
                            </form>
                            <button onclick="submitForms('fileUpload<%= pk%>', 'comment<%= pk%>')">Submit Exam Review</button>

                        </div>
                        <br>
                        <%}
                            } %>

                    </div>
                </div>
                <%} %>
                <% if (permsInstance.office) {
                        int noOfExams = Integer.parseInt(db.number_of_completed_exams(creds));%>
                <div class="card">
                    <div class="card-header" id="headingFive">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                School Office
                            </button>
                    </div>
                    <div id="collapseFive" class="collapse hide" aria-labelledby="headingFive" data-parent="#accordion">
                        <%                                 ResultSet rs = db.info_examslinkedtopkintmod(creds);

                            for (int i = 1; i <= noOfExams; i++) {
                                int no = i;

                                if (rs.next()) {
                                    String mc = rs.getString("module_code");
                                    String title = rs.getString("title");
                                    String onlineorpaper;
                                    if ("0".equals(rs.getString("online_or_paper"))) {
                                        onlineorpaper = "Online Exam";
                                    } else {
                                        onlineorpaper = "Written Exam";
                                    }
                                    String resit;
                                    if ("0".equals(rs.getString("resit"))) {
                                        resit = "Main Exam";
                                    } else {
                                        resit = "Resit Exam";
                                    }
                                    String exam = rs.getString("exam");
                                    String grade;
                                    if ("0".equals(rs.getString("grade"))) {
                                        grade = "Undergraduate Exam";
                                    } else {
                                        grade = "Postgraduate Exam";
                                    }
                                    String pk = rs.getString("exam_pk");

                        %>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Number</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Online or Paper</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Exam</th>
                                        <th scope="col">Grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> <% out.print(no); %></th>
                                        <td> <% out.print(mc.toUpperCase()); %> </td>
                                        <td> <% out.print(title); %> </td>
                                        <td> <% out.print(onlineorpaper); %> </td>
                                        <td> <% out.print(resit); %> </td>
                                        <td> <% out.print(exam); %> </td>
                                        <td> <% out.print(grade);%> </td>

                                    </tr>
                                </tbody>
                            </table>

                            <form action="FileDownload" method="POST">
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <button class="fa fa-download" type="submit"> Download exam </button>
                            </form>
                            <br>

                            <form id="fileUpload<%= pk%>" action="FileUploadUpdate" method="POST" enctype="multipart/form-data">
                                <h5>Upload Revised Exam</h5>
                                <input type="file" name="fileToUpload" accept=".docx, .pdf"/>
                                <input type="hidden" name="examPK" value="<%= pk%>"/>
                                <!--<button class="fa fa-pencil" type="submit"> Update exam </button>-->
                            </form>
                            <form id="comment<%= pk%>" action="AddComments" method="post">
                                <input type="hidden" name="examPK" value="<%= pk%>">
                                <br>Comment On Exam: <br>
                                <textarea name="comment"></textarea> <br> <br>
                            </form>
                            <button onclick="submitForms('fileUpload<%= pk%>', 'comment<%= pk%>')">Submit Exam Review</button>
                        </div>
                        <br>
                        <%}
                            } %>
                    </div>
                </div>
                <%}%>


            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
