<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/doggybeta/resources/css/login.css" />
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<script>

</script>
</head>
<body>
<form class="login-form">
  <p class="login-text">
    <span class="fa-stack fa-lg">
      <i class="fa fa-circle fa-stack-2x"></i>
      <i class="fa fa-lock fa-stack-1x"></i>
    </span>
  </p>
  <input type="email" id='userid' class="login-username" autofocus="true" required="true" placeholder="Email" />
  <input type="password" id='passwd' class="login-password" required="true" placeholder="Password" />
  <input type="submit" name="Login" value="Login" class="login-submit" id='btnLogin'/>
</form>
<a href="#" class="login-forgot-pass">forgot password?</a>
<div class="underlay-photo"></div>
<div class="underlay-black"></div> 
<!-- <table border='1'>
	<tr>
		<td>아이디</td>
		<td><input type='text' id='userid'/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type='password' id='passwd'/></td>
	</tr>
	<tr>
		<td colspan='2' align='center'>
			<input type='button' value='로그인' id='btnLogin'/>
		</td>
	</tr>
</table>
<div id='result'>로그인 결과 출력 영역</div> -->

</body>
</html>