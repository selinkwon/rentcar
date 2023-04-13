<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
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
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="board">
			<table>
				<tbody>
				<tr>
				<th>게시글번호</th>
				<th>게시글제목</th>
				<th>작성자</th>
				<th>등록일</th>
				</tr>
				<%
				BoardDao boardDao = BoardDao.getInstance();
				ArrayList<Board> list = boardDao.getBoardAll();
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i).getUserCode());
				%>
				<tr>
				<td><%=list.get(i).getContentNum() %></td>
				<td><a href="content?userCode=<%=list.get(i).getUserCode() %>&contentNum=<%=list.get(i).getContentNum() %>"><%=list.get(i).getTitle()%></a></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getAddDate() %></td>
				</tr>
				
				<%
				}
				%>
				</tbody>
			</table>
			<input type="submit" value="작성">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>