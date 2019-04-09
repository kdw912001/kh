<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<c:import url="../common/header.jsp"/>
<hr style="clear:both;">
<h2 align="center">${board.boardNum}번 공지글 상세보기</h2>
<br>
<table align="center" cellpadding="10" cellspacing="0" 
border="1" width="500">
<tr>
	<th>제목</th>
	<td>${board.boardTitle}</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${board.boardWriter}</td>
</tr>
<tr>
	<th>첨부파일</th>
	<td>
		<c:if test="${!empty board.boardOriginalFileName }">
		<%-- <% if(board.getBoardOriginalFileName() != null){ %> --%>
			<%-- <a href="/second/bfdown?ofile=<%= board.getBoardOriginalFileName() %>&rfile=<%= board.getBoardRenameFileName() %>"><%= board.getBoardOriginalFileName() %></a> --%>
			<c:url var="bfdown" value="/bfdown">
				<c:param name="ofile" value="${board.boardOriginalFileName }"/>
				<c:param name="rfile" value="${board.boardRenameFileName }"/>
			</c:url>
			<a href="${bfdown }">${board.boardOriginalFileName }</a>
			<%-- <a href="/second/bfdown?ofile=${board.boardOriginalFileName }&rfile=${board.boardRenameFileName}">${board.boardOriginalFileName }</a> --%>
		</c:if>
		<c:if test="${empty board.boardOriginalFileName }">
		<%-- <% }else{ %> --%>
			첨부파일없음
		</c:if>
		<%-- <% } %> --%>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>${board.boardContent}</td>
</tr>
<tr>
	<th colspan="2">
	<%-- <% if(loginUser != null && board.getBoardReplyLev() < 2){ %>
		<a href="/second/views/board/boardReplyForm.jsp?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>">[댓글달기]</a>
	<% } %> --%>
	<c:if test="${!empty loginUser and board.boardReplyLev lt 2 }">
		<c:url var="boardReplyForm" value="/views/board/boardReplyForm.jsp">
			<c:param name="bnum" value="${board.boardNum }"/>
			<c:param name="page" value="${currentPage }"/>
		</c:url>
		<a href="${boardReplyForm }">[댓글달기]</a>
		<%-- <a href="/second/views/board/boardReplyForm.jsp?bnum=${board.boardNum}&page=${currentPage}">[댓글달기]</a> --%>
	</c:if>
	&nbsp; &nbsp;
	<%-- <% if(loginUser.getUserId().equals(board.getBoardWriter())){ %>
		<a href="/second/bupview?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>">[수정페이지로 이동]</a> 
		&nbsp; &nbsp;
		<a href="/second/bdelete?bnum=<%= board.getBoardNum() %>">[글삭제]</a>
	<% } %> --%>
	<c:if test="${loginUser.userId eq board.boardWriter }">
		<c:url var="bupview" value="/bupview">
			<c:param name="bnum" value="${board.boardNum }"/>
			<c:param name="page" value="${currentPage }"/>
		</c:url>
		<a href="${bupview }">[수정페이지로 이동]</a>
		<%-- <a href="/second/bupview?bnum=${board.boardNum }&page=${currentPage}">[수정페이지로 이동]</a> --%> 
		&nbsp; &nbsp;
		<c:url var="bdelete" value="/bdelete">
			<c:param name="bnum" value="${board.boardNum }"/>
		</c:url>
		<a href="${bdelete}">[글삭제]</a>
		<%-- <a href="/second/bdelete?bnum=${board.boardNum }">[글삭제]</a> --%>
	</c:if>
	&nbsp; &nbsp;
	<c:url var="blist" value="/blist">
		<c:param name="page" value="${currentPage }"/>
	</c:url>
	<a href="${blist }">[목록]</a>
	<%-- <a href="/second/blist?page=${currentPage }">[목록]</a> --%>
	</th>	
</tr>

</table>


<hr>
<c:import url="../common/footer.jsp"/>
</body>
</html>





