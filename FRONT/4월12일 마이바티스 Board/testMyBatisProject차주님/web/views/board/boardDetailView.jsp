<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, board.model.vo.Board, java.sql.Date" %>
<%
	Board board = (Board)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h2 align="center"><%= board.getBoardNum() %>번 공지글 상세보기</h2>
<br>
<table align="center" cellpadding="10" cellspacing="0" 
border="1" width="500">
<tr>
	<th>제목</th>
	<td><%= board.getBoardTitle() %></td>
</tr>
<tr>
	<th>작성자</th>
	<td><%= board.getBoardWriter() %></td>
</tr>
<tr>
	<th>첨부파일</th>
	<td>
		<% if(board.getBoardOriginalFileName() != null){ %>
			<a href="/testm/bfdown?ofile=<%= board.getBoardOriginalFileName() %>&rfile=<%= board.getBoardRenameFileName() %>"><%= board.getBoardOriginalFileName() %></a>
		<% }else{ %>
			첨부파일없음
		<% } %>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><%= board.getBoardContent() %></td>
</tr>
<tr>
	<th colspan="2">
	<% if(loginUser != null && board.getBoardReplyLev() < 2){ %>
		<a href="/testm/views/board/boardReplyForm.jsp?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>">[댓글달기]</a>
	<% } %>
	&nbsp; &nbsp;
	<% if(loginUser.getUserId().equals(board.getBoardWriter())){ %>
		<a href="/testm/bupview?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>">[수정페이지로 이동]</a> 
		&nbsp; &nbsp;
		<a href="/testm/bdelete?bnum=<%= board.getBoardNum() %>">[글삭제]</a>
	<% } %>
	&nbsp; &nbsp;
	<a href="/testm/blist?page=<%= currentPage %>">[목록]</a>
	</th>	
</tr>

</table>


<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>





