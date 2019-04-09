<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>   
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
<h2 align="center">${param.bnum}번 글의 댓글달기</h2>
<form action="/second/breply" method="post">
<input type="hidden" name="bnum" value="${param.bnum}">
<input type="hidden" name="page" value="${param.page }">
<table align="center">
<tr><th>제목</th><td><input type="text" name="btitle"></td></tr>
<tr><th>작성자</th><td><input type="text" name="bwriter" readonly value="${loginUser.userId }"></td></tr>
<tr><th>내용</th><td><textarea cols="50" rows="5" name="bcontent"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="댓글등록"> &nbsp; 
	<a href="javascript:history.go(-1);">[이전 페이지로 이동]</a> &nbsp;
	<c:url var="blist" value="/blist">
		<c:param name="page" value="${param.page }"/>
	</c:url>
	<a href="${blist }">[목록]</a>
	<%-- <a href="/second/blist?page=${param.page }">[목록]</a> --%>
</th></tr>
</table>
</form>
<hr>
<c:import url="../common/footer.jsp"/>
</body>
</html>





