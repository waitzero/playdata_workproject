<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanks Join us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/signup.css">
</head>
<body>
<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action="workerSignUp">
			<h1>Sign Up</h1>
			<div class="social-container">
			</div>
			<input type="text" name="workerId" placeholder="Id" required="required" />
			<input type="password" name="workerPassword"placeholder="Password" required="required"/>
			<input type="password" name="passwordCheck"placeholder="Password_check" required="required"/>
			<input type="text" name="name" placeholder="Name" required="required"/>
			<input type="text" name="career" placeholder="carrer" required="required"/>
			<div class="gender" >
			<label><input type="checkbox" name="gender" value="남"  onclick="NoMultiChk(this)">Man</label>
			<label><input type="checkbox" name="gender" value="여"  onclick="NoMultiChk(this)">Woman</label>
			</div>
			<!--아이디, 비번, 이름, 성별, 연차,   -->
			<input type="submit" class="sign_up" value="Sign UP">
		</form>
	</div>
</div>	
</body>
</html>

<script>
function NoMultiChk(chk){
	  var obj = document.getElementsByName("gender");
	   for(var i=0; i<obj.length; i++){
	     if(obj[i] != chk){
	       obj[i].checked = false;
	     }
	   }
	}
	
var msg = '${msg}';
if (msg != "") {
	alert(msg);
}
</script>