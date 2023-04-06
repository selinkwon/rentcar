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
		<h2>로그인</h2>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="login">
			<h3>아이디 :<input type="text" id="id"></h3>
			<h3>비밀번호 :<input type="text" id="password"></h3>
			<input type="button" value="로그인">
		</form>
	</section>
	<jsp:include page="aside.jsp" />
	<jsp:include page="footer.jsp" />
</body>
</html>