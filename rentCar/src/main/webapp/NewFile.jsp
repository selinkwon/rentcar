<%@page import="user.UserRequestDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.controller.UserDao"%>
<%@page import="place.controller.PlaceDao"%>
<%@page import="place.PlaceDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="header"/>
<body>
	<%-- JSTL --%>
	
	<p><c:out value="${1 + 10 }"></c:out></p>
	<c:url var="index" value="index"></c:url>
	<%-- <c:redirect url=${index }></c:redirect> --%>
	
	<%
	PlaceDto place = new PlaceDto();
	pageContext.setAttribute("data", place);
	%>
	
	<%-- core set 태그 사용방법 1) --%>
	<%-- .setAttribute(속성명, 속성값)--%>
	<c:set var="place" value="${pageScope.data }" scope="session"></c:set>
	
	<%-- core set 태그 사용방법 2) --%>
	<%-- .setProperty() --%>
	<%-- public setter 가 있는 속성값에 한하여 설정 가능 --%>
	<c:set target="${place }" property="placeName" value="경기도"></c:set>

	<%-- public getter 가 있는 속성값에 한하여 .속성명으로 얻어올 수 있다 --%>
	<p>place : <c:out value="${place.placeName }"></c:out></p>
	<p>place : <c:out value="${place.getPlaceName() }"></c:out></p>
	
	<c:remove var="place"/>
	<p>place : <c:out value="${empty place.placeName }" /></p>
	
	<c:if test="${1 > 2 }">
		<button>click</button>
	</c:if>
	<%if(1>2){ %>
		<button>click</button>
	<% }%>
	
	<c:choose>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<%-- 
	<c:import url="Service">
		<c:param name="command" value="join"></c:param>
	</c:import>
	--%>
	
	<%
	ArrayList<UserRequestDto> list = new ArrayList<>();
	list.add(new UserRequestDto("홍길동"));
	list.add(new UserRequestDto("홍둘리"));
	list.add(new UserRequestDto("도우너"));
	list.add(new UserRequestDto("홍희동"));
	list.add(new UserRequestDto("마이콜"));
	
	pageContext.setAttribute("list", list);
	%>
	
	<c:forEach items="${pageScope.list }" var="member" begin="1" step="2" varStatus="info">
		<p>${info.index} [${info.count}] (${info.first}/${info.last}) : ${user.name }</p>
	</c:forEach>
	
	<c:forTokens items="가/나/다" delims="/" var="data">
		<p>${data }</p>
	</c:forTokens>
	
</body>
</html>