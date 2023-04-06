<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../resources/style.css"><style>
  @import url('https://fonts.googleapis.com/css2?family=Righteous&display=swap');
</style>
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>
			<a href="/">A-D gar car</a>
		</h1>
	</header>
	<%
	User log = (User) session.getAttribute("log");

	if (log != null) {
	%>
	<ul id="logout">
		<li id="login"><a href="../views/logOut.jsp">로그아웃</a></li>
		<li>| <a href="../views/mypage.jsp">마이페이지</a></li>
	</ul>
	<%
	} else {
	%>
	<ul id="join">
		<li id="login"><a href="views/logIn.jsp">로그인</a></li>
		<li>| <a href="views/join.jsp">회원가입</a></li>
	</ul>
	<%
	}
	%>

	<nav>
		<ul id="menu">
			<li>단기 렌트카</li>
			<li>장기 렌트카</li>
			<li>커뮤니티</li>
		</ul>
	</nav>
</body>
</html>