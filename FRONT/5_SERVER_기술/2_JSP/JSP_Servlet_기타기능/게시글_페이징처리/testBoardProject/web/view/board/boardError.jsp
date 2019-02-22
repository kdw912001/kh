<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String message = (String)request.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board error</title>
</head>
<body>
<h1>게시글 서비스 에러 페이지</h1>
<%
	if(message != null){
%>
<h2><%= message %></h2>
<% }else{ %>
<h2><%= exception.getClass().getName() %> </h2>
<h2><%= exception.getMessage() %></h2>
<% } %>
<h2><a href="/testb/index.html">시작페이지로 이동</a></h2>
</body>
</html>