<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
</head>
<body>
<c:import url="../common/header.jsp" />
<hr style="clear:both;">
<h2 align="center">${ board.boardNum }번 공지글 상세보기</h2>
<br>
<table align="center" cellpadding="10" cellspacing="0" 
border="1" width="500">
<tr>
	<th>제목</th>
	<td>${  board.boardTitle }</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${  board.boardWriter }</td>
</tr>
<tr>
	<th>첨부파일</th>
	<td>
		<c:if test="${ !empty board.boardOriginalFileName }">
			<a href="/testm/bfdown?ofile=${ board.boardOriginalFileName }&rfile=${ board.boardRenameFileName }">${ board.getBoardOriginalFileName }</a>
		</c:if>
		<c:if test="${ empty board.boardOriginalFileName }">
			첨부파일없음
		</c:if>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>${  board.boardContent }</td>
</tr>
<tr>
	<th colspan="2">
	<c:if test="${ !empty loginUser and board.boardReplyLev < 2 }">
		<a href="/testm/views/board/boardReplyForm.jsp?bnum=${ board.getBoardNum }&page=${ currentPage }">[댓글달기]</a>
	</c:if>
	&nbsp; &nbsp;
	<c:if test="${ loginUser.userId eq board.boardWriter }">
		<a href="/testm/bupview?bnum=${ board.boardNum }&page=${ currentPage }">[수정페이지로 이동]</a> 
		&nbsp; &nbsp;
		<a href="/testm/bdelete?bnum=${ board.boardNum }">[글삭제]</a>
	</c:if>
	&nbsp; &nbsp;
	<c:url var="bl" value="/testm/blist">
		<c:param name="page" value="${ currentPage "/>
	</c:url>
	<a href="${bl }">[목록]</a>
	</th>	
</tr>

</table>


<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>





