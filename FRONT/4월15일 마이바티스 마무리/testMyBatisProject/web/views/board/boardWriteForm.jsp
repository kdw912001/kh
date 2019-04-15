<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="boardError.jsp" %>
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
<h2 align="center">공지글 쓰기</h2>
<form action="/testm/binsert" method="post" enctype="multipart/form-data">
<table align="center">
<tr><td>제목</td><td><input type="text" name="btitle"></td></tr>
<tr><td>작성자</td><td><input type="text" name="bwriter" readonly value="${ loginUser.userId }"></td></tr>
<tr><td>첨부파일</td>
<td><input type="file" name="bupfile"></td></tr>
<tr><td>내용</td>
<td><textarea cols="50" rows="7" name="bcontent"></textarea></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="등록하기"> &nbsp; 
	<input type="reset" value="입력취소"> &nbsp; 
	<a href="/testm/blist?page=1">[목록]</a>
</td></tr>
</table>
</form>

<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>






