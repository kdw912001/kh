<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] files1 = (String[])request.getAttribute("files1");
	String[] files2 = (String[])request.getAttribute("files2");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file list view</title>
</head>
<body>
<h1>web/uploadFiles 폴더에 저장된 파일 목록</h1>
<%
	for(String fileName : files1){
%>
	<a href="/testf/filedown?no=1&fname=<%= fileName %>"><%= fileName %></a><br>
<% } %>
<h1>web/uploadFiles2 폴더에 저장된 파일 목록</h1>
<%
	for(String fileName : files2){
%>
	<a href="/testf/filedown?no=2&fname=<%= fileName %>"><%= fileName %></a><br>
<% } %>
</body>
</html>




