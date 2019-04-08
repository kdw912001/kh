<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import = 'member.model.vo.Member' %>
<%
 Member member = (Member)session.getAttribute("loginUser");
 String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원서비스 오류</h1>
<% if(exception != null) { %>
JSP예외발생 : <%= exception.getMessage() %> <br>
<% } else { %>
서블릿이 전달한 메세지 : <%= message %>    <br>
<% } %>
<br>
<a href=/doggybeta/index.jsp> 메인페이지로 이동 </a>

</body>
</html>