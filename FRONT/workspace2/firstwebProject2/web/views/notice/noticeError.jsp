<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<h3>오류발생 : <%= (String)request.getAttribute("message") %> </h3>
<a href="javascript:history.go(-1)">이전 페이지로 이동</a>
</body>
</html>