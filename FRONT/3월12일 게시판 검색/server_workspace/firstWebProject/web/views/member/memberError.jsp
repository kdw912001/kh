<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import="member.model.vo.Member" %>
<%
	//스크립트릿(scriptlet) 태그 영역
	//자바 코드 작성 영역임
	Member loginUser = (Member)session.getAttribute("loginUser");
	String message = (String)request.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<%@ include file="../common/adminHeader.jsp" %>
<% }else{ %>
	<%@ include file="../common/header.jsp" %>
<% } %>
<hr style="clear:left;">
<h1>회원서비스 오류</h1>
<% if(exception != null){ %>
JSP 예외발생 : <%= exception.getMessage() %> <br>
<% }else{ %>
서블릿이 전달한 메세지 : <%= message %>  <br>
<% } %>
<br>
<a href="/first/index.jsp">시작페이지로 이동</a> <br>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









