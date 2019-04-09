<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testCore</title>
</head>
<body>
<h1>jstl core library test page</h1>
<h4>c:set 태그 : 변수 선언과 값 기록용 태그</h4>
<c:set var="num1" value="100" />
<c:set var="num2" value="200" />
num1 : ${num1 } <br>
num2 : ${num2 } <br>
<c:set var="sum" value="${num1 + num2 }" />
sum : ${sum } <br>
<%
	int n1 = 11, n2 = 22;
%>
<c:set var="result" value="<%= n1 + n2 %>" scope="session"/>
result : ${result } <br>
<hr>
<h4>c:set 태그로 배열 만들기</h4>
<c:set var="colors">
red,yellow,green,blue,magenta
</c:set>
colors : ${colors } <br>
<hr>
<h4>c:remove 태그 : 변수 삭제하는 태그</h4>
<c:remove var="result" scope="session" />
<hr>
<h4>c:out 태그 : 출력하기 태그</h4>
그대로 출력 : 
<c:out value="<h2>태그로 출력하기</h2>" escapeXml="true" />
<br>
태그 해석해서 출력 : 
<c:out value="<h2>태그로 출력하기</h2>" escapeXml="false" />
<br>
전송 온 값 출력 : 
<c:out value="${param.name }" default="손님" /> <br>
<!-- param.name == request.getParameter("name") -->
<hr>
<h4>c:if 태그 : if 문과 같음</h4>
<c:if test="${num1 > num2 }">
num1 이 크다. <br>
</c:if>
<c:if test="${num1 <= num2 }">
num2 가 크거나 같다. <br>
</c:if>
<hr>
<h4>c:choose 태그 : switch 문과 같은 일을 하는 태그</h4>
<c:set var="no" value="3" />
<c:choose>
<c:when test="${no eq 1 }">반갑습니다.<br></c:when>
<c:when test="${no eq 2 }">환영합니다.<br></c:when>
<c:otherwise>안녕하세요.<br></c:otherwise>
</c:choose>
<hr>
<h4>c:forEach 태그 : for 문과 for each 문과 같은 태그임</h4>
<c:forEach begin="1" end="10">
반복 확인<br>
</c:forEach>
<hr>
<c:forEach var="count" begin="1" end="10" step="2">
${count } <br>
</c:forEach>
<hr>
<h4>반복 카운트용 변수를 html 태그의 값으로 적용 가능함</h4>
<c:forEach var="size" begin="1" end="7">
<font size="${size }">글자크기 ${size }</font> <br>
</c:forEach>
<hr>
<c:forEach items="${ colors }" var="color">
<font color="${color }">글자색 적용 : ${color }</font> <br>
</c:forEach>
<hr>
<%
	java.util.ArrayList<String> list = 
		new java.util.ArrayList<String>();
	list.add("java");
	list.add("oracle");
	list.add("html5");
	list.add("css3");
	list.add("servlet");
	list.add("jsp");
%>
<c:forEach items="<%= list %>" var="category" varStatus="status">
${status.count } : ${category } <br>
</c:forEach>
<hr>
<h4>c:forTokens 태그 : java.util.StringTokenizer 클래스와 
같은 기능을 수행하는 태그임</h4>
<ul>
<c:forTokens items="yellow,pink,blue,cyan,red" delims="," 
var="clr">
	<li>${clr }</li>
</c:forTokens>
</ul>
<hr>
<c:forTokens items="core/fmt*sql xml-functions" 
delims="/* -" var="item">
${item } <br>
</c:forTokens>
<hr>
<h4>c:url 태그 : 다른 jsp 페이지나 서블릿을 연결 처리할 때 사용하는 태그임.</h4>
<!-- <a href="testFmt.jsp?no=123">testFmt 페이지로 이동</a><br> -->
<c:url var="movetf" value="testFmt.jsp">
	<c:param name="no" value="123"/>
</c:url>
<a href="${movetf }">testFmt로 이동</a><br>
<hr>
<h4>c:import 태그 : jsp include 지시자 또는 표준액션태그인 jsp:include와 같은 기능을 수행하는 태그임</h4>
<c:import url="testImport.jsp"/>
<hr>
<h4>c:catch 태그 : try catch 문과 기능이 같은 태그임.</h4>
<c:catch var="e">
	<c:set var="num" value="null"/>
	<c:set var="num3" value="77"/>
	나눈 결과 : ${num3 / num } <br>
</c:catch>
<c:if test="${e != null }">
에러메세지 : ${e.message }<br>
</c:if>
<hr>
<h4>e:redirect 태그 : response.sendRedirect()와 같음</h4>
<c:set var="test" value="0"/>
<c:if test="${test eq 1 }"><!-- test가 1이면 testFunctions.jsp로 바뀜  --> 
	<c:redirect url="testFunctions.jsp"/>
</c:if>




<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>





