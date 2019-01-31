package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BackEnd.Permissions;
import BackEnd.Security;
import java.sql.ResultSet;
import BackEnd.Database;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("\r\n");

    String perms = "";
    String userPK = "";
    String username = "";
    String base64 = "";
    String sessionVar = "";
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("permissions")) {
                perms = cookie.getValue();
            }
            if (cookie.getName().equals("user")) {
                userPK = cookie.getValue();
                Database db = new Database();

                ResultSet rs = db.executeQuery("select username from users where user_pk = '" + userPK + "';");
                rs.first();
                username = rs.getString("username");
            }
            if(cookie.getName().equals("secretClass")){
                base64 = cookie.getValue();
            }
        }
    }
    
    sessionVar = request.getSession().getId();
    
    Security secure = new Security();
    try{
        Permissions permissionsObject = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
    }
    catch(Exception e){
        System.out.println("Error Getting Permissions Object: The Session Variable May Have Changed!");
        request.changeSessionId();
        
        //Deletes Cookies
        for(Cookie c : request.getCookies()){
            Cookie cookie = new Cookie(c.getName(), "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        response.sendRedirect("Log-in.jsp");
    }
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>ExamCheck Home</title>\r\n");
      out.write("        <!-- JQUERY !-->\r\n");
      out.write("        <script src=\"./vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <!-- BOOTSTRAP !-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"./vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- FONT AWESOME !-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("            <script>\r\n");
      out.write("        function resizeText(multiplier) {\r\n");
      out.write("            if (document.body.style.fontSize === \"\") {\r\n");
      out.write("                document.body.style.fontSize = \"1.0em\";\r\n");
      out.write("            }\r\n");
      out.write("            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\r\n");
      out.write("        }\r\n");
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
      out.write("        <!-- Navbar !-->\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Dundee Computing Examination Board</a>\r\n");
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
      out.write("                        <a class=\"dropdown-item\" href=\"index.jsp\"><i class=\"fa fa-text-height fa-fw\"></i> Normal text size</a>\r\n");
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
      out.print(username );
      out.write("</a>\r\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"Log-in.jsp\" onclick=\"deleteAllCookies()\"><i class=\"fas fa-sign-out-alt\"></i> Log out</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <h1 class=\"page-header\">Exams</h1>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <!-- Completed Exams !-->\r\n");
      out.write("                <div class=\"col-sm-4\">\r\n");
      out.write("                    <div class=\"card border-success\">\r\n");
      out.write("                        <div class=\"card-header bg-success text-light\">\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                                <i class=\"fas fa-check fa-5x fa-pull-left\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\r\n");
      out.write("                                <span style=\"font-size: 40px;\">8</span>\r\n");
      out.write("                                <p class=\"text-right\">Completed Exams</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"listExams.jsp\" class=\"text-success text-decoration-none\">\r\n");
      out.write("                            <div class=\"card-footer\">\r\n");
      out.write("                                <span>View Exams</span>\r\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- In Progress Exams !-->\r\n");
      out.write("                <div class=\"col-sm-4\">\r\n");
      out.write("                    <div class=\"card border-warning\">\r\n");
      out.write("                        <div class=\"card-header bg-warning text-light\">\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                                <i class=\"fas fa-tasks fa-5x fa-pull-left\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\r\n");
      out.write("                                <span style=\"font-size: 40px;\">2</span>\r\n");
      out.write("                                <p class=\"text-right\">In Progress Exams</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"listExams.jsp\" class=\"text-warning text-decoration-none\">\r\n");
      out.write("                            <div class=\"card-footer\">\r\n");
      out.write("                                <span>View Exams</span>\r\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- New Exams !-->\r\n");
      out.write("                <div class=\"col-sm-4\">\r\n");
      out.write("                    <div class=\"card border-danger\">\r\n");
      out.write("                        <div class=\"card-header bg-danger text-light\">\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                                <i class=\"fas fa-file fa-5x fa-pull-left\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\r\n");
      out.write("                                <span style=\"font-size: 40px;\">4</span>\r\n");
      out.write("                                <p class=\"text-right\">New Exams</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"CreateExam.jsp\" class=\"text-danger text-decoration-none\">\r\n");
      out.write("                            <div class=\"card-footer\">\r\n");
      out.write("                                <span>View Exams</span>\r\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <h1 class=\"page-header\">Administrator tools</h1>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("                <!--\r\n");
      out.write("\t\t\tADMIN\r\n");
      out.write("\t\t!-->\r\n");
      out.write("\t\t<!-- Add new user !-->\r\n");
      out.write("\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t<div class=\"card border-dark\">\r\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">Add new user</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"newUser\" action=\"createAccount\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"firstName\" >First name(s)</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"fName\" class=\"form-control\" id=\"firstName\" required>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"surname\">Surname</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"sName\" class=\"form-control\" id=\"surname\" required>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"email\">Dundee University E-mail</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"email\" name=\"email\" class=\"form-control\" id=\"email\" required>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"password\">Password</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"pass\" class=\"form-control\" id=\"password\" required>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <input type=\"checkbox\" name=\"exSet\" id=\"Setter\" value=\"TRUE\"> Exam Setter<br>\r\n");
      out.write("                                                    <input type=\"checkbox\" name=\"intMod\" id=\"IntMod\" value=\"TRUE\"> Internal Moderator<br>\r\n");
      out.write("                                                    <input type=\"checkbox\" name=\"exVet\" id=\"Vetting\" value=\"TRUE\"> Exam Vetting Comittee<br>\r\n");
      out.write("                                                    <input type=\"checkbox\" name=\"exMod\" id=\"ExtMod\" value=\"TRUE\"> External Moderator<br>\r\n");
      out.write("                                                    <input type=\"checkbox\" name=\"schOff\" id=\"Office\" value=\"TRUE\"> School Office<br>\r\n");
      out.write("                                                </div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">Submit</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- Assign user !-->\r\n");
      out.write("\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t<div class=\"card border-dark\">\r\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">Assign user</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"assignUser\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"role\">Role</label>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"role\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select role</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Internal Moderator</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>External Moderator</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Exam Vetting Committee Member</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"user\">User</label>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"user\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select user</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>User 1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>User 2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"examAssign\">Exam</label>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"examAssign\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select exam</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Exam</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Resit</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">Assign</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- View unsigned exams !-->\r\n");
      out.write("\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t<div class=\"card border-dark\">\r\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">View in progress exams</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"viewExam\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"stage\">Stage</label>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"stage\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select stage</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Internal Moderating</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>External Moderating</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Exam Vetting Committee</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"examView\">Exam</label>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"examView\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select exam</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Exam</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Resit</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">View</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
