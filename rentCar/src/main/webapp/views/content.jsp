<%@page import="user.User"%>
<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAR뮤니티</title>
</head>
<body>
	<jsp:include page="header" />
	<section>
		<h2>게시판</h2>
		<form method="post" action="board">
			<%
			String userCode = request.getParameter("userCode");
			String contentNum = request.getParameter("contentNum");
			
			System.out.println(userCode+""+contentNum);
			BoardDao boardDao = BoardDao.getInstance();
			
			Board board = boardDao.getBoardByContentNum(Integer.parseInt(contentNum));
			%>
			<div id="content">
				<h4><%=contentNum%></h4>
				<h4><%=board.getTitle() %></h4>
				<h4><%=board.getName() %></h4>
				<h4><%=board.getAddDate() %></h4>
			</div>

			<p id="boardcontent"><%=board.getContent() %></p>

			<%
			User user = (User) session.getAttribute("log");
			if(user != null && user.getUser_code() == Integer.parseInt(userCode)){
				%>
			<input type="button" value="수정">

			<%
			}
			%>
			<input type="submit" value="목록">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>