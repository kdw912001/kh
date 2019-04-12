<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
</head>
<body>
<c:import url="../common/header.jsp"/>
<hr style="clear:both;">
<h2 align="center">${board.boardNum}번 게시글 수정페이지</h2>
<br>

<%-- <% if(board.getBoardReplyLev() == 0){ //원글 수정 %> --%>
<c:if test="${board.boardReplyLev eq 0 }">
<form action="/testm/boriginup" method="post" enctype="multipart/form-data">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="bnum" value="${board.boardNum}">
<input type="hidden" name="ofile" value="${board.boardOriginalFileName}">
<input type="hidden" name="rfile" value="${board.boardRenameFileName}">
<table align="center">
<tr><th>제목</th><td><input type="text" name="btitle" value="${board.boardTitle}"></td></tr>
<tr><th>작성자</th><td><input type="text" name="bwriter" readonly value="${board.boardWriter}"></td></tr>
<tr><th>첨부파일</th>
<td>
	<c:if test="${!empty board.boardOriginalFileName }">
	${board.boardOriginalFileName }
	</c:if>
<%-- <% } %> --%>
<br>
<input type="file" name="bupfile">
</td>
</tr>
<tr><th>내용</th>
<td><textarea rows="7" cols="50" name="bcontent">${board.boardContent}</textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp;
	<c:url var="blist" value="/blist">
		<c:param name="page" value="${page }"/>
	</c:url>
	<a href="${blist }">[목록]</a>
	<%-- <a href="/testm/blist?page=${page}">[목록]</a> --%>
</th></tr>
</table>
</form>
</c:if>
<c:if test="${board.boardReplyLev ne 0 }">
<%-- <% }else{ //댓글 수정 %> --%>
<form action="/testm/breplyup" method="post">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="bnum" value="${board.boardNum}">
<table align="center">
<tr><th>제목</th><td><input type="text" name="btitle" value="${board.boardTitle}"></td></tr>
<tr><th>작성자</th><td><input type="text" name="bwriter" readonly value="${board.boardWriter}"></td></tr>
<tr><th>내용</th>
<td><textarea rows="7" cols="50" name="bcontent">${board.boardContent}</textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp;
	<a href="${blist }">[목록]</a>
	<%-- <a href="/testm/blist?page=${page}">[목록]</a> --%>
</th></tr>
</table></form>
<%-- <% } %> --%>
</c:if>
<hr>
<c:import url="../common/footer.jsp"/>
</body>
</html>





