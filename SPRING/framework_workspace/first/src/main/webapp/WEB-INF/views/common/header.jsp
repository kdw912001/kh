<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
nav { float: left; }
nav ul li { 
	float: left;
	display: block;
	width: 200px;
	height: 35px;
	background: orange;
	color: navy;
	text-align: center;
}
a { text-decoration: none; }
</style>
</head>
<body>
<header>
<nav>
<ul>
	<li><a href="main.do">home</a></li>
	<li><a href="">AOP란?</a></li>
	<li><a href="moveFile.do">파일업로드/다운로드 테스트</a></li>
	<li><a href="moveAjax.do">Ajax Test</a></li>
	<li><a href="testView.do">패스워드 암호화처리</a></li>
</ul>
</nav>
</header>

<c:if test="${empty loginMember }">
<table id="loginfrm">
<form action="login.do" method="post">
<!-- input 태그의 name 속성의 이름은 반드시 vo 클래스의 필드명과 똑같이 지정해야 함. -->
<tr><th><input type="text" name="userid"></th><th rowspan="2"><input type="submit" value="로그인"></th></tr>
<tr><th><input type="password" name="userpwd"></th></tr>
<tr><th colspan="2"><a>아이디/암호분실시</a> &nbsp;
<a href="enroll.do">회원가입</a></th></tr>
</form>
</table>
</c:if>
<c:if test="${!empty loginMember }">
<table>
<tr><th>${loginMember.username } 님</th>
<th><a href="logout.do">로그아웃</a></th></tr>
<c:url var="mi" value="myinfo.do">
	<!-- name 속성의 이름이 반드시 vo의 필드명과 같아야 함 -->
	<c:param name="userid" value="${loginMember.userid }"/>
</c:url>
<tr><th><a href="${mi }">내 정보보기</a></th>
<th><a href="bwrite.do">게시글쓰기</a></th></tr>
<tr><th><a>메일확인</a></th><th><a>쪽지확인</a></th></tr>
</table>
</c:if>
</body>
</html>