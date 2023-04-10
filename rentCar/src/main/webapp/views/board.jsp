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
				<th>
				</th>
				</tr>
				</tbody>
			</table>
			<input type="submit" value="작성">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>