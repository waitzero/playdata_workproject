<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/popup.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin:0; padding: 0;} 
</style>
</head>
<body>
<div class="h1_con">
<h1>연차입니다</h1>
</div>
<hr>
<form action="chooseDayOff">
<div class="content v">
<h3>날짜를 선택해 주세요</h3>
<p class="v_con"><input type="date" name="date" class="vacation_date"></p>
</div>

<hr class="v_hr">
		<input type="hidden" name="reason" value="연차">
     <p><input type="submit"class="submit" value="확인" ></p>
</form>
</body>
</html>
<script>
var msg = '${msg}';
		if (msg != "") {
			alert(msg);
			window.close();
			
		}
		</script>