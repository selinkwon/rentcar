<%@page import="user.controller.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<%
	UserDao userDao = UserDao.getInstance();

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String contact = request.getParameter("contact");
	String joindate = request.getParameter("joindate");
	%>
	<jsp:include page="header.jsp" />
	<section>
		<h2>회원가입</h2>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="join"> <input
				type="text" name="id" id="id" required placeholder="id"
				value="<%=id != null ? id : ""%>" <%=id == null ? "autofocus" : ""%>><br>
			<input type="password" name="password" id="password" required
				placeholder="password" value="<%=password != null ? password : ""%>"
				<%=password == null ? "autofocus" : ""%>><br> <input
				type="text" name="name" id="name" required placeholder="name"
				value="<%=name != null ? name : ""%>"
				<%=name == null ? "autofocus" : ""%>><br> <input
				type="text" name="contact" id="contact" required placeholder="phone"
				value="<%=contact != null ? contact : ""%>"
				<%=contact == null ? "autofocus" : ""%>><br> <input
				type="date" name="joindate" id="joindate" 
				value="<%=joindate != null ? joindate : ""%>"
				<%=joindate == null ? "autofocus" : ""%>><br> <input
				type="button" value="가입" onclick="checkValues(form)">
		</form>
	</section>
	<jsp:include page="aside.jsp" />
	<jsp:include page="footer.jsp" />
	<script src="../resources/validation.js"></script>
</body>
</html>