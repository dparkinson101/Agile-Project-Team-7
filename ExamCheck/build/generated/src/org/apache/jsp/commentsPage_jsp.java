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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

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
      out.write("\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"dist/css/DCEC.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
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
      out.write("            <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"Admin.jsp\">Dundee Computing Examination Board</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                    <!-- Accessibility -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-universal-access fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-access\">\n");
      out.write("                            <li><a href=\"#\" onclick=resizeText(1)><i class=\"fa fa-text-height fa-2x\"></i>Increase Text Size</a></li>\n");
      out.write("                            <li><a href=\"#\" onclick=resizeText(-1)><i class=\"fa fa-text-height fa-fw\"></i>Decrease Text Size</a></li>\n");
      out.write("                            <li><a href=\"Admin.jsp\"><i class=\"fa fa-text-height fa-fw\"></i>Normal Text Size</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- Alerts Dropdown -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-bell fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-alerts\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <div>\n");
      out.write("                                        <i class=\"fa fa-comment fa-fw\"></i> No New Comments\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <!-- User Dropdown -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-user fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i>");
 out.print(username);
      out.write("</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"divider\"></li>\n");
      out.write("                            <li><a href=\"Log-in.jsp\" onclick=\" if (confirm('Are you sure you want to log out?')) {\n");
      out.write("                                        deleteAllCookies();\n");
      out.write("                                    }\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- Top Links -->\n");
      out.write("\n");
      out.write("                <!-- /.navbar-static-side -->\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("                            <style>\n");
      out.write("                                .borderComment\n");
      out.write("                                {\n");
      out.write("                                    border-style:solid;\n");
      out.write("                                    border-color:#287EC7;\n");
      out.write("                                    border-width:8px;\n");
      out.write("                                }\n");
      out.write("                                table {\n");
      out.write("                                    font-family: arial, sans-serif;\n");
      out.write("                                    border-collapse: collapse;\n");
      out.write("                                    width: 100%;\n");
      out.write("                                 }\n");
      out.write("                            </style>\n");
      out.write("        <script>\n");
      out.write("            function showIntMod{\n");
      out.write("                        this.form['inputComment'].style.display = 'none;';\n");
      out.write("                            }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("                               \n");
      out.write("         <form>\n");
      out.write("             <table border=\"3\">\n");
      out.write("                 <tr>\n");
      out.write("                     <th>Comments from Internal Moderator</th>\n");
      out.write("                     <th>Comments from Exam Vetting Committee</th>\n");
      out.write("                     <th>Comments from External Moderator</th>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                     <td><p>display int comment here</p>\n");
      out.write("                     <td><p>display Exam vet comment here</p>\n");
      out.write("                     <td><p>display External comment here</p>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                     <td><button onclick=\"showIntMod()\" id=\"btn1\">Reply to Internal Moderator</button></td>\n");
      out.write("                     <td><button onclick=\"\" id=\"btn2\">Reply to Exam Vetting Committee</button></td>\n");
      out.write("                     <td><button onclick=\"\"id=\"btn3\">Reply to External Moderator</button></td>\n");
      out.write("                 </tr>\n");
      out.write("             </table>\n");
      out.write("             \n");
      out.write("             \n");
      out.write("             <textarea id=\"inputComment\"rows=\"4\" cols=\"50\" name=\"hiddenText\" style=\"display:none;\">\n");
      out.write("             </textarea>\n");
      out.write("         </form>\n");
      out.write("\n");
      out.write("    </body>\n");
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
