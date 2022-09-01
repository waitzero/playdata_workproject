<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/viewmoney.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
		<div class="container">
			<h1>정지영 대리님의 출근 조회</h1>
			<hr>
			<table border="1"  width ="500" height="300" align = "center" >
    <tr align ="center">
	<p>
	<td colspan = "2"bgcolor="grey" span style="color:white">11월 출근 조회
	<select class="month">
	<option value="jan">1월</option>
	<option value="feb">2월</option>
	<option value="mar">3월</option>
	<option value="apr">4월</option>
	<option value="may">5월</option>
	<option value="jun">6월</option>
	<option value="jul">7월</option>
	<option value="aug">8월</option>
	<option value="sep">9월</option>
	<option value="oct">10월</option>
	<option value="nov">11월</option>
	<option value="dec">12월</option>
	</select>
	</td>
	</p>
    </tr>
    <tr align = "center" bgcolor="grey">
	<td>날짜</td>
	<td>시간</td>
    <c:forEach var="item" items="${items }" varStatus="status">
	<tr>
	<td>${item.day }</td>
	<td>${item.workin}~${item.workout}</td>
	</tr>
	</c:forEach>
    
</table>
		</div>
	</div>
</body>
</html>