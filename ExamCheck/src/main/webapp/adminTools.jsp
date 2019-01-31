<%-- 
    Document   : adminTools
    Created on : 28-Jan-2019, 13:16:36
    Author     : matthewmcneil
--%>
<%@page import="BackEnd.Database" %>
<%@page import="java.sql.ResultSet" %>
<%@ page import="BackEnd.Security" %>
<%@ page import="BackEnd.Permissions" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
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
			if (cookie.getName().equals("secretClass")) {
				base64 = cookie.getValue();
			}
		}
	}
	
	sessionVar = request.getSession().getId();
	
	Security secure = new Security();
	try {
		Permissions permissionsObject = (Permissions) secure.convertEncodedBase64ToObject(base64, sessionVar);
	} catch (Exception e) {
		System.out.println("Error Getting Permissions Object: The Session Variable May Have Changed!");
		request.changeSessionId();
		
		//Deletes Cookies
		for (Cookie c : request.getCookies()) {
			Cookie cookie = new Cookie(c.getName(), "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		response.sendRedirect("Log-in.jsp");
	}

%>

<!DOCTYPE html>
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Admin tools</title>
	<!-- JQUERY !-->
	<script src="./vendor/jquery/jquery.min.js"></script>
	<!-- BOOTSTRAP !-->
	<link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css">
	<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- FONT AWESOME !-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
</head>
<body>
<!-- Navbar !-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
	<a class="navbar-brand" href="#">Dundee Computing Examination Board</a>
	<ul class="navbar-nav ml-auto">
		<!-- Accessibility !-->
		<li class="nav-item dropdown" style="padding-right: 10px">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
				<i class="fas fa-universal-access fa-lg"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="#" onclick=resizeText(1)><i class="fas fa-text-height fa-2x"></i>
					Increase text size</a>
				<a class="dropdown-item" href="#" onclick=resizeText(-1)><i class="fas fa-text-height fa-fw"></i>
					Decrease text size</a>
				<a class="dropdown-item" href="index.jsp"><i class="fa fa-text-height fa-fw"></i> Normal text size</a>
			</div>
		</li>
		<!-- Notifications !-->
		<li class="nav-item dropdown" style="padding-right: 10px">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
				<i class="fas fa-bell fa-lg"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="#"><i class="fas fa-comment"></i> No new comments</a>
			</div>
		</li>
		<!-- User !-->
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
				<i class="fas fa-user fa-lg"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="#"><i class="fas fa-user"></i> <%=username %>
				</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="Log-in.jsp" onclick="deleteAllCookies()"><i
						class="fas fa-sign-out-alt"></i> Log out</a>
			</div>
		</li>
	</ul>
</nav>

<div class="container">
	<table class="table table-bordered">
		<thead>
		<tr>
			<th scope="col">Module code / Exam setter</th>
			<th scope="col">Internal moderator</th>
			<th scope="col">Exam vetting committee</th>
			<th scope="col">External moderator</th>
		</tr>
		
		</thead>
		<tbody>
		<%
			//Connect to DB for printing to table
			Database dab = new Database();
			dab.connect();
			
			ResultSet res = dab.getallexams();
			for (int i = 0; i < dab.gettotalnumberofexams(); i++) {
				
				String colourExt;
				res.next();
				String mc = res.getString("module_code");
				
				String pk = res.getString("exam_pk");
				String examSetter = res.getString("exam_setter_lect_pk");
				String colourSet = dab.colour1(pk);
				String colourInt = dab.colour2(pk);
				String colourVet = dab.colour3(pk);
				colourExt = dab.colour4(pk);
		
		
		%>
		<tr>
			<td scope="row"><% out.print(mc.toUpperCase()); %><br><% out.print(dab.getusername(examSetter)); %></td>
			<td bgcolor="<%=colourInt%>">
				<% if (colourInt.equals("red")) { %>
				<form action="UpdateChecker.java">
					<select name="Examiner">
						<%
							
							ResultSet ur = dab.list_all_internal_modderators_username();
							for (int j = 0; j < dab.getRows(1); j++) {
								ur.next();
								String user = ur.getString("username");
//
						%>
						<option name="Character" value="<%=user%>"><%=user%>
						</option>
						<% } %>
					</select>
					<input type="hidden" name="field" value="1"/>
					<input type="hidden" name="pk" value=<%=pk%>/>
					<input type="submit">
				</form>
				<%
					} else {
						out.print(dab.get_username_from_exam_pk(pk, 1));
					}
				%>
			</td>
			<td bgcolor="<%=colourVet%>">
				<% if (colourVet.equals("red")) { %>
				<form action="adminTools.jsp">
					<select name="Examiner">
						<%
							ResultSet ur = dab.list_all_exam_vetting_commitey_username();
							for (int j = 0; j < dab.getRows(2); j++) {
								ur.next();
								String user = ur.getString("username");
						%>
						<option value="<%=user%>"><%=user%>
						</option>
						<%
							}
						%>
					</select>
					<input type="hidden" name="field" value="2"/>
					<input type="hidden" name="pk" value="<%=pk%>"/>
					<input type="submit">
				</form>
				<%
					} else {
						out.print(dab.get_username_from_exam_pk(pk, 2));
					}
				%>
			</td>
			<td bgcolor="<%=colourExt%>">
				<% if (colourExt.equals("red")) { %>
				<form action="adminTools.jsp">
					<select name="Examiner">
						<%
							ResultSet ur = dab.list_all_external_examiners_username();
							for (int j = 0; j < dab.getRows(3); j++) {
								ur.next();
								String user = ur.getString("username");
						%>
						<option value="<%=user%>"><%=user%>
						</option>
						<%
							}
						%>
					</select>
					<input type="submit">
					<input type="hidden" name="field" value="3"/>
					<input type="hidden" name="pk" value="<%=pk%>"/>
				</form>
				<%
					} else {
						out.print(dab.get_username_from_exam_pk(pk, 3));
					}
				%>
			</td>
		</tr>
		<%
			}
		%>
		
		</tbody>
	</table>
	
	<!-- KEY !-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div style="width:30px;height: 30px;background-color: red; margin-right:10px;" class="float-left"></div>
				<span> Not assigned</span>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4">
				<div style="width:30px;height: 30px;background-color: yellow; margin-right:10px;" class="float-left"></div>
				<span> In progress</span>
			</div>
			<div class="col-md-4">
				<div style="width:30px;height: 30px;background-color: green; margin-right:10px;" class="float-left"></div>
				<span> Completed</span>
			</div>
		</div>
	</div>
</div>
<br>
</body>
</html>
