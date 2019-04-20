<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<script type="text/javascript">
	function moveUpdatePage(){
		location.href = "mupview.do?userid=${member.userid}";
	}
	
	function memberDeleteCall(){
		location.href = "mdel.do?userid=${ member.userid }";
	}
</script>
</head>
<body>
<c:import url="../common/header.jsp" />
<hr style="clear:both;">
<h1 align="center">
${ member.username } 님의 회원 정보
</h1>
<table align="center" width="600" border="1">
<tr height="20"><th width="150" bgcolor="orange">아이디</th>
<td>${ member.userid }</td></tr>
<tr height="20"><th bgcolor="orange">성 별</th>
<td>${ member.gender }</td></tr>
<tr height="20"><th bgcolor="orange">나 이</th>
<td>${ member.age }</td></tr>
<tr height="20"><th bgcolor="orange">전화번호</th>
<td>${ member.phone }</td></tr>
<tr height="20"><th bgcolor="orange">이메일</th>
<td>${ member.email }</td></tr>
<tr height="20"><th bgcolor="orange">취 미</th>
<td>${ member.hobby }</td></tr>
<tr height="20"><th bgcolor="orange">기 타</th>
<td>${ member.etc }</td></tr>
<tr height="20"><th bgcolor="orange">가입날짜</th>
<td>${ member.enroll_date }</td></tr>
<tr height="20"><th colspan="2">
<button onclick="moveUpdatePage();">수정페이지로 이동</button>
&nbsp; &nbsp;
<button onclick="memberDeleteCall();">탈퇴하기</button>
</th></tr>
</table>

</body>
</html>







