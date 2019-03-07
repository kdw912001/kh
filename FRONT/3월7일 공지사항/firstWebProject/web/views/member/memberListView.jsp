<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="memberError.jsp" import="member.model.vo.Member, java.util.ArrayList" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>    
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
<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<%@ include file="../common/adminHeader.jsp" %>
<% }else{ %>
	<%@ include file="../common/header.jsp" %>
<% } %>
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
<% for(int i = 0; i < list.size(); i++){ %>
<tr>
	<td><%= i + 1 %></td>
	<td><%= list.get(i).getUserId() %></td>
	<td><%= list.get(i).getUserName() %></td>
	<td><%= list.get(i).getAge() %></td>
	<td><%= list.get(i).getGender() %></td>
	<td><%= list.get(i).getPhone() %></td>
	<td><%= list.get(i).getEmail() %></td>
	<td><%= list.get(i).getHobby() %></td>
	<td><%= list.get(i).getEtc() %></td>
	<td><%= list.get(i).getEnrollDate() %></td>
	<td><%= list.get(i).getLastModified() %></td>
	<td><button>로그인제한</button> &nbsp; 
		<button>로그인허용</button></td>
	<td><button>강제탈퇴처리</button></td>
</tr>
<% } %>
</table>



<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>








