<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String errorMessage = (String)request.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
<h1>에러 발생 : <%= errorMessage %></h1>
<h2><a href="index.html">시작페이지로 이동</a></h2>
</body>
</html>