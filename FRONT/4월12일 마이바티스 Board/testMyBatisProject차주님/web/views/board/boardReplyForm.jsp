<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>    
<%
	int boardNum = Integer.parseInt(request.getParameter("bnum"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
	
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
<h2 align="center"><%= boardNum %>번 글의 댓글달기</h2>
<form action="/testm/breply" method="post">
<input type="hidden" name="bnum" value="<%= boardNum %>">
<input type="hidden" name="page" value="<%= currentPage %>">
<table align="center">
<tr><th>제목</th><td><input type="text" name="btitle"></td></tr>
<tr><th>작성자</th><td><input type="text" name="bwriter" readonly value="<%= loginUser.getUserId() %>"></td></tr>
<tr><th>내용</th><td><textarea cols="50" rows="5" name="bcontent"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="댓글등록"> &nbsp; 
	<a href="javascript:history.go(-1);">[이전 페이지로 이동]</a> &nbsp;
	<a href="/testm/blist?page=<%= currentPage %>">[목록]</a>
</th></tr>
</table>
</form>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>





