<%@page import="place.controller.PlaceDao"%>
<%@page import="place.Place"%>
<%@page import="car.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.controller.CarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단기 렌트카</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44fc5ea26944468ab02225eb1b7d7f2b&libraries=services,clusterer,drawing"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44fc5ea26944468ab02225eb1b7d7f2b"></script>
</head>
<body>
	<jsp:include page="header" />
	<section>
	<form method="post" id="booking" action="booking?message=<%=request.getParameter("message")%>">
		<h2>차량검색</h2>
		<div id="map" style="width: 500px; height: 400px;"></div>
		<h3 name="result" id="result"><%=request.getParameter("message") != null ?request.getParameter("message") : ""%></h3>
		<%
					String search = request.getParameter("search");
					ArrayList<Car> list = null;
					if (search != null) {
						%>
		<table>
			<tbody>
				<tr>
					<th></th>
					<th></th>
					<th>차이름</th>
					<th>가격</th>
					<th>선택</th>
				</tr>
						<%
						CarDao carDao = CarDao.getInstance();
						list = carDao.getCarByPlaceCode(search);

						if (list.size() > 0) {
							for (int i = 0; i < list.size(); i++) {
					%>
				<tr>
					<td><input type="hidden" name="carCode" value="<%=list.get(i).getCarCode()%>"></td>
					<td><input type="image" src="<%=list.get(i).getImagePath()%>"></td>
					<td style="text-align: center"><%=list.get(i).getName()%></td>
					<td style="text-align: center"><%=list.get(i).getPrice()%></td>
					<td><input type="radio" id="check" name="check"
						value="<%=list.get(i).getName() %>" onclick='getCarValue(event)' required></td>
				</tr>

				<%
					}
					}%>

			</tbody>
		</table>
		<h3 id="checkedCar"></h3>
		<input type="submit" value="예약하기" >
					<%
					}
					%>
		</form>
	</section>
	<jsp:include page="aside" />
	<jsp:include page="footer" />
	<script type="text/javascript" src="../resources/map.js"></script>
</body>
</html>