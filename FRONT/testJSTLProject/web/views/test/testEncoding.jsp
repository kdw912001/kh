<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>testFmt.jsp 에서 전송한 test 값 출력 확인</h1>
<%-- ${param.test } --%><br><!-- 값을 꺼내기전에 setCharacterEncoding("utf-8") 해야함  -->
<%-- <%
	request.setCharacterEncoding("utf-8");
	String value = request.getParameter("test");
%>
확인 : <%= value %> <br> --%>
<fmt:requestEncoding value="utf-8"/><!-- request.setCharacterEncoding("utf-8");과 같음  -->
<c:set var="value" value="${param.test }"/>
전송받은 값 확인 : ${value } <br>
</body>
</html>