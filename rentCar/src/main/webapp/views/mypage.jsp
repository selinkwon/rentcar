<%@page import="user.User"%>
<%@page import="user.controller.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<section>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="join">
			<%
			String id = request.getParameter("id");
		
			UserDao userDao = UserDao.getInstance();
			User user = userDao.getUserById(id);

			%>
			<input type="text" name="id" value=<%=user.getId()%>> <input
				type="text" name="password" value=<%=user.getPassword()%>> <input
				type="text" name="name" value=<%=user.getName()%>> <input
				type="text" name="contact" value=<%=user.getContact()%>> <input
				type="date" name="joindate" value=<%=user.getJoindate()%>> <input
				type="submit" value="수정">
		</form>
	</section>
	<jsp:include page="aside.jsp" />
	<jsp:include page="footer.jsp" />
</body>
</html>