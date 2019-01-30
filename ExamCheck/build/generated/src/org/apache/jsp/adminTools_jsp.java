package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BackEnd.Database;
import java.sql.ResultSet;

public final class adminTools_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            table, th, td {\n");
      out.write("                border: 1px solid black;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table style=\"width:60%\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Exam Setter</th>\n");
      out.write("                <th>Internal Moderator</th> \n");
      out.write("                <th>Exam Vetting Comittee</th>\n");
      out.write("                <th>External Moderator</th>\n");
      out.write("            </tr>\n");
      out.write("                                ");

        Database db = new Database();
        db.connect();

        

        ResultSet rs = db.getallexams();
        for (int i = 0; i < db.gettotalnumberofexams(); i++) {  
        
        String colourExt;
        rs.next();
        String mc = rs.getString("module_code");
                
        String pk = rs.getString("exam_pk");
        String examSetter = rs.getString("exam_setter_lect_pk");
        String colourSet= db.colour1(pk);
        String colourInt= db.colour2(pk);
        String colourVet=db.colour3(pk);             
        colourExt= db.colour4(pk);
          
                

        
        
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\" height=\"60\" bgcolor=");
out.print(colourSet);
      out.write('>');
 out.print(mc); 
      out.write("\n");
      out.write("                        \n");
      out.write("                            <br>\n");
      out.write("                            ");

                                out.print(examSetter);
                            
      out.write(" \n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td align=\"center\" bgcolor=");
out.print(colourInt);
      out.write(">Smith\n");
      out.write("                    ");

                        if(!colourInt.equals("green")){
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <form action=\"adminTools.jsp\">\n");
      out.write("                            <select name=\"Examiner\">\n");
      out.write("                            ");

                                ResultSet ur = db.list_all_internal_modderators_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            
      out.write("\n");
      out.write("                            <option value=");
out.print(user);
      out.write('>');
out.print(user);
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\">\n");
      out.write("                        </form>                     \n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td align=\"center\" bgcolor=");
out.print(colourVet);
      out.write(">50\n");
      out.write("                    ");

                        if(!colourVet.equals("green")){
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <form action=\"adminTools.jsp\">\n");
      out.write("                            <select name=\"Examiner\">\n");
      out.write("                            ");

                                ResultSet ur = db.list_all_exam_vetting_commitey_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            
      out.write("\n");
      out.write("                            <option value=");
out.print(user);
      out.write('>');
out.print(user);
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\">\n");
      out.write("                        </form>                        \n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td align=\"center\" bgcolor=");
out.print(colourExt);
      out.write(">Cart\n");
      out.write("                    ");

                        if(!colourExt.equals("green")){
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <form action=\"adminTools.jsp\">\n");
      out.write("                            <select name=\"Examiner\">\n");
      out.write("                            ");

                                ResultSet ur = db.list_all_external_examiners_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            
      out.write("\n");
      out.write("                            <option value=");
out.print(user);
      out.write('>');
out.print(user);
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\">\n");
      out.write("                        </form>                        \n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
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
