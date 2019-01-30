package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import BackEnd.Database;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"The Mighty Morphin' Matthew Rangers\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>Exams</title>\r\n");
      out.write("        <!-- Jquery !-->\r\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap Core CSS -->\r\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <!-- FONT AWESOME !-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function resizeText(multiplier)\r\n");
      out.write("        {\r\n");
      out.write("            if (document.body.style.fontSize == \"\")\r\n");
      out.write("            {\r\n");
      out.write("                document.body.style.fontSize = \"1.0em\";\r\n");
      out.write("            }\r\n");
      out.write("            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function submitForms(formUpload, formComment) {\r\n");
      out.write("            var f1 = document.getElementById(formUpload);\r\n");
      out.write("            var f2 = document.getElementById(formComment);\r\n");
      out.write("\r\n");
      out.write("            //sendXMLRequest(f1, \"FileUploadUpdate\");\r\n");
      out.write("            sendXMLRequest(f2, \"AddComments\");\r\n");
      out.write("            f1.submit();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function sendXMLRequest(f, page) {\r\n");
      out.write("            var postData = [];\r\n");
      out.write("            for (var i = 0; i < f.elements.length; i++) {\r\n");
      out.write("                postData.push(f.elements[i].name + \"=\" + f.elements[i].value);\r\n");
      out.write("            }\r\n");
      out.write("            var xhr = new XMLHttpRequest();\r\n");
      out.write("            xhr.open(\"POST\", page, true);\r\n");
      out.write("            xhr.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("            xhr.send(postData.join(\"&\"));\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function deleteAllCookies() {\r\n");
      out.write("            var cookies = document.cookie.split(\";\");\r\n");
      out.write("\r\n");
      out.write("            for (var i = 0; i < cookies.length; i++) {\r\n");
      out.write("                var cookie = cookies[i];\r\n");
      out.write("                var eqPos = cookie.indexOf(\"=\");\r\n");
      out.write("                var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;\r\n");
      out.write("                document.cookie = name + \"=;expires=Thu, 01 Jan 1970 00:00:00 GMT\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    ");

        Database db = new Database();
        db.connect();
        //String noCompletedExams = db.number_of_completed_exams("1");
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Navigation -->\r\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">Dundee Computing Examination Board</a>\r\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("                    <!-- Accessibility !-->\r\n");
      out.write("                    <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\r\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <i class=\"fas fa-universal-access fa-lg\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(1)><i class=\"fas fa-text-height fa-2x\"></i>\r\n");
      out.write("                                Increase text size</a>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(-1)><i class=\"fas fa-text-height fa-fw\"></i>\r\n");
      out.write("                                Decrease text size</a>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"listExams.jsp\"><i class=\"fa fa-text-height fa-fw\"></i> Normal text size</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <!-- Notifications !-->\r\n");
      out.write("                    <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\r\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <i class=\"fas fa-bell fa-lg\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-comment\"></i> No new comments</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <!-- User !-->\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <i class=\"fas fa-user fa-lg\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-user\"></i> ");
 out.print(username); 
      out.write("</a>\r\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Log-in.jsp\"onclick=\" if (confirm('Are you sure you want to log out?')) {\r\n");
      out.write("                                        deleteAllCookies();\r\n");
      out.write("                                    }\"><i class=\"fas fa-sign-out-alt\"></i> Log out</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");

            /*
            Database db = new Database();
            db.connect();

            String user_pk = db.getUserPK();
            String result = db.number_examslinkedtopk("1");
            int count = Integer.getInteger(result);
             */
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"panel-group\" id=\"exams\">\r\n");
      out.write("                ");
 if (perms.contains("examSetter")) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopk(creds));
      out.write("\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h4 class=\"panel-title\">\r\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse1\">Exam Setter</a>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapse1\" class=\"panel-collapse collapse in\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ");

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

                        
      out.write("\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            ");
 out.print("Exam Number: " + no); 
      out.write("\r\n");
      out.write("                            <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"FileDownload\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <br>\r\n");
      out.write("\r\n");
      out.write("                            <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                <h5>Upload Revised Exam</h5>\r\n");
      out.write("                                <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"stage\" value=0>\r\n");
      out.write("                                <br>Comment On Exam: <br>\r\n");
      out.write("                                <textarea name=\"comment\"></textarea> <br> <br>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
}
                            } 
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("                ");
 if (perms.contains("internalModerator")) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkintmod(creds));
      out.write("\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h4 class=\"panel-title\">\r\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse2\">Internal Moderator</a>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapse2\" class=\"panel-collapse collapse\">\r\n");
      out.write("\r\n");
      out.write("                        ");
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
                        
      out.write("\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            ");
 out.print("Exam Number: " + no); 
      out.write("\r\n");
      out.write("                            <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"FileDownload\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <br>\r\n");
      out.write("\r\n");
      out.write("                            <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                <h5>Upload Revised Exam</h5>\r\n");
      out.write("                                <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"stage\" value=1>\r\n");
      out.write("                                <br>Comment On Exam: <br>\r\n");
      out.write("                                <textarea name=\"comment\"></textarea> <br> <br>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
}
                            }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("                ");
 if (perms.contains("examVetCommittee")) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkvetcommit(creds));
      out.write("\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h4 class=\"panel-title\">\r\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse3\">Exam Vetting Committee</a>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapse3\" class=\"panel-collapse collapse\">\r\n");
      out.write("                        ");
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
                        
      out.write("\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            ");
 out.print("Exam Number: " + no); 
      out.write("\r\n");
      out.write("                            <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"FileDownload\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <br>\r\n");
      out.write("\r\n");
      out.write("                            <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                <h5>Upload Revised Exam</h5>\r\n");
      out.write("                                <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"stage\" value=2>\r\n");
      out.write("                                <br>Comment On Exam: <br>\r\n");
      out.write("                                <textarea name=\"comment\"></textarea> <br> <br>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
}
                            } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("                ");
 if (perms.contains("externalModerator")) {
                        int noOfExams = Integer.parseInt(db.number_examslinkedtopkextmod(creds));
                
      out.write("\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h4 class=\"panel-title\">\r\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse4\">External Moderator</a>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapse4\" class=\"panel-collapse collapse\">\r\n");
      out.write("                        ");
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
                        
      out.write("\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            ");
 out.print("Exam Number: " + no); 
      out.write("\r\n");
      out.write("                            <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"FileDownload\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <br>\r\n");
      out.write("\r\n");
      out.write("                            <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                <h5>Upload Revised Exam</h5>\r\n");
      out.write("                                <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"stage\" value=3>\r\n");
      out.write("                                <br>Comment On Exam: <br>\r\n");
      out.write("                                <textarea name=\"comment\"></textarea> <br> <br>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
}
                            } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("                ");
 if (perms.contains("office")) {
                        int noOfExams = Integer.parseInt(db.number_of_completed_exams(creds));
      out.write("%>\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h4 class=\"panel-title\">\r\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse5\">School Office</a>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapse5\" class=\"panel-collapse collapse\">\r\n");
      out.write("                        ");
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

                        
      out.write("\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            ");
 out.print("Exam Number: " + no); 
      out.write("\r\n");
      out.write("                            <p class=\"mb-1\">Module Code: ");
 out.print(mc); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Title: ");
 out.print(title); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Online or Paper: ");
 out.print(onlineorpaper); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Resit: ");
 out.print(resit); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Exam: ");
 out.print(exam); 
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-1\">Grade: ");
 out.print(grade);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"FileDownload\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <button class=\"fa fa-download\" type=\"submit\"> Download exam </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <br>\r\n");
      out.write("\r\n");
      out.write("                            <form id=\"fileUpload");
      out.print( pk);
      out.write("\" action=\"FileUploadUpdate\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                <h5>Upload Revised Exam</h5>\r\n");
      out.write("                                <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\"/>\r\n");
      out.write("                                <!--<button class=\"fa fa-pencil\" type=\"submit\"> Update exam </button>-->\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <form id=\"comment");
      out.print( pk);
      out.write("\" action=\"AddComments\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"examPK\" value=\"");
      out.print( pk);
      out.write("\">\r\n");
      out.write("                                <br>Comment On Exam: <br>\r\n");
      out.write("                                <textarea name=\"comment\"></textarea> <br> <br>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <button onclick=\"submitForms('fileUpload");
      out.print( pk);
      out.write("', 'comment");
      out.print( pk);
      out.write("')\">Submit Exam Review</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
}
                            } 
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery -->\r\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom Theme JavaScript -->\r\n");
      out.write("        <script src=\"dist/js/DCEC.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
