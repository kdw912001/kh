<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*, java.util.*, member.model.vo.Member" %>
<%
	HashMap<Integer, Notice> map = (HashMap<Integer, Notice>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");
	/* Collection<Notice> values = map.values();
	ArrayList<Notice> list = new ArrayList<Notice>(values); */
	ArrayList<Notice> list = new ArrayList<Notice>(map.values());
	/* list.sort(new NoticeNoDescending()); */
	Collections.sort(list, new NoticeNoDescending());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h2 align="center">공지사항 목록 보기</h2>
<br>
<table align="center" width="650px" cellspacing="0" border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>날짜</th>
	<th>첨부파일</th>
</tr>
<%
	for(Notice notice : list){
%>
<tr>
		<td align="center"><%= notice.getNoticeNo() %></td>
		<td>
		<% if(loginUser != null){//로그인한 상태 %>
			<a href="/first/ndetail?no=<%= notice.getNoticeNo() %>"><%= notice.getNoticeTitle() %></a>
		<% }else{ %>
				<%= notice.getNoticeTitle() %>
		<% } %>
		</td>
		<td align="center"><%= notice.getNoticeWriter() %></td>
		<td align="center"><%= notice.getNoticeDate() %></td>
		<td align="center">
		<% if(notice.getOriginalFilePath() != null){ //첨부파일이 있다면 %>
			○
		<% }else{ //첨부파일이 없다면 %>
				&nbsp;
		<% } %>
		</td>
		<%-- <td><%=notice.getNoticeNo() %></td>
		<td><%=notice.getNoticeTitle() %></td>
		<td><%=notice.getNoticeWriter() %></td>
		<td><%=notice.getNoticeDate() %></td>
		<td><%=notice.getOriginalFilePath() %></td> --%>
</tr>
<% }%>
</table>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>