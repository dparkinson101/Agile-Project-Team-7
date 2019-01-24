<%-- 
    Document   : loginHandler
    Created on : 21-Jan-2019, 11:08:40
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BackEnd.Main" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Main main = new Main();
    boolean login = main.loginHandle(username, password);

    if (login) {
        //Redirect to home page and give cookie somehow
    } else {
        username = null;
        password = null;
    }

%>
