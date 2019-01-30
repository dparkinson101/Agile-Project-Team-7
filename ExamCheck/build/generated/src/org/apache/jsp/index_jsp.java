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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("\n");

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
    

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>ExamCheck Home</title>\n");
      out.write("        <!-- JQUERY !-->\n");
      out.write("        <script src=\"./vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <!-- BOOTSTRAP !-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"./vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- FONT AWESOME !-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function resizeText(multiplier) {\n");
      out.write("            if (document.body.style.fontSize === \"\") {\n");
      out.write("                document.body.style.fontSize = \"1.0em\";\n");
      out.write("            }\n");
      out.write("            document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\n");
      out.write("        }\n");
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
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Navbar !-->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Dundee Computing Examination Board</a>\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <!-- Accessibility !-->\n");
      out.write("                <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                        <i class=\"fas fa-universal-access fa-lg\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(1)><i class=\"fas fa-text-height fa-2x\"></i>\n");
      out.write("                            Increase text size</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\" onclick=resizeText(-1)><i class=\"fas fa-text-height fa-fw\"></i>\n");
      out.write("                            Decrease text size</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"index.jsp\"><i class=\"fa fa-text-height fa-fw\"></i> Normal text size</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <!-- Notifications !-->\n");
      out.write("                <li class=\"nav-item dropdown\" style=\"padding-right: 10px\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                        <i class=\"fas fa-bell fa-lg\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-comment\"></i> No new comments</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <!-- User !-->\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\">\n");
      out.write("                        <i class=\"fas fa-user fa-lg\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"><i class=\"fas fa-user\"></i> ");
      out.print(username );
      out.write("</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"Log-in.jsp\" onclick=\"deleteAllCookies()\"><i class=\"fas fa-sign-out-alt\"></i> Log out</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <h1 class=\"page-header\">Exams</h1>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- Completed Exams !-->\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"card border-success\">\n");
      out.write("                        <div class=\"card-header bg-success text-light\">\n");
      out.write("                            <div class=\"col-xs-3\">\n");
      out.write("                                <i class=\"fas fa-check fa-5x fa-pull-left\"></i>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\n");
      out.write("                                <span style=\"font-size: 40px;\">8</span>\n");
      out.write("                                <p class=\"text-right\">Completed Exams</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"listExams.jsp\" class=\"text-success text-decoration-none\">\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                                <span>View Exams</span>\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- In Progress Exams !-->\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"card border-warning\">\n");
      out.write("                        <div class=\"card-header bg-warning text-light\">\n");
      out.write("                            <div class=\"col-xs-3\">\n");
      out.write("                                <i class=\"fas fa-tasks fa-5x fa-pull-left\"></i>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\n");
      out.write("                                <span style=\"font-size: 40px;\">2</span>\n");
      out.write("                                <p class=\"text-right\">In Progress Exams</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"listExams.jsp\" class=\"text-warning text-decoration-none\">\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                                <span>View Exams</span>\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- New Exams !-->\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"card border-danger\">\n");
      out.write("                        <div class=\"card-header bg-danger text-light\">\n");
      out.write("                            <div class=\"col-xs-3\">\n");
      out.write("                                <i class=\"fas fa-file fa-5x fa-pull-left\"></i>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-9 text-right text-light\">\n");
      out.write("                                <span style=\"font-size: 40px;\">4</span>\n");
      out.write("                                <p class=\"text-right\">New Exams</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"CreateExam.jsp\" class=\"text-danger text-decoration-none\">\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                                <span>View Exams</span>\n");
      out.write("                                <i class=\"fa fa-arrow-circle-right fa-pull-right\"></i>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <h1 class=\"page-header\">Administrator tools</h1>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("                <!--\n");
      out.write("\t\t\tADMIN\n");
      out.write("\t\t!-->\n");
      out.write("\t\t<!-- Add new user !-->\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<div class=\"card border-dark\">\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">Add new user</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"card-body\">\n");
      out.write("\t\t\t\t\t<form id=\"newUser\" action=\"\">\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"firstName\">First name(s)</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"firstName\" required>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"surname\">Surname</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"surname\" required>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"email\">Dundee University E-mail</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" id=\"email\" required>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"password\">Password</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"password\" required>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <input type=\"checkbox\" name=\"Exam Setter\" value=\"1\" id=\"Setter\"> Exam Setter<br>\n");
      out.write("                                                    <input type=\"checkbox\" name=\"Internal Moderator\" value=\"1\" id=\"IntMod\"> Internal Moderator<br>\n");
      out.write("                                                    <input type=\"checkbox\" name=\"Exam Vet\" value=\"1\" id=\"Vetting\"> Exam Vetting Comittee<br>\n");
      out.write("                                                    <input type=\"checkbox\" name=\"External Moderator\" value=\"1\" id=\"ExtMod\"> External Moderator<br>\n");
      out.write("                                                    <input type=\"checkbox\" name=\"SchoolOffice\" value=\"1\" id=\"Office\"> School Office<br>\n");
      out.write("                                                </div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">Submit</button>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- Assign user !-->\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<div class=\"card border-dark\">\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">Assign user</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"card-body\">\n");
      out.write("\t\t\t\t\t<form id=\"assignUser\">\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"role\">Role</label>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"role\">\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select role</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Internal Moderator</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>External Moderator</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Exam Vetting Committee Member</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"user\">User</label>\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"user\">\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select user</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>User 1</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>User 2</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"examAssign\">Exam</label>\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"examAssign\">\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select exam</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Exam</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Resit</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">Assign</button>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- View unsigned exams !-->\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<div class=\"card border-dark\">\n");
      out.write("\t\t\t\t<div class=\"card-header text-center text-light bg-dark\">\n");
      out.write("\t\t\t\t\t<h4 class=\"card-title\">View in progress exams</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"card-body\">\n");
      out.write("\t\t\t\t\t<form id=\"viewExam\">\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"stage\">Stage</label>\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"stage\">\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select stage</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Internal Moderating</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>External Moderating</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Exam Vetting Committee</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"examView\">Exam</label>\n");
      out.write("\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"examView\">\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>Select exam</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Exam</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>AC31007 - Resit</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Cont...</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-success\">View</button>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("</body>\n");
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
