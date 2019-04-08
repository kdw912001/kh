<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dog House</title>
<link rel="shortcut icon" href="/doggybeta/resources/images/favicon.ico">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
</head>
<style type="text/css">
.board{
	
}
.title{
	width: 70px;
	padding: 7px 13px;
	border:1px solid #e9e9e9;
	border-left:0;
	background:#f5f8f9;
	text-align:left
}
</style>
<body>
<%@ include file="../common/menu.jsp"%>

<div class="main">

<h2 align="center"><%= notice.getNoticeNo() %>번 글 수정 페이지</h2>
</div>

<br>

<form action="/doggybeta/nupdate" method="post" 
	enctype="multipart/form-data">
<input type="hidden" name="no" value="<%= notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%= notice.getNoticeOriginFile() %>">
<input type="hidden" name="rfile" value="<%= notice.getNoticeReFile() %>">	
<table class="board" align="center"; width="1000">
<tr>
<th class="title">제목</th>
<td><input type="text" name="title" value="<%= notice.getNoticeTitle() %>size="60"></td>
</tr>
<tr>
<th class="title">작성자</th>
<td><input type="text" name="writer" value="adminmk" readonly></td>
</tr>
<tr>
<th class="title">첨부파일</th>
<td id="filetd">
	<% if(notice.getNoticeOriginFile() != null){ %>
	<%= notice.getNoticeReFile() %> 
	<%}else{ %>
		첨부파일 없음
	<% } %>
	&nbsp; 
	<input type="button" value="첨부파일 변경" onclick="return addFile();">
	
	<script type="text/javascript">
		function addFile(){
			var filetd = document.getElementById("filetd");
			var addHTML = "<input type='file' name='upfile'>";
			filetd.innerHTML = filetd.innerHTML + "<BR>" + addHTML;
			
			return false;
		}
	</script>
	</td>
</tr>
<tr>
<th class="title">내용</th>
<td><textarea rows="5" cols="50" name="content"><%= notice.getNoticeContent() %></textarea></td>
</tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<a href="javascript:history.go(-1);">이전페이지로</a> &nbsp; 
</th></tr>
</table>
</form>

<%@ include file="../common/footer.jsp"%>
</body>
</html>