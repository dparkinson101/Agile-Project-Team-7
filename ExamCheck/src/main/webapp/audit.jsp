<%-- 
    Document   : audit
    Created on : 31-Jan-2019, 15:49:09
    Author     : laptop
--%>
<%@page import="BackEnd.Permissions"%>
<%@page import="BackEnd.Security"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BackEnd.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //CODE FOR COOKIE CHECKING
    String base64 = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("secretClass")) {
                base64 = c.getValue();
            }
        }
    }

    String sessionVar = request.getSession().getId();
    Permissions permsInstance = null;

    Security secure = new Security();
    try {
        permsInstance = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
        if (permsInstance == null) {
            throw new NullPointerException("Perms Object Returned is Null");
        }
    } catch (NullPointerException e) {
        System.out.println("Error Getting Permissions Object: The Session Variable May Have Changed!");
        request.changeSessionId();

        //Deletes Cookies
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                Cookie cookie = new Cookie(c.getName(), "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("Log-in.jsp");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
        <table width='670'>
            <%

                Database db = new Database();
                db.connect();
                int number_of_entrys = db.audit_rows();
                for (int i = 1; i <= number_of_entrys; i++) {
            %>


            <tr>    <td width='60'><%out.println(db.download_log_string(String.valueOf(i)) + "        at       " + db.download_log_date(String.valueOf(i)));%> </td>  </tr>
            <%}%>
        </table>
    </body>
</html>

