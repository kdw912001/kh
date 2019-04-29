<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
<style type="text/css">
table, button { font-size: 11pt; }
</style>
</head>
<body>
<h2 align="center">회원 전체 목록</h2>
<br>
<table align="center" cellspacing="0" border="1">
<tr>
	<th>순번</th>
	<th>아이디</th>
	<th>이름</th>
	<th>나이</th>
	<th>성별</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>취미</th>
	<th>특이사항</th>
	<th>가입날짜</th>
	<th>마지막 수정 날짜</th>
	<th>로그인 권한 제한</th>
	<th>강제 탈퇴 처리</th>	
</tr>
<c:forEach items="${ list }" var="member" varStatus="status">
<tr>
	<td>${status.count }</td>
	<td>${member.userId }</td>
	<td>${member.userName }</td>
	<td>${member.age }</td>
	<td>${member.gender }</td>
	<td>${member.phone }</td>
	<td>${member.email }</td>
	<td>${member.hobby }</td>
	<td>${member.etc }</td>
	<td>${member.enrollDate }</td>
	<td>${member.lastModified }</td>
	<td><button>로그인제한</button> &nbsp; 
		<button>로그인허용</button></td>
	<td><button>강제탈퇴처리</button></td>
</tr>
</c:forEach>
</table>



</body>
</html>







