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
	<jsp:include page="header" />
	<section>
		<%
		User user = (User) session.getAttribute("log");
		
		%>
		<h2>회원정보수정</h2>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="update"> 
			<input type="hidden" name="userCode" value="<%=user.getUser_code()%>">
			<input type="text" name="id" value=<%=user.getId()%> readonly="<%=user.getId()%>"> <br><input
				type="text" name="password" value=<%=user.getPassword()%>><br> 
			<input type="text" name="name" value=<%=user.getName()%>><br> 
			<input type="text" name="contact" value=<%=user.getContact()%>><br> 
			<input type="date" name="joindate" value=<%=user.getJoindate()%> readonly="<%=user.getJoindate()%>"><br> 
			<input type="submit" value="수정">
			<input type="button" value="탈퇴" onclick="location.href='../Service?command=delete&userCode=<%=user.getUser_code()%>'">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>