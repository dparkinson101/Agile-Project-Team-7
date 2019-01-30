package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BackEnd.Database;

public final class CreateExam_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>Create An Exam</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- JQUERY !-->\r\n");
      out.write("        <script src=\"./vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <!-- BOOTSTRAP !-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"./vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- FONT AWESOME !-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function resizeText(multiplier) {\r\n");
      out.write("                if (document.body.style.fontSize === \"\") {\r\n");
      out.write("                    document.body.style.fontSize = \"1.0em\";\r\n");
      out.write("                }\r\n");
      out.write("                document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        ");

            HttpSession spoons = request.getSession();
            String username = (String) spoons.getAttribute("email");
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">Dundee Computing Examination Board</a>\r\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("                <!-- Accessibility !-->\r\n");
      out.write("                <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fas fa-universal-access fa-lg\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(1)><i class=\"fas fa-text-height fa-2x\"></i>\r\n");
      out.write("                            Increase text size</a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(-1)><i class=\"fas fa-text-height fa-fw\"></i>\r\n");
      out.write("                            Decrease text size</a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"CreateExam.jsp\"><i class=\"fa fa-text-height fa-fw\"></i> Normal text size</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- Notifications !-->\r\n");
      out.write("                <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fas fa-bell fa-lg\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-comment\"></i> No new comments</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- User !-->\r\n");
      out.write("                <li class=\"nav-item dropdown\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fas fa-user fa-lg\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-user\"></i> ");
 out.print(username);
      out.write("</a>\r\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"Log-in.jsp\"onclick=\" if (confirm('Are you sure you want to log out?')) {\r\n");
      out.write("                                    deleteAllCookies();\r\n");
      out.write("                                }\"><i class=\"fas fa-sign-out-alt\"></i> Log out</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <br><br><br><br><br>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form action=\"FileUpload\" method=\"POST\" id=\"examDetails\" enctype=\"multipart/form-data\" class=\"form-upload align-content-center text-center\">\r\n");
      out.write("                <h1 class=\"text-center\">🐱‍👓</h1>\r\n");
      out.write("                <h1 class=\"h1 font-weight-normal\">Create a new Exam</h1>\r\n");
      out.write("                <div class=\"form-group w-50 mx-auto\">\r\n");
      out.write("                    <label for=\"moduleCode\">Module code</label>\r\n");
      out.write("                    <input type=\"text\" name=\"moduleCode\" id=\"modCode\" class=\"form-control\" required>\r\n");
      out.write("                    <label for=\"moduleTitle\">Module title</label>\r\n");
      out.write("                    <input type=\"text\" name=\"moduleTitle\" id=\"modTitle\" class=\"form-control\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group w-50 mx-auto\">\r\n");
      out.write("                    <label for=\"examChoice\">Exam Options</label>\r\n");
      out.write("                    <select class=\"custom-select\" name=\"examChoice\">\r\n");
      out.write("                        <option value=\"0\" selected>Main exam</option>\r\n");
      out.write("                        <option value=\"1\">Resit</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group w-50 mx-auto\">\r\n");
      out.write("                    <label for=\"examType\" class=\"sr-only\">Exam type</label>\r\n");
      out.write("                    <select class=\"custom-select\" name=\"examType\">\r\n");
      out.write("                        <option value=\"0\" selected>Online</option>\r\n");
      out.write("                        <option value=\"1\">Written</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group w-50 mx-auto\">\r\n");
      out.write("                    <label for=\"examLevel\" class=\"sr-only\">Exam type</label>\r\n");
      out.write("                    <select class=\"custom-select\" name=\"ExamLevel\">\r\n");
      out.write("                        <option value=\"0\" selected>Undergraduate</option>\r\n");
      out.write("                        <option value=\"1\">Postgraduate</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group w-50 mx-auto\">\r\n");
      out.write("                    <label for=\"fileToUpload\">Select a file to upload:</label>\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <div class=\"input-group-prepend\">\r\n");
      out.write("                            <span class=\"input-group-text\">Upload</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"custom-file\">\r\n");
      out.write("                            <input type=\"file\" class=\"custom-file-input\" id=\"fileToUpload\" name=\"fileToUpload\" accept=\".docx, .pdf\">\r\n");
      out.write("                            <label class=\"custom-file-label text-left\" for=\"fileToUpload\"></label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <script>\r\n");
      out.write("                        $('input[type=\"file\"]').change(function (e) {\r\n");
      out.write("                            var fileName = e.target.files[0].name;\r\n");
      out.write("                            $('.custom-file-label').html(fileName);\r\n");
      out.write("                        });\r\n");
      out.write("                    </script>\r\n");
      out.write("                </div>\r\n");
      out.write("                <button type=\"submit\" form=\"examDetails\" value=\"submit\" class=\"btn btn-block btn-success w-25 mx-auto\">Assign</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!--            <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-12\">\r\n");
      out.write("                            <h1 class=\"page-header\">Create a new Exam</h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                         /.col-lg-12 \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form action=\"FileUpload\" method=\"post\" id=\"examDetails\" enctype=\"multipart/form-data\">\r\n");
      out.write("                        Module Code: <br>\r\n");
      out.write("                        <input type=\"text\" name=\"moduleCode\" id=\"modCode\"><br><br>\r\n");
      out.write("                        Module Title: <br>\r\n");
      out.write("                        <input type=\"text\" name=\"moduleTitle\" id=\"modTitle\"><br><br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"examType\" value=\"0\" id=\"onlineRad\"> Online<br>  0=Online 1=Written \r\n");
      out.write("                        <input type=\"radio\" name=\"examType\" value=\"1\" id=\"writtenRad\"> Written<br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"examChoice\" value=\"0\" id=\"mainRad\"> Main Exam<br>  0=Main Exam 1=Resit Exam \r\n");
      out.write("                        <input type=\"radio\" name=\"examChoice\" value=\"1\" id=\"resitRad\"> Resit Exam<br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"examLevel\" value=\"0\" id=\"UndergradRad\"> Undergrad Exam<br>  0=Undergrad 1=Postgrad \r\n");
      out.write("                        <input type=\"radio\" name=\"examLevel\" value=\"1\" id=\"PostgradRad\"> Postgrad Exam<br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        Select a file to upload: <br><br>\r\n");
      out.write("                        <input type=\"file\" name=\"fileToUpload\" accept=\".docx, .pdf\"/>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <button type=\"submit\" form=\"examDetails\" value=\"submit\">Submit Exam</button>\r\n");
      out.write("                    </form>-->\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
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
