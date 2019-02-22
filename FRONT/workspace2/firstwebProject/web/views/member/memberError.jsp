<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<h1><%= request.getAttribute("message") %></h1>
<a href="/first/index.jsp">시작페이지로 이동</a>
</body>
</html>