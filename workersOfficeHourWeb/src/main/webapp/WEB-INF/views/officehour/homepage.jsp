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
				<input type="button" class="w-btn w-btn-red" value="출근" onclick="location.href='work_start'">
				<input type="button" class="w-btn w-btn-red" value="퇴근" onclick="location.href='work_end'"> 
				<input type="button" class="w-btn w-btn-red" value="외근">
				</div>	
				<div class="w2">
				 <input type="button" class="w-btn w-btn-red" value="병가"> 
				 <input type="button" class="w-btn w-btn-red" value="출근 기록 조회"> 
				<input type="button" class="w-btn w-btn-red" value="본인 수당 조회"> 
				</div>			
			</div>
			<hr>
 	<input type="button" class="w-btn w-btn-red logout" value="로그아웃">
		</div>
	</div>
	
	<script>
		var msg = '${msg}';
		if (msg != "") {
			alert(msg);
		}
	</script>

</body>
</html>