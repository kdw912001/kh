<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
</head>
<body>
<c:import url="../common/header.jsp" />
<hr style="clear:both;">
<h2 align="center">${ notice.noticeNo }번 공지글 수정페이지</h2>
<hr>
<form action="/testm/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${ notice.noticeNo }">
<input type="hidden" name="ofile" value="${ notice.originalFilePath }">
<input type="hidden" name="rfile" value="${ notice.renameFilePath }">
<table align="center" width="600">
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="${ notice.noticeTitle }"></td>
</tr>
<tr>
	<th>작성자</th>
	<td><input type="text" name="writer" value="${ notice.noticeWriter }" readonly></td>
</tr>
<tr>
	<th>첨부파일</th>
	<td id="filetd">
	<c:if test="${!empty notice.originalFilePath }">
		${ notice.originalFilePath }
	</c:if>
	<c:if test="${empty notice.originalFilePath }">
		첨부파일없음
	</c:if> &nbsp; 
	<input type="button" value="첨부파일 변경" onclick="return addFile();"></td>
	<script type="text/javascript">
		function addFile(){
			var filetd = document.getElementById("filetd");
			var addHTML = "<input type='file' name='upfile'>";
			filetd.innerHTML = filetd.innerHTML + "<BR>" + addHTML;
			
			return false;
		}
	</script>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="5" cols="50" name="content">${ notice.noticeContent }</textarea></td>
</tr>
<tr>
	<th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<button onclick="history.go(-1); return false;">이전 페이지로 이동</button>
	</th>	
</tr>
</table>
</form>



<hr>
<c:import url="../common/footer.jsp" />
</body>
</html>



