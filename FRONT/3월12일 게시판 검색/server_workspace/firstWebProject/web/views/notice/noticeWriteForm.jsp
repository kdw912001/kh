<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" import="member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
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
<h2 align="center">공지글 등록 페이지</h2>
<br>
<form action="/first/ninsert" method="post" 
	enctype="multipart/form-data">
<table align="center" width="600">
<tr><th>제목</th><td><input type="text" name="title" size="60"></td></tr>
<tr><th>작성자</th>
<td><input type="text" name="writer" value="<%= loginUser.getUserId() %>" readonly></td></tr>
<tr><th>첨부파일</th>
<td><input type="file" name="upfile"></td></tr>
<tr><th>내용</th>
<td><textarea rows="5" cols="50" name="content"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="등록하기"> &nbsp; 
	<input type="reset" value="작성취소"> &nbsp; 
	<a href="javascript:history.go(-1);">이전페이지로</a> &nbsp; 
	<a href="/first/nlist">목록</a>
</th></tr>
</table>
</form>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>






