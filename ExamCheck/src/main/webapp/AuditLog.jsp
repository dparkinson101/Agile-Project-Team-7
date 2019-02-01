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
<% HttpSession spoons = request.getSession();
	String username = (String) spoons.getAttribute("email");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Audit Log</title>
	<!-- Jquery !-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- FONT AWESOME !-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<script>
	function resizeText(multiplier)
	{
		if (document.body.style.fontSize == "")
		{
			document.body.style.fontSize = "1.0em";
		}
		document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
	}
	function submitForms(formUpload, formComment) {
		var f1 = document.getElementById(formUpload);
		var f2 = document.getElementById(formComment);
		//sendXMLRequest(f1, "FileUploadUpdate");
		sendXMLRequest(f2, "AddComments");
		f1.submit();
	}
	function sendXMLRequest(f, page) {
		var postData = [];
		for (var i = 0; i < f.elements.length; i++) {
			postData.push(f.elements[i].name + "=" + f.elements[i].value);
		}
		var xhr = new XMLHttpRequest();
		xhr.open("POST", page, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(postData.join("&"));
	}
	function deleteAllCookies() {
		var cookies = document.cookie.split(";");
		for (var i = 0; i < cookies.length; i++) {
			var cookie = cookies[i];
			var eqPos = cookie.indexOf("=");
			var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
			document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
		}
	}
</script>
<body>

<div id="wrapper">
	
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="index.jsp">Dundee Computing Examination Board</a>
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
					<a class="dropdown-item" href="listExams.jsp"><i class="fa fa-text-height fa-fw"></i> Normal text size</a>
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
					<a class="dropdown-item" href="#"><i class="fas fa-user"></i> <% out.print(username); %></a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="Log-in.jsp"onclick=" if (confirm('Are you sure you want to log out?')) {
                                        deleteAllCookies();
                                    }"><i class="fas fa-sign-out-alt"></i> Log out</a>
				</div>
			</li>
		</ul>
	</nav>
</div>

<ul class="list-group">
	<%
		Database db = new Database();
		db.connect();
		int number_of_entrys = db.audit_rows();
		for (int i = 1; i <= number_of_entrys; i++) {
	%>
	<li class="list-group-item"><%out.println(db.download_log_string(String.valueOf(i)) + "        at       " + db.download_log_date(String.valueOf(i)));%> </li>
	<%}%>
</ul>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>