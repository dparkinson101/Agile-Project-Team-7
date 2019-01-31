<%-- 
    Document   : adminTools
    Created on : 28-Jan-2019, 13:16:36
    Author     : matthewmcneil
--%>
<%@page import="BackEnd.Database"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                out.print(db.getusername(examSetter));
                            %> 

                </td>
                <td align="center" bgcolor=<%out.print(colourInt);%>>
                    <%
                        if(colourInt.equals("red")){
                    %>
                    <br>
                    <form action="UpdateChecker.java">
                            <select name="Examiner">
                            <%
                                ResultSet ur = db.list_all_internal_modderators_username();                                
                                for (int j = 0; j < 1; j++){
                                    ur.next();
                                    String user = ur.getString("username");
                            %>
                            <option name="Character" value=<%out.print(user);%>><%out.print(user);%></option>
                            <%
                                }
                            %>
                            </select>
                            <input type="hidden" name="field" value="1" />
                            <input type="hidden" name="pk" value=<%out.println(pk);%> />
                            <input type="submit">
                        </form>                     
                    <%
                        }else{out.print(db.get_username_from_exam_pk(pk, 1));}
                    %>
                </td> 
                <td align="center" bgcolor=<%out.print(colourVet);%>>
                    <%
                        if(colourVet.equals("red")){
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
                            <input type="hidden" name="field" value="2" />
                            <input type="hidden" name="pk" value=<%out.println(pk);%> />
                            <input type="submit">
                        </form>                        
                    <%
                        }else{out.print(db.get_username_from_exam_pk(pk, 2));}
                    %>
                </td>
                <td align="center" bgcolor=<%out.print(colourExt);%>>
                    <%
                        if(colourExt.equals("red")){
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
                            <input type="hidden" name="field" value="3" />
                            <input type="hidden" name="pk" value=<%out.println(pk);%> />
                        </form>                        
                    <%
                        }else{out.print(db.get_username_from_exam_pk(pk, 3));}
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
