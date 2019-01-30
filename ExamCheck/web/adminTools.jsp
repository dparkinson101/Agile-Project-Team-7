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
        String colourSet= db.colour1(pk);
        String colourInt= db.colour2(pk);
        String colourVet=db.colour3(pk);             
        colourExt= db.colour4(pk);
          
                

        
        %>
            <tr>
                <td align="center" height="60" bgcolor=<%out.print(colourSet);%>><% out.print(mc); %>
                        <%
                            if(!colourSet.equals("green")){
                        %>
                        <br>
                        <form action="adminTools.jsp">
                            <select name="Examiner">
                            <%
                                for (int j = 0; j < db.gettotalnumberofusers(); j++){
                            %>
                                <option value="lecturer">Lecturer</option>
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
                <td align="center" bgcolor=<%out.print(colourInt);%>>Smith
                    <%
                        if(!colourInt.equals("green")){
                    %>
                    <br>
                    <button>Submit</button>                    
                    <%
                        }
                    %>
                </td> 
                <td align="center" bgcolor=<%out.print(colourVet);%>>50
                    <%
                        if(!colourVet.equals("green")){
                    %>
                    <br>
                    <button>Submit</button>                    
                    <%
                        }
                    %>
                </td>
                <td align="center" bgcolor=<%out.print(colourExt);%>>Cart
                    <%
                        if(!colourExt.equals("green")){
                    %>
                    <br>
                    <button>Submit</button>                    
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
