<%-- 
    Document   : adminTools
    Created on : 28-Jan-2019, 13:16:36
    Author     : matthewmcneil
--%>
<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
<%@page import="BackEnd.Database"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String base64 = "";
    String sessionVar = "";
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("secretClass")){
                base64 = cookie.getValue();
            }
        }
    }
    
    sessionVar = request.getSession().getId();
    
    Security secure = new Security();
    try{
        Permissions permissionsObject = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
        if(permissionsObject == null){
            throw new NullPointerException("Permissions Object Null");
        }
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
    
%>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <table style="width:60%">
            <tr>
                <th>Exam Setter</th>
                <th>Internal Moderator</th> 
                <th>Exam Vetting Comittee</th>
                <th>External Moderator</th>
            </tr>
                                <%
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
          
                

        
        %>
            <tr>
                <td align="center" height="60" bgcolor=<%out.print(colourSet);%>><% out.print(mc); %>
                        
                            <br>
                            <%
                                out.print(examSetter);
                            %> 

                </td>
                <td align="center" bgcolor=<%out.print(colourInt);%>>Smith
                    <%
                        if(!colourInt.equals("green")){
                    %>
                    <br>
                    <form action="adminTools.jsp">
                            <select name="Examiner">
                            <%
                                ResultSet ur = db.list_all_internal_modderators_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            %>
                            <option value=<%out.print(user);%>><%out.print(user);%></option>
                            <%
                                }
                            %>
                            </select>
                            <input type="submit">
                        </form>                     
                    <%
                        }
                    %>
                </td> 
                <td align="center" bgcolor=<%out.print(colourVet);%>>50
                    <%
                        if(!colourVet.equals("green")){
                    %>
                    <br>
                    <form action="adminTools.jsp">
                            <select name="Examiner">
                            <%
                                ResultSet ur = db.list_all_exam_vetting_commitey_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            %>
                            <option value=<%out.print(user);%>><%out.print(user);%></option>
                            <%
                                }
                            %>
                            </select>
                            <input type="submit">
                        </form>                        
                    <%
                        }
                    %>
                </td>
                <td align="center" bgcolor=<%out.print(colourExt);%>>Cart
                    <%
                        if(!colourExt.equals("green")){
                    %>
                    <br>
                    <form action="adminTools.jsp">
                            <select name="Examiner">
                            <%
                                ResultSet ur = db.list_all_external_examiners_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            %>
                            <option value=<%out.print(user);%>><%out.print(user);%></option>
                            <%
                                }
                            %>
                            </select>
                            <input type="submit">
                        </form>                        
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
