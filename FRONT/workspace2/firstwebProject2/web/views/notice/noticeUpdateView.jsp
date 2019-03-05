<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");
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
<h2 align="center"><%= notice.getNoticeNo() %>번 공지글 수정</h2>
<hr>
<form>
<table align="center" width="600">
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="<%= notice.getNoticeTitle() %>"></td>
</tr>
<tr>
	<th>작성자</th>
	<td><input type="text" name="writer" value="<%= notice.getNoticeWriter() %>" readonly></td>
</tr>
<tr>
	<th>첨부파일</th>
	<td></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="5" cols="50" name="content"><%= notice.getNoticeContent() %></textarea></td>
</tr>
<tr>
	<th colspan="2">
	<input type="submit" value="수정하기">
	<button onclick="history.go(-1); return false;">이전 페이지 이동</button></th>
	<td></td>
</tr>
</table>
</form>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>