<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미니 프로젝트</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<c:if test="${empty loginUser }">
		<%@ include file="user/loginForm.jsp" %>
	</c:if>
	<c:if test="${!empty loginUser }">
		<%@ include file="user/loginSuccess.jsp" %>
	</c:if>
</body>
</html>