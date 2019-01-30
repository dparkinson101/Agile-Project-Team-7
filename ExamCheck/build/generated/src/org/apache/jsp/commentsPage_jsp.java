package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import BackEnd.Database;

public final class commentsPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("        <!-- Bootstrap Core CSS -->\r\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom CSS -->\r\n");
      out.write("        <link href=\"dist/css/DCEC.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom Fonts -->\r\n");
      out.write("        <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
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
      out.write("            <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"Admin.jsp\">Dundee Computing Examination Board</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.navbar-header -->\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("                    <!-- Accessibility -->\r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                            <i class=\"fa fa-universal-access fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-access\">\r\n");
      out.write("                            <li><a href=\"#\" onclick=resizeText(1)><i class=\"fa fa-text-height fa-2x\"></i>Increase Text Size</a></li>\r\n");
      out.write("                            <li><a href=\"#\" onclick=resizeText(-1)><i class=\"fa fa-text-height fa-fw\"></i>Decrease Text Size</a></li>\r\n");
      out.write("                            <li><a href=\"Admin.jsp\"><i class=\"fa fa-text-height fa-fw\"></i>Normal Text Size</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <!-- Alerts Dropdown -->\r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                            <i class=\"fa fa-bell fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-alerts\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">\r\n");
      out.write("                                    <div>\r\n");
      out.write("                                        <i class=\"fa fa-comment fa-fw\"></i> No New Comments\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <!-- User Dropdown -->\r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                            <i class=\"fa fa-user fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-user\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i>");
 out.print(username);
      out.write("</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"divider\"></li>\r\n");
      out.write("                            <li><a href=\"Log-in.jsp\" onclick=\" if (confirm('Are you sure you want to log out?')) {\r\n");
      out.write("                                        deleteAllCookies();\r\n");
      out.write("                                    }\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- Top Links -->\r\n");
      out.write("\r\n");
      out.write("                <!-- /.navbar-static-side -->\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("                            <style>\r\n");
      out.write("                                .borderComment\r\n");
      out.write("                                {\r\n");
      out.write("                                    border-style:solid;\r\n");
      out.write("                                    border-color:#287EC7;\r\n");
      out.write("                                    border-width:8px;\r\n");
      out.write("                                }\r\n");
      out.write("                            </style>\r\n");
      out.write("         <form>\r\n");
      out.write("                <div class=\"borderComment\">\r\n");
      out.write("                    <p>From Internal Moderator: </p>\r\n");
      out.write("                    <p> (int mod message here)</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                <div class=\"borderComment\">\r\n");
      out.write("                    <!--<p> Comment here: </p><br> -->\r\n");
      out.write("                    <textarea type=\"text\" name=\"submitComment\" value=\"Comment here\" rows=\"4\" cols=\"50\">\r\n");
      out.write("                    </textarea>\r\n");
      out.write("                    <input type=\"submit\" value=\"Reply\" id=\"submitButton\">          \r\n");
      out.write("                </div>\r\n");
      out.write("        </form>\r\n");
      out.write("                            \r\n");
      out.write("\r\n");
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
