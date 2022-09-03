<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/login.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/mystyle.css">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<div class="container" id="container">
		<div class="form-container sign-in-container">
			<form action="workerLoginForm" method="post">
				<h1>Sign in</h1>
				<div class="social-container"></div>
				<input type="text" name="workerId" placeholder="Id" /> 
				<input type="password" name="workerPassword" placeholder="Password" /> 
					<input type="submit" class="sign_in" value="Sign In">
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-right">
					<h1>Hello!</h1>
					<p>Enter your personal details and start journey with us</p>
					<input type="button" class="sign_up" value="Sign Up" onclick="location.href='signup'">
				</div>
			</div>
		</div>
	</div>

	<footer>
		<p>FirstTeam:정정일, 박광덕, 조재현, 정지영</p>
	</footer>

	<script>
		var msg = '${msg}';
		if (msg != "") {
			alert(msg);
		}
	</script>

</body>
</html>