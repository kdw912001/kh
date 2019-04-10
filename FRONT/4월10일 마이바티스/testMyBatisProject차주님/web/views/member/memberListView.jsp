<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="memberError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
	table, button { font-size: 11pt; }
</style>
</head>
<body>
<c:if test="${!empty loginUser and loginUser.userId eq 'admin' }">
	<c:import url="../common/adminHeader.jsp" />
</c:if>
<c:if test="${empty loginUser or loginUser.userId ne 'admin' }">
	<c:import url="../common/header.jsp" />
</c:if>
<hr style="clear:left;">
<h2 align="center">회원 전체 관리 페이지</h2>
<br>
<table align="center" cellspacing="0" border="1">
<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>이름</th>
	<th>나이</th>
	<th>성별</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>취미</th>
	<th>기타사항</th>
	<th>가입날짜</th>
	<th>마지막 정보 수정 날짜</th>
	<th>로그인 권한 제한</th>
	<th>강제 탈퇴 처리</th>
</tr>
<c:forEach items="${ list }" var="m" varStatus="status">
<tr>
	<td>${status.count }</td>
	<td>${m.userId }</td>
	<td>${m.userName }</td>
	<td>${m.age }</td>
	<td>${m.gender }</td>
	<td>${m.phone }</td>
	<td>${m.email }</td>
	<td>${m.hobby }</td>
	<td>${m.etc }</td>
	<td>${m.enrollDate }</td>
	<td>${m.lastModified }</td>
	<td><button>로그인제한</button> &nbsp; 
		<button>로그인허용</button></td>
	<td><button>강제탈퇴처리</button></td>
</tr>
</c:forEach>
</table>


<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>








