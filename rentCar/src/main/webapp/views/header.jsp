<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../resources/style.css"><style>
  
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
		<li id="login"><a href="logOut">로그아웃</a></li>
		<li>| <a href="mypage">마이페이지</a></li>
	</ul>
	<%
	} else {
	%>
	<ul id="join">
		<li id="login"><a href="logIn">로그인</a></li>
		<li>| <a href="join">회원가입</a></li>
	</ul>
	<%
	}
	%>

	<nav>
		<ul id="menu">
			<li><a href="shortTerm">단기 렌트카</a></li>
			<li><a href="longTerm">장기 렌트카</a></li>
			<li><a href="board">CAR뮤니티</a></li>
		</ul>
	</nav>
</body>
</html>