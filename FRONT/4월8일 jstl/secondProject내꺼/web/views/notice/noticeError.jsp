<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
</head>
<body>
<% if(exception != null){ %>
<h3>JSP 오류발생 : <%= exception.getMessage() %></h3>
<% }else{ %>
<h3>서블릿 오류발생 : <%= (String)request.getAttribute("message") %></h3>
<% } %>
<a href="javascript:history.go(-1);">이전 페이지로 이동</a>
</body>
</html>