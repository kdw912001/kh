<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="memberError.jsp" import="member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Member member = (Member)request.getAttribute("member");
	
	//취미 checked 처리
	String[] hobbies = member.getHobby().split(",");
	String[] checked = new String[9];
	for(String s : hobbies){
		switch(s){
		case "game":	checked[0] = "checked";  break;
		case "reading": checked[1] = "checked";  break;
		case "music":	checked[2] = "checked";  break;
		case "climb":	checked[3] = "checked";  break;
		case "sport":	checked[4] = "checked";  break;
		case "movie":	checked[5] = "checked";  break;
		case "travel":	checked[6] = "checked";  break;
		case "cook":	checked[7] = "checked";  break;
		case "etc":	checked[8] = "checked";  break;
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.3.1.min.js"></script>
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
<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<%@ include file="../common/adminHeader.jsp" %>
<% }else{ %>
	<%@ include file="../common/header.jsp" %>
<% } %>
<hr style="clear:left;">
<h1 align="center"><%= member.getUserId() %> 님, 회원 정보 상세보기</h1>
<br>
<form action="/first/mupdate" method="post">
<table width="650" align="center">
	<tr height="40">
		<th width="150">아이디</th>
		<td><input type="text" name="userid" readonly 
		value="<%= member.getUserId() %>"> 
		</td>
	</tr>
	<tr height="40">
		<th width="150">이 름</th>
		<td><input type="text" name="username" readonly 
		value="<%= member.getUserName() %>"></td>
	</tr>
	<tr height="40">
		<th width="150">암 호</th>
		<td><input type="password" id="userpwd1" 
		name="userpwd" value="<%= member.getUserPwd() %>"></td>
	</tr>
	<tr height="40">
		<th width="150">암호확인</th>
		<td><input type="password" id="userpwd2" 
		value="<%= member.getUserPwd() %>"></td>
	</tr>
	<tr height="40">
		<th width="150">성 별</th>
		<td>
		<% if(member.getGender().equals("M")){ %>
			<input type="radio" name="gender" value="M" checked> 남자 &nbsp; 
			<input type="radio" name="gender" value="F"> 여자
		<% }else{ %>
			<input type="radio" name="gender" value="M"> 남자 &nbsp; 
			<input type="radio" name="gender" value="F" checked> 여자
		<% } %>
		</td>
	</tr>
	<tr height="40">
		<th width="150">나 이</th>
		<td>
			<input type="number" name="age" min="20" 
			max="100" value="<%= member.getAge() %>">
		</td>
	</tr>
	<tr height="40">
		<th width="150">전화번호</th>
		<td><input type="tel" name="phone" 
		value="<%= member.getPhone() %>"></td>
	</tr>
	<tr height="40">
		<th width="150">이메일</th>
		<td><input type="email" name="email" 
		value="<%= member.getEmail() %>"></td>
	</tr>
	<tr height="40">
		<th width="150">취 미</th>
		<td>
		<table>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="game" <%= checked[0] %>> 게임</td>
			<td width="150"><input type="checkbox" name="hobby" value="reading" <%= checked[1] %>> 독서</td>
			<td width="150"><input type="checkbox" name="hobby" value="music" <%= checked[2] %>> 음악감상</td>
		</tr>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="climb" <%= checked[3] %>> 등산</td>
			<td width="150"><input type="checkbox" name="hobby" value="sport" <%= checked[4] %>> 운동</td>
			<td width="150"><input type="checkbox" name="hobby" value="movie" <%= checked[5] %>> 영화</td>
		</tr>
		<tr>
			<td width="150"><input type="checkbox" name="hobby" value="travel" <%= checked[6] %>> 여행</td>
			<td width="150"><input type="checkbox" name="hobby" value="cook" <%= checked[7] %>> 요리</td>
			<td width="150"><input type="checkbox" name="hobby" value="etc" <%= checked[8] %>> 기타</td>
		</tr>
		</table>
		</td>
	</tr>
	<tr height="40">
		<th width="150">하고싶은말</th>
		<td><textarea name="etc" rows="3" cols="30" align="left"><%= member.getEtc() %></textarea></td>
	</tr>
	<tr height="40">
		<th colspan="2">
		<input type="submit" value="수정하기"> &nbsp; 
		<input type="reset" value="작성취소"> &nbsp; 
		<a href="/first/mdel?userid=<%= member.getUserId() %>">탈퇴하기</a>
		&nbsp; &nbsp;
		<a href="/first/index.jsp">시작페이지로 이동</a>
		</th>		
	</tr>
	</table>
</form>




<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>






