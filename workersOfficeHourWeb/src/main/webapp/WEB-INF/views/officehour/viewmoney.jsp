<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/viewmoney.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<header>
<%@include file="header.jsp" %>
</header>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<h1>${sessionVO.name}님의총 급여 명세서</h1>
			<hr>
			<table border="1" width="500" height="300" align="center">
				<form action="viewMonthMoney">
					<tr align="center">
						<p>
						<td colspan="4" bgcolor="grey" span style="color: white">${mon}월 출근 조회 
						<input type="number" class="year" placeholder="연도" name="year"> 
						<select id="handleAmount" name="month" class="month" style="height: 35px;">
								<option value="01" ${mon == 01 ? 'selected' : '' }>1월</option>
								<option value="02" ${mon == 02 ? 'selected' : '' }>2월</option>
								<option value="03" ${mon == 03 ? 'selected' : '' }>3월</option>
								<option value="04" ${mon == 04 ? 'selected' : '' }>4월</option>
								<option value="05" ${mon == 05 ? 'selected' : '' }>5월</option>
								<option value="06" ${mon == 06 ? 'selected' : '' }>6월</option>
								<option value="07" ${mon == 07 ? 'selected' : '' }>7월</option>
								<option value="08" ${mon == 08 ? 'selected' : '' }>8월</option>
								<option value="09" ${mon == 09 ? 'selected' : '' }>9월</option>
								<option value="10" ${mon == 10 ? 'selected' : '' }>10월</option>
								<option value="11" ${mon == 11 ? 'selected' : '' }>11월</option>
								<option value="12" ${mon == 12 ? 'selected' : '' }>12월</option>
						</select> 
						<input type="submit" class="submit" value="검색">
						</td>
				</form>
				</td>
				</p>
				</tr>
				<tr align="center" bgcolor="grey">
					<td>내용</td>
					<td>수입</td>
				</tr>
				<tr>
					<td>근무시간</td>
					<td>${vo.totalWorkTime}</td>
				</tr>
				<tr>
					<td>기본급</td>
					<td>${vo.monthPay}</td>
				</tr>
				<tr>
					<td>추가 수당</td>
					<td>${vo.overPay}</td>
				</tr>
				<tr>
					<td rowspan="3" align="center" bgcolor="grey">총계</td>
					<td>수입</td>
				</tr>
				<tr>
					<td>${vo.totalAmount}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>