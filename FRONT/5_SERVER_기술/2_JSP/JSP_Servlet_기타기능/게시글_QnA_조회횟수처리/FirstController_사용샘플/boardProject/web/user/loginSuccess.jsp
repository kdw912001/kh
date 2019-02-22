<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>

<table border=0  bgcolor="#97cbff" style="float: right;margin-top: 45px;">
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>${loginUser.userName } 님</font></b>
		</td>
	</tr>
	<tr><td>메일</td><td>카페</td></tr>
	<tr><td>쪽지</td><td>현재 포인트</td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="/board/first?action=logout">로그아웃</a>&nbsp;&nbsp;
			<a href="/board/first?action=udetail">회원정보보기</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>