<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:include page="header" />
	<section>
		<h2>로그인</h2>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="login">
			<input type="text" name="id" id="id" required placeholder="id" required><br>
			<input type="password" name="password" id="password" required placeholder="password" required><br>
			<input type="submit" value="로그인">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>