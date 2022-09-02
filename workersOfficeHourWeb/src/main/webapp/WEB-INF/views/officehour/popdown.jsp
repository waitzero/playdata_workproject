<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 	href="${pageContext.request.contextPath }/resources/css/popup.css">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center;">완료 됐습니다</h3>
<p><input type="submit" class="pop_submit" value="닫기" onclick="window.close()"></p>
	<script>
		var msg = '${msg}';
		if (msg != "") {
			alert(msg);
		}
	</script>
</body>
</html>
