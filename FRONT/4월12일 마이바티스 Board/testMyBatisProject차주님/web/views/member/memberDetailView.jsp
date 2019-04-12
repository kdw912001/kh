<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="memberError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/testm/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//암호확인 입력상자가 focus가 사라졌을 때
	$("#userpwd2").blur(function(){
		console.log("포커스 사라짐.");
		var pwd1 = $("#userpwd1").val();
		var pwd2 = $("#userpwd2").val();
		
		if(pwd1 != pwd2){
			alert("암호와 암호확인이 일치하지 않습니다.\n"
				+ "다시 입력하십시요.");
			$("#userpwd1").select();
		}
	});
});
</script>
</head>
<body>
<c:if test="${!empty loginUser and loginUser.userId eq 'admin' }">
	<c:import url="../common/adminHeader.jsp" />
</c:if>
<c:if test="${empty loginUser or loginUser.userId ne 'admin' }">
	<c:import url="../common/header.jsp" />
</c:if>
<hr style="clear:left;">
<h1 align="center">${requestScope.member.userName } 님, 회원 정보 상세보기</h1>
<br>
<form action="/testm/mupdate" method="post">
<table width="650" align="center">
	<tr height="40">
		<th width="150">아이디</th>
		<td><input type="text" name="userid" readonly 
		value="${member.userId }"> 
		</td>
	</tr>
	<tr height="40">
		<th width="150">이 름</th>
		<td><input type="text" name="username" readonly 
		value="${member.userName }"></td>
	</tr>
	<tr height="40">
		<th width="150">암 호</th>
		<td><input type="password" id="userpwd1" 
		name="userpwd" value="${member.userPwd }"></td>
	</tr>
	<tr height="40">
		<th width="150">암호확인</th>
		<td><input type="password" id="userpwd2" 
		value="${member.userPwd }"></td>
	</tr>
	<tr height="40">
		<th width="150">성 별</th>
		<td>
		<c:if test="${member.gender eq 'M' }">
			<input type="radio" name="gender" value="M" checked> 남자 &nbsp; 
			<input type="radio" name="gender" value="F"> 여자
		</c:if>
		<c:if test="${member.gender eq 'F' }">
			<input type="radio" name="gender" value="M"> 남자 &nbsp; 
			<input type="radio" name="gender" value="F" checked> 여자
		</c:if>
		</td>
	</tr>
	<tr height="40">
		<th width="150">나 이</th>
		<td>
			<input type="number" name="age" min="20" 
			max="100" value="${member.age }">
		</td>
	</tr>
	<tr height="40">
		<th width="150">전화번호</th>
		<td><input type="tel" name="phone" 
		value="${member.phone }"></td>
	</tr>
	<tr height="40">
		<th width="150">이메일</th>
		<td><input type="email" name="email" 
		value="${member.email }"></td>
	</tr>
	<tr height="40">
		<th width="150">취 미</th>
		<td>
		<c:forTokens items="${member.hobby }" delims="," var="hb">
			<c:if test="${hb eq 'game' }">
				<c:set var="checked0" value="checked" />
			</c:if>
			<c:if test="${hb eq 'reading' }">
				<c:set var="checked1" value="checked" />
			</c:if>
			<c:if test="${hb eq 'music' }">
				<c:set var="checked2" value="checked" />
			</c:if>
			<c:if test="${hb eq 'climb' }">
				<c:set var="checked3" value="checked" />
			</c:if>
			<c:if test="${hb eq 'sport' }">
				<c:set var="checked4" value="checked" />
			</c:if>
			<c:if test="${hb eq 'movie' }">
				<c:set var="checked5" value="checked" />
			</c:if>
			<c:if test="${hb eq 'travel' }">
				<c:set var="checked6" value="checked" />
			</c:if>
			<c:if test="${hb eq 'cook' }">
				<c:set var="checked7" value="checked" />
			</c:if>
			<c:if test="${hb eq 'etc' }">
				<c:set var="checked8" value="checked" />
			</c:if>
		</c:forTokens>
		
		<table>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="game" ${checked0 }> 게임</td>
			<td width="150"><input type="checkbox" name="hobby" value="reading" ${checked1 }> 독서</td>
			<td width="150"><input type="checkbox" name="hobby" value="music" ${checked2 }> 음악감상</td>
		</tr>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="climb" ${checked3 }> 등산</td>
			<td width="150"><input type="checkbox" name="hobby" value="sport" ${checked4 }> 운동</td>
			<td width="150"><input type="checkbox" name="hobby" value="movie" ${checked5 }> 영화</td>
		</tr>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="travel" ${checked6 }> 여행</td>
			<td width="150"><input type="checkbox" name="hobby" value="cook" ${checked7 }> 요리</td>
			<td width="150"><input type="checkbox" name="hobby" value="etc" ${checked8 }> 기타</td>
		</tr>
		</table>
		</td>
	</tr>
	<tr height="40">
		<th width="150">하고싶은말</th>
		<td><textarea name="etc" rows="3" cols="30" align="left">${member.etc }</textarea></td>
	</tr>
	<tr height="40">
		<th colspan="2">
		<input type="submit" value="수정하기"> &nbsp; 
		<input type="reset" value="작성취소"> &nbsp; 
		<c:url var="md" value="/testm/mdel">
			<c:param name="userid" value="${member.userId }" />
		</c:url>
		<a href="${md }">탈퇴하기</a>
		&nbsp; &nbsp;
		<a href="/testm/index.jsp">시작페이지로 이동</a>
		</th>		
	</tr>
	</table>
</form>
<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>






