package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import BackEnd.Database;
import BackEnd.Permissions;

public final class listExams_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

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

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"The Mighty Morphin' Matthew Rangers\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Exams</title>\n");
      out.write("        <!-- Jquery !-->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- FONT AWESOME !-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function resizeText(multiplier)\n");
      out.write("        {\n");
      out.write("            if (document.body.style.fontSize == \"\")\n");
      out.write("            {\n");
      out.write("                document.body.style.fontSize = \"1.0em\";\n");
      out.write("            }\n");
      out.write("            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function submitForms(formUpload, formComment) {\n");
      out.write("            var f1 = document.getElementById(formUpload);\n");
      out.write("            var f2 = document.getElementById(formComment);\n");
      out.write("\n");
      out.write("            //sendXMLRequest(f1, \"FileUploadUpdate\");\n");
      out.write("            sendXMLRequest(f2, \"AddComments\");\n");
      out.write("            f1.submit();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function sendXMLRequest(f, page) {\n");
      out.write("            var postData = [];\n");
      out.write("            for (var i = 0; i < f.elements.length; i++) {\n");
      out.write("                postData.push(f.elements[i].name + \"=\" + f.elements[i].value);\n");
      out.write("            }\n");
      out.write("            var xhr = new XMLHttpRequest();\n");
      out.write("            xhr.open(\"POST\", page, true);\n");
      out.write("            xhr.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhr.send(postData.join(\"&\"));\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function deleteAllCookies() {\n");
      out.write("            var cookies = document.cookie.split(\";\");\n");
      out.write("\n");
      out.write("            for (var i = 0; i < cookies.length; i++) {\n");
      out.write("                var cookie = cookies[i];\n");
      out.write("                var eqPos = cookie.indexOf(\"=\");\n");
      out.write("                var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;\n");
      out.write("                document.cookie = name + \"=;expires=Thu, 01 Jan 1970 00:00:00 GMT\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    ");

        Database db = new Database();
        db.connect();
        //String noCompletedExams = db.number_of_completed_exams("1");
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">Dundee Computing Examination Board</a>\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                    <!-- Accessibility !-->\n");
      out.write("                    <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                            <i class=\"fas fa-universal-access fa-lg\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(1)><i class=\"fas fa-text-height fa-2x\"></i>\n");
      out.write("                                Increase text size</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(-1)><i class=\"fas fa-text-height fa-fw\"></i>\n");
      out.write("                                Decrease text size</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"listExams.jsp\"><i class=\"fa fa-text-height fa-fw\"></i> Normal text size</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- Notifications !-->\n");
      out.write("                    <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                            <i class=\"fas fa-bell fa-lg\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-comment\"></i> No new comments</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- User !-->\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                            <i class=\"fas fa-user fa-lg\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-user\"></i> ");
 out.print(username); 
      out.write("</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Log-in.jsp\"onclick=\" if (confirm('Are you sure you want to log out?')) {\n");
      out.write("                                        deleteAllCookies();\n");
      out.write("                                    }\"><i class=\"fas fa-sign-out-alt\"></i> Log out</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            /*
            Database db = new Database();
            db.connect();

            String user_pk = db.getUserPK();
            String result = db.number_examslinkedtopk("1");
            int count = Integer.getInteger(result);
             */
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"accordion\">\n");
      out.write("            ");
 if (permsInstance.examSetter) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopk(creds));
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\" id=\"headingOne\">\n");
      out.write("                    <h5 class=\"mb-0\">\n");
      out.write("                        <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"false\" aria-controls=\"collapseOne\">\n");
      out.write("                            Exam Setter\n");
      out.write("                        </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"collapseOne\" class=\"collapse hide\" aria-labelledby=\"headingOne\" data-parent=\"#accordion\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        ResultSet rs = db.info_examslinkedtopk(creds);
                        for (int i = 0; i < noOfExams; i++) {
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

                    
      out.write("\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        ");
 out.print("Exam Number: " + no); 
      out.write("\n");
      out.write("                        <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\n");
      out.write("\n");
      out.write("                        <form action=\"FileDownload\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\n");
      out.write("                        </form>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h5>Upload Revised Exam</h5>\n");
      out.write("                            <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\n");
      out.write("                        </form>\n");
      out.write("                        <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"stage\" value=0>\n");
      out.write("                            <br>Comment On Exam: <br>\n");
      out.write("                            <textarea name=\"comment\"></textarea> <br> <br>\n");
      out.write("                        </form>\n");
      out.write("                        <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    ");
}
                            } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            ");
 if (permsInstance.internalModerator) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkintmod(creds));
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\" id=\"headingTwo\">\n");
      out.write("                    <h5 class=\"mb-0\">\n");
      out.write("                        <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">\n");
      out.write("                            Internal Moderator\n");
      out.write("                        </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"collapseTwo\" class=\"collapse hide\" aria-labelledby=\"headingTwo\" data-parent=\"#accordion\">\n");
      out.write("\n");
      out.write("                    ");
 for (int i = 0; i < noOfExams; i++) {
                            int no = i;
                            ResultSet rs = db.info_examslinkedtopkintmod(creds);
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
                    
      out.write("\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        ");
 out.print("Exam Number: " + no); 
      out.write("\n");
      out.write("                        <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\n");
      out.write("\n");
      out.write("                        <form action=\"FileDownload\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\n");
      out.write("                        </form>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h5>Upload Revised Exam</h5>\n");
      out.write("                            <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\n");
      out.write("                        </form>\n");
      out.write("                        <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"stage\" value=1>\n");
      out.write("                            <br>Comment On Exam: <br>\n");
      out.write("                            <textarea name=\"comment\"></textarea> <br> <br>\n");
      out.write("                        </form>\n");
      out.write("                        <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    ");
}
                            }
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            ");
 if (permsInstance.examVetCommittee) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkvetcommit(creds));
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\" id=\"headingThree\">\n");
      out.write("                    <h5 class=\"mb-0\">\n");
      out.write("                        <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">\n");
      out.write("                            Exam Vetting Committee\n");
      out.write("                        </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"collapseThree\" class=\"collapse hide\" aria-labelledby=\"headingThree\" data-parent=\"#accordion\">\n");
      out.write("                    ");
 for (int i = 0; i < noOfExams; i++) {
                            int no = i;
                            ResultSet rs = db.info_examslinkedtopkvetcommit(creds);
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
                    
      out.write("\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        ");
 out.print("Exam Number: " + no); 
      out.write("\n");
      out.write("                        <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\n");
      out.write("\n");
      out.write("                        <form action=\"FileDownload\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\n");
      out.write("                        </form>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h5>Upload Revised Exam</h5>\n");
      out.write("                            <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\n");
      out.write("                        </form>\n");
      out.write("                        <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"stage\" value=2>\n");
      out.write("                            <br>Comment On Exam: <br>\n");
      out.write("                            <textarea name=\"comment\"></textarea> <br> <br>\n");
      out.write("                        </form>\n");
      out.write("                        <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    ");
}
                            } 
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            ");
 if (permsInstance.externalModerator) {
                    int noOfExams = Integer.parseInt(db.number_examslinkedtopkextmod(creds));
            
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\" id=\"headingFour\">\n");
      out.write("                    <h5 class=\"mb-0\">\n");
      out.write("                        <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseFour\" aria-expanded=\"false\" aria-controls=\"collapseFour\">\n");
      out.write("                            External Moderator\n");
      out.write("                        </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"collapseFour\" class=\"collapse hide\" aria-labelledby=\"headingFour\" data-parent=\"#accordion\">\n");
      out.write("                    ");
 for (int i = 0; i < 5; i++) {
                            int no = i;
                            ResultSet rs = db.info_examslinkedtopkextmod(creds);
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
                    
      out.write("\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        ");
 out.print("Exam Number: " + no); 
      out.write("\n");
      out.write("                        <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\n");
      out.write("\n");
      out.write("                        <form action=\"FileDownload\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\n");
      out.write("                        </form>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h5>Upload Revised Exam</h5>\n");
      out.write("                            <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\n");
      out.write("                        </form>\n");
      out.write("                        <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"stage\" value=3>\n");
      out.write("                            <br>Comment On Exam: <br>\n");
      out.write("                            <textarea name=\"comment\"></textarea> <br> <br>\n");
      out.write("                        </form>\n");
      out.write("                        <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                        <br>\n");
      out.write("                    ");
}
                            } 
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            ");
 if (permsInstance.office) {
                        int noOfExams = Integer.parseInt(db.number_of_completed_exams(creds));
      out.write("%>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\" id=\"headingFive\">\n");
      out.write("                    <h5 class=\"mb-0\">\n");
      out.write("                        <button class=\"btn btn-link\" data-toggle=\"collapse\" data-target=\"#collapseFive\" aria-expanded=\"false\" aria-controls=\"collapseFive\">\n");
      out.write("                            School OFfice\n");
      out.write("                        </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"collapseFive\" class=\"collapse hide\" aria-labelledby=\"headingFive\" data-parent=\"#accordion\">\n");
      out.write("                    ");
 for (int i = 0; i < noOfExams; i++) {
                            int no = i;

                            ResultSet rs = db.info_examslinkedtopk(creds);
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

                    
      out.write("\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        ");
 out.print("Exam Number: " + no); 
      out.write("\n");
      out.write("                        <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\n");
      out.write("                        <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\n");
      out.write("\n");
      out.write("                        <form action=\"FileDownload\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\n");
      out.write("                        </form>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h5>Upload Revised Exam</h5>\n");
      out.write("                            <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\n");
      out.write("                            <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\n");
      out.write("                        </form>\n");
      out.write("                        <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\n");
      out.write("                            <br>Comment On Exam: <br>\n");
      out.write("                            <textarea name=\"comment\"></textarea> <br> <br>\n");
      out.write("                        </form>\n");
      out.write("                        <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    ");
}
                            } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
