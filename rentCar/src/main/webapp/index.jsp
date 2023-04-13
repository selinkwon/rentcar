<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/welcome.js"></script>
<script src="resources/logout.js"></script>
<title>A-D gar car</title>
</head>
<body>
	<jsp:include page="header" />
	<%
	Object welcome = request.getAttribute("welcome");
	if (welcome != null && (boolean) welcome) {
	%>
	<script>
		alertWelcome();
	</script>
	<%
	}
	%>
	<%
	Object logout = request.getAttribute("logout");
	if (logout != null && (boolean) logout) {
	%>
	<script>
		alertLogOut();
	</script>
	<%
	}
	%>
	<section>

	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>