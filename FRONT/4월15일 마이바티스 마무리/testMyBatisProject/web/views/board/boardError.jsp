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
<h1>게시글 서비스 오류 발생</h1>
<c:set var="e" value="<%= exception %>" />
<c:if test="${!empty e }" >
<h3>JSP 예외 발생 : <%= exception.getMessage() %></h3>
<h3>예외클래스명 확인 : <%= exception.getClass().getName() %></h3>
</c:if>
<c:if test="${empty e }" >
<h3>서블릿 요청 실패 : ${ requestScope.message }</h3>
</c:if>
</body>
</html>