<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
</head>
<body>
<c:set var="e" value="<%= exception %>" />
<c:if test="${ !empty e }">
<h3>JSP 오류발생 : <%= exception.getMessage() %></h3>
</c:if>
<c:if test="${ empty e }">
<h3>서블릿 오류발생 : ${ requestScope.message }</h3>
</c:if>
<a href="/testm/index.jsp">시작 페이지로 이동</a>
</body>
</html>