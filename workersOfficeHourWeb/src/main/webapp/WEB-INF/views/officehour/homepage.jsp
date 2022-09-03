<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/homepage.css">
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<h1>${sessionVO.name}님 환영합니다</h1>
			<hr>
			<div class="wrap-flex"><!-- 플렉스 -->
				<div class="w1">
				<input type="button" class="w-btn w-btn-red" value="출근" onclick="location.href='workStart'">
				<input type="button" class="w-btn w-btn-red" value="퇴근" onclick="location.href='workEnd'"> 

				<input type="button" class="w-btn w-btn-red" value="병가" onclick="showSick();">
				</div>	
				<div class="w2">
				 <input type="button" class="w-btn w-btn-red" value="연차" onclick="showVacation();"> 
				 <input type="button" class="w-btn w-btn-red" value="출근 기록 조회" onclick="location.href='viewtime'"> 
				<input type="button" class="w-btn w-btn-red" value="본인 수당 조회" onclick="location.href='viewmoney'"> 
				</div>			
			</div>
			<hr>
 	<input type="button" class="w-btn w-btn-red logout" value="로그아웃" onclick="location.href='logout'">
		</div>
	</div>
	
	<script>
		var msg = '${msg}';
		if (msg != "") {
			alert(msg);
		}
		function showSick() { window.open("sick", "a", "width=400, height=330, left=100, top=50"); }
		function showVacation() { window.open("vacation", "a", "width=400, height=330, left=100, top=50"); }
	</script>

</body>
</html>