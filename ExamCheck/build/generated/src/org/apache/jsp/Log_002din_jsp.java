package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Log_002din_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Log-In</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \n");
      out.write("        <style>\n");
      out.write("            html,\n");
      out.write("            body {\n");
      out.write("                height: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                display: -ms-flexbox;\n");
      out.write("                display: flex;\n");
      out.write("                -ms-flex-align: center;\n");
      out.write("                align-items: center;\n");
      out.write("                padding-top: 40px;\n");
      out.write("                padding-bottom: 40px;\n");
      out.write("                background-color: #f5f5f5;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-form {\n");
      out.write("                width: 100%;\n");
      out.write("                max-width: 400px;\n");
      out.write("                padding: 15px;\n");
      out.write("                margin: auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function deleteAllCookies() {\n");
      out.write("                var cookies = document.cookie.split(\";\");\n");
      out.write("                for (var i = 0; i < cookies.length; i++) {\n");
      out.write("                    var cookie = cookies[i];\n");
      out.write("                    var eqPos = cookie.indexOf(\"=\");\n");
      out.write("                    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;\n");
      out.write("                    document.cookie = name + \"=;expires=Thu, 01 Jan 1970 00:00:00 GMT\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"text-center\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"login-form\" action=\"loginManager\" method=\"post\">\n");
      out.write("                <h1 class=\"mb-4\">🐦</h1>\n");
      out.write("                <h1 class=\"h3 mb-3 font-weight-normal\">Sign in</h1>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\" class=\"sr-only\">Email address or Username</label>\n");
      out.write("                    <input type=\"text\" name=\"email\" class=\"form-control\" placeholder=\"Email\" required autofocus>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\" class=\"sr-only\">Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Password\" required>\n");
      out.write("                </div>\n");
      out.write("                ");

                    Cookie[] cookies = request.getCookies();
                    for (Cookie c : cookies) {
                        if (c.getName().equals("login")) {
                            if (c.getValue().equals("false")) {
                                out.println("<p class='text-danger text-center'> Incorrect Login Credentials, <br> Please try again</p>");
                            }
                        }
                    }
                
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <button type=\"submit\" onclick=\"deleteAllCookies()\" class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <a href=\"createAccount.jsp\" class=\"text-dark text-left\" style=\"float: left;\">Create an account</a>\n");
      out.write("                    <a href=\"#\" class=\"text-dark text-right float-right\" style=\"float: right;\">Forgot password?</a>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <span class=\"mt-5 mb-3 text-muted\">Dundee Computing Examination Board</span>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
