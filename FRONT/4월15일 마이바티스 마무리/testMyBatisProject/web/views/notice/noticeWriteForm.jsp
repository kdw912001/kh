<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
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
<h2 align="center">공지글 등록 페이지</h2>
<br>
<form action="/testm/ninsert" method="post" 
	enctype="multipart/form-data">
<table align="center" width="600">
<tr><th>제목</th><td><input type="text" name="title" size="60"></td></tr>
<tr><th>작성자</th>
<td><input type="text" name="writer" value="${ loginUser.userId }" readonly></td></tr>
<tr><th>첨부파일</th>
<td><input type="file" name="upfile"></td></tr>
<tr><th>내용</th>
<td><textarea rows="5" cols="50" name="content"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="등록하기"> &nbsp; 
	<input type="reset" value="작성취소"> &nbsp; 
	<a href="javascript:history.go(-1);">이전페이지로</a> &nbsp; 
	<a href="/testm/nlist">목록</a>
</th></tr>
</table>
</form>

<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>






