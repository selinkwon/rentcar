<%@page import="user.User"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
</head>
<body>
	<jsp:include page="header" />
	<section>
		<h2>예약하기</h2>
		<form method="post" action="../Service">
			<input type="hidden" name="command" value="booking">
		<% User user = (User) session.getAttribute("log");
			String carName = request.getParameter("check");
			String result = request.getParameter("message");
		%>
			<input type="hidden" name="carCode" value="<%=request.getParameter("carCode")%>">
			<h3>예약자이름</h3>
			<input type="text" name="name" value="<%=session.getAttribute("log") == null ? "" : user.getName()%>" required placeholder="이름을 입력하세요.">			
			<h3>대여장소</h3>
			<input type="text" name="place" value="<%=request.getParameter("message") == null ? "" : result %>" readonly>			
			<h3>대여차량</h3>
			<input type="text" name="carName" value="<%=request.getParameter("check") == null ? "" : carName %>" readonly>
			<h3>대여시간</h3>
			<div>
			<input type="date" name="startDay" id="startday" value="<%=new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>" required>
			<input type="time" name="startHour" id="starthour" required>
			</div><br>
			<div>
			<h3>반납시간</h3>
			<input type="date" name="endDay" id="endday"  value="<%=new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>" required>
			<input type="time" name="endHour" id="endhour" required>
			</div>
			<input type="submit" value="예약하기">
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
</body>
</html>