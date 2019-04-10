<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<c:if test="${!empty loginUser && loginUser.userId eq 'admin'}">
	<c:import url="../common/adminHeader.jsp"/>
</c:if>
<c:if test="${empty loginUser || loginUser.userId ne 'admin' }">
	<c:import url="../common/header.jsp"/>
</c:if>
<hr style="clear:left;">
<h1>회원서비스 오류</h1>
<c:if test="${!empty exception }">
<h3>JSP 오류발생 : ${exception.message }</h3>
</c:if>
<c:if test="${empty exception }">
<h3>서블릿 오류발생 : ${message}</h3>
</c:if>
<%-- <% if(exception != null){ %>
JSP 예외발생 : <%= exception.getMessage() %> <br>
<% }else{ %>
서블릿이 전달한 메세지 : ${message }  <br>
<% } %> --%>
<br>
<a href="/testm/index.jsp">시작페이지로 이동</a> <br>
<hr>
<c:import url="../common/footer.jsp"/>
</body>
</html>









