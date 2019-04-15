<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
function moveUpdatePage(){
	location.href = "/testm/nupview?no=${notice.noticeNo}";
}

function deleteNotice(){
	location.href = "/testm/ndel?no=${notice.noticeNo}";
}
</script>
</head>
<body>
<c:import url="../common/header.jsp" />
<hr style="clear:both;">
<br>
<h2 align="center">${ notice.noticeNo } 번 공지글 상세보기</h2>
<br>
<table align="center" width="600">
<tr>
	<th>제목</th>
	<td>${ notice.noticeTitle }</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${ notice.noticeWriter  }</td>
</tr>
<tr>
	<th>첨부파일</th>
	<td>
	<c:url var="nfdn" value="/testm/nfdown">
		<c:param name="ofile" value="${ notice.originalFilePath }" />
		<c:param name="rfile" value="${ notice.renameFilePath }" />
	</c:url>
	<c:if test="${!empty notice.originalFilePath }">
		<a href="${nfdn }">${ notice.originalFilePath }</a>
	</c:if>
	<c:if test="${empty notice.originalFilePath }">
		첨부파일 없음
	</c:if>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>${ notice.noticeContent  }</td>
</tr>
<tr>
	<th colspan="2">
	<c:if test="${ loginUser.userId eq notice.noticeWriter }">
		<button onclick="moveUpdatePage();">수정페이지로 이동</button> &nbsp; 
		<button onclick="deleteNotice();">글삭제</button> &nbsp;
	</c:if>
	<button onclick="location.href='/testm/nlist'; return false;">목록</button>
	</th>	
</tr>
</table>
<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>









