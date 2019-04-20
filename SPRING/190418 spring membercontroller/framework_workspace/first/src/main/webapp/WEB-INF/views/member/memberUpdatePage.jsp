<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
	function checkValidate(){
		var pwd1 = document.getElementById("userpwd");
		var pwd2 = document.getElementById("userpwd2");
		
		if(pwd1.value != pwd2.value){
			alert("암호와 암호확인이 일치하지 않습니다.\n"
				+ "다시 확인하고 입력하십시요.");
			pwd1.select();
			return false;  //submit 취소
		}
		
		return true;  //submit 실행
	}
</script>
</head>
<body>
<c:import url="../common/header.jsp" />
<hr style="clear:both;">
<h1 align="center">
${member.username} 님의 회원 정보 수정페이지
</h1>
<form action="mupdate.do" method="post" onsubmit="return checkValidate();">
<table align="center" width="600" border="1">
<tr height="20"><th width="150" bgcolor="orange">아이디</th>
<td><input type="text" name="userid" 
value="${member.userid }" readonly></td></tr>
<tr height="20"><th width="150" bgcolor="orange">이 름</th>
<td><input type="text" name="username" 
value="${member.username }"></td></tr>
<tr height="20"><th width="150" bgcolor="orange">암 호</th>
<td><input type="password" name="userpwd" id="userpwd"
value="${member.userpwd }"></td></tr>
<tr height="20"><th width="150" bgcolor="orange">암호확인</th>
<td><input type="password" id="userpwd2" 
value="${member.userpwd }" ></td></tr>
<tr height="20"><th bgcolor="orange">성 별</th>
<td>
<c:if test="${member.gender eq 'M' }">
	<input type="radio" name="gender" value="M" checked> 남
	&nbsp; &nbsp;
	<input type="radio" name="gender" value="F"> 여
</c:if>
<c:if test="${member.gender eq 'F' }">
	<input type="radio" name="gender" value="M"> 남
	&nbsp; &nbsp;
	<input type="radio" name="gender" value="F" checked> 여
</c:if>
</td></tr>
<tr height="20"><th bgcolor="orange">나 이</th>
<td><input type="number" name="age" 
value="${member.age }" min="19" max="150"></td></tr>
<tr height="20"><th bgcolor="orange">전화번호</th>
<td><input type="tel" name="phone" 
value="${member.phone }"></td></tr>
<tr height="20"><th bgcolor="orange">이메일</th>
<td><input type="email" name="email" 
value="${member.email }"></td></tr>
<tr height="20"><th bgcolor="orange">취 미</th>
<td>
<table>
<tr>
	<td width="150">
	<c:forTokens items="${member.hobby }" delims="," 
	var="s">
		<c:if test="${s eq 'game' }">
			<c:set var="checked0" value="checked"/>
		</c:if>
		<c:if test="${s eq 'reading' }">
			<c:set var="checked1" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'music' }">
			<c:set var="checked2" value="checked"/>
		</c:if>
		<c:if test="${s eq 'climb' }">
			<c:set var="checked3" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'sport' }">
			<c:set var="checked4" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'movie' }">
			<c:set var="checked5" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'travel' }">
			<c:set var="checked6" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'cook' }">
			<c:set var="checked7" value="checked"/>
		</c:if>		
		<c:if test="${s eq 'etc' }">
			<c:set var="checked8" value="checked"/>
		</c:if>		
	</c:forTokens>
	<input type="checkbox" name="hobby" value="game" ${checked0 }> 게임
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="reading" ${checked1 }> 책읽기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="music" ${checked2 }> 음악듣기
	</td>
</tr>
<tr>
	<td width="150">
	<input type="checkbox" name="hobby" value="climb" ${checked3 }> 등산
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="sport" ${checked4 }> 운동
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="movie" ${checked5 }> 영화감상
	</td>
</tr>
<tr>
	<td width="150">
	<input type="checkbox" name="hobby" value="travel" ${checked6 }> 여행하기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="cook" ${checked7 }> 요리하기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="etc" ${checked8 }> 기타
	</td>
</tr>
</table>
</td></tr>
<tr height="20"><th bgcolor="orange">기 타</th>
<td><textarea name="etc" rows="5" cols="50">
${member.etc }</textarea></td></tr>
<tr height="20"><th bgcolor="orange">가입날짜</th>
<td><input type="date" name="enrolldate" 
value="${member.enroll_date }" readonly></td></tr>
<tr height="20"><th colspan="2">
<input type="submit" value="수정하기">
&nbsp; &nbsp;
<a href="javascript:history.go(-1);">이전페이지로 이동</a>
</th></tr>
</table>
</form>



</body>
</html>





