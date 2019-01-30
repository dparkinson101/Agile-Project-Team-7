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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Log-In</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \r\n");
      out.write("        <style>\r\n");
      out.write("            html,\r\n");
      out.write("            body {\r\n");
      out.write("                height: 100%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            body {\r\n");
      out.write("                display: -ms-flexbox;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                -ms-flex-align: center;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                padding-top: 40px;\r\n");
      out.write("                padding-bottom: 40px;\r\n");
      out.write("                background-color: #f5f5f5;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .login-form {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                max-width: 400px;\r\n");
      out.write("                padding: 15px;\r\n");
      out.write("                margin: auto;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script>\r\n");
      out.write("            function deleteAllCookies() {\r\n");
      out.write("                var cookies = document.cookie.split(\";\");\r\n");
      out.write("                for (var i = 0; i < cookies.length; i++) {\r\n");
      out.write("                    var cookie = cookies[i];\r\n");
      out.write("                    var eqPos = cookie.indexOf(\"=\");\r\n");
      out.write("                    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;\r\n");
      out.write("                    document.cookie = name + \"=;expires=Thu, 01 Jan 1970 00:00:00 GMT\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"text-center\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form class=\"login-form\" action=\"loginManager\" method=\"post\">\r\n");
      out.write("                <h1 class=\"mb-4\">🐦</h1>\r\n");
      out.write("                <h1 class=\"h3 mb-3 font-weight-normal\">Sign in</h1>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"email\" class=\"sr-only\">Email address or Username</label>\r\n");
      out.write("                    <input type=\"text\" name=\"email\" class=\"form-control\" placeholder=\"Email\" required autofocus>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"password\" class=\"sr-only\">Password</label>\r\n");
      out.write("                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Password\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    Cookie[] cookies = request.getCookies();
                    for (Cookie c : cookies) {
                        if (c.getName().equals("login")) {
                            if (c.getValue().equals("false")) {
                                out.println("<p class='text-danger text-center'> Incorrect Login Credentials, <br> Please try again</p>");
                            }
                        }
                    }
                
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <button type=\"submit\" onclick=\"deleteAllCookies()\" class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <a href=\"createAccount.jsp\" class=\"text-dark text-left\" style=\"float: left;\">Create an account</a>\r\n");
      out.write("                    <a href=\"#\" class=\"text-dark text-right float-right\" style=\"float: right;\">Forgot password?</a>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <span class=\"mt-5 mb-3 text-muted\">Dundee Computing Examination Board</span>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
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
