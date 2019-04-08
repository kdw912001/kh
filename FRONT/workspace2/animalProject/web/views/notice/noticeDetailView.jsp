<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice, java.util.*" %>
<%
  Notice notice = (Notice)request.getAttribute("notice");

%>  
<html>
<head>
<title>Dog House</title>
<link rel="shortcut icon" href="/doggybeta/resources/images/favicon.ico">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function moveUpdatePage(){
	location.href = "/doggybeta/nupview?no=" + <%= notice.getNoticeNo() %>;
}
function deleteNotice(){
	location.href = "/doggybeta/ndel?no=" + <%= notice.getNoticeNo()%>;
}
</script>
<style type="text/css">
table{
	position: relative;
	left: 300px;
	border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    margin: 20px 10px;
}
table th{
	background:#f3f6f7;
	width: 80px;
	padding: 7px 13px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
	
}
table td {   
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
.buttons{
	position: relative;
	left: 700px;
	
	
}
</style>
</head>
<body>
<%@ include file="../common/menu.jsp" %>

<br>
<h2 align="center"><%= notice.getNoticeNo() %> 번 공지글 상세보기</h2>
<br>
<table width="700px">
<tr>
	<th align="left" >제목</th>
	<td colspan="2" align="left"><%= notice.getNoticeTitle() %></td>
	<td></td>
</tr>
<tr>
	<th align="left">작성자</th>
	<td><%= notice.getManagerId() %></td>
	<th align="left">첨부파일</th>
	<td align="left">
	<% if(notice.getNoticeOriginFile() != null){ %>
		<a href="/doggybeta/nfdown?ofile=<%= notice.getNoticeOriginFile() %> &rfile=<%= notice.getNoticeReFile() %>"><%= notice.getNoticeOriginFile() %></a>
	<% }else{ %>
		첨부파일 없음
	<% } %> 
	
	</td>
</tr>
<tr>
	<td colspan="4" style="vertical-align: top;
    border-bottom: 1px solid #ccc width: 500px; height: 300px">	
    <%= notice.getNoticeContent() %>
	</td>
</tr>
</table>
<div class="buttons">
	<%-- <% if(loginUser.getUserId().equals(notice.getNoticeWriter())){%> --%>
		<button id="button1" onclick="moveUpdatePage();">수정페이지로 이동</button> &nbsp;
		<button id="button2" onclick="deleteNotice();">글 삭제</button> &nbsp;
	<%-- <% } %>  --%>
	<button id="button3" onclick="location.href='/doggybeta/nlist'; return false;">목록</button>
	</th>
</div>
<a><%@ include file="../common/footer.jsp" %></a>
</body>
</html>
</head>
<body>

</body>
</html>