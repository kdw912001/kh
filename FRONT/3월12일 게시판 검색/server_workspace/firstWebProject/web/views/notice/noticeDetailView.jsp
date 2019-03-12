<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ page import="notice.model.vo.Notice, member.model.vo.Member" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
function moveUpdatePage(){
	location.href = "/first/nupview?no=" + <%= notice.getNoticeNo() %>;
}

function deleteNotice(){
	location.href = "/first/ndel?no=" + <%= notice.getNoticeNo() %>;
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<br>
<h2 align="center"><%= notice.getNoticeNo() %> 번 공지글 상세보기</h2>
<br>
<table align="center" width="600">
<tr>
	<th>제목</th>
	<td><%= notice.getNoticeTitle() %></td>
</tr>
<tr>
	<th>작성자</th>
	<td><%= notice.getNoticeWriter() %></td>
</tr>
<tr>
	<th>첨부파일</th>
	<td>
	<% if(notice.getOriginalFilePath() != null){ %>
		<a href="/first/nfdown?ofile=<%= notice.getOriginalFilePath() %>&rfile=<%= notice.getRenameFilePath() %>"><%= notice.getOriginalFilePath() %></a>
	<% }else{ %>
		첨부파일 없음
	<% } %>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><%= notice.getNoticeContent() %></td>
</tr>
<tr>
	<th colspan="2">
	<% if(loginUser.getUserId().equals(notice.getNoticeWriter())){ %>
		<button onclick="moveUpdatePage();">수정페이지로 이동</button> &nbsp; 
		<button onclick="deleteNotice();">글삭제</button> &nbsp;
	<% } %>
	<button onclick="location.href='/first/nlist'; return false;">목록</button>
	</th>	
</tr>
</table>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









