<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 	href="${pageContext.request.contextPath }/resources/css/popup.css">
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	* {margin:0; padding: 0;} 
</style>


</head>
<body>
<div class="h1_con">
<h1>병가입니다</h1>
</div>
<hr>
<div class="content">
<form action="chooseDayOff">
<h3>날짜를 선택해 주세요</h3>
<p><input type="date" name="date" class="sick_date"></p>	
<!-- <h3>마지막날짜를 선택해 주세요</h3>
<p><input type="date" class="sick_end_date"></p> -->
<h3>병가의 사유는 무엇인가요</h3>
<select class="sick_kind" name="reason">
<option value="질병">질병</option>	
<option value="부상">부상</option>
<option value="개인사유">개인사유</option>
</select>
</div>
<hr>
      <p><input type="submit" class="submit" value="확인"></p>
</form>
</body>
</html>