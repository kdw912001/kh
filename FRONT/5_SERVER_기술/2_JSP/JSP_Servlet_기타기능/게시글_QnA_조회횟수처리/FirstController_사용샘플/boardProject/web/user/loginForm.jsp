<%@ page language="java" 
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form name="loginform" action="/board/first" method="post"  style="margin-top: 45px;align: rigth;">
<input type="hidden" name="action" value="login"/>
<center>
<table border=0  bgcolor="#97cbff" style="float: right;">
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>로그인</font></b>
		</td>
	</tr>
	<tr><td>아이디 : </td><td><input type="text" name="loginId"/></td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" name="loginPwd"/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
			<a href="/board/first?action=uinsert">회원가입</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>