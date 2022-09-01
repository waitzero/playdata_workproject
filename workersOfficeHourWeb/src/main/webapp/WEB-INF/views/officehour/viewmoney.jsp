<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/viewmoney.css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
		<div class="container">
			<h1>정지영 대리님의 총 급여 명세서</h1>
			<hr>
			<table border="1"  width ="500" height="300" align = "center" >
    <tr align ="center">
	<p>
	<td colspan = "2" bgcolor="grey" span style="color:white">11월 월급 명세서
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
	<td>내용</td>
	<td>수입</td>
    </tr>
    <tr>
	<td>기본급</td>
	<td>4,000,000</td>
    </tr>
    <tr>
	<td>성과급</td>
	<td>1,000,000</td>
    </tr>
    <tr>
	<td>주휴수당</td>
	<td>1,100,000</td>
    </tr>
    <tr>
	<td rowspan="3" align = "center" bgcolor="grey">총계</td>
	<td>수입</td>
    </tr>
    <tr>
	<td>6,100,000</td>
    </tr>
</table>
		</div>
	</div>
</body>
</html>