<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dog House</title>
<link rel="shortcut icon" href="/doggybeta/resources/images/favicon.ico">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function moveList(){
   location.href="/doggybeta/nlist"
}
</script>
</head>
<style type="text/css">
.board{
	position: relative;
   left : 300px;
   top: 50px;
   width:100%;
}
.main{
   position: relative;
   top: 20px;
   left : 100px;
}
.title{
	width: 70px;
	padding: 7px 13px;
	border:1px solid #e9e9e9;
	border-left:0;
	background:#f5f8f9;
	text-align:left
	
}
.button{
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  position: relative;
  left :350px;
  top: 100px;
}
</style>
<body>
<%@ include file="../common/menu.jsp"%>

<div class="main">

<h2 align="center">공지글 등록 페이지</h2>
</div>

<br>

<form action="/doggybeta/ninsert" method="post" 
	enctype="multipart/form-data">
	
<table class="board" align="center" width="1000">
<tr>
<th class="title">제목</th>
<td><input type="text" name="title" size="60"></td>
</tr>
<tr>
<th class="title">작성자</th>
<td><input type="text" name="writer" value="adminmk" readonly></td>
</tr>
<tr>
<th class="title">첨부파일</th>
<td><input type="file" name="upfile"></td>
</tr>
<tr>
<th class="title" height="200">내용</th>
<td><textarea rows="10" cols="60" name="content"></textarea></td>
</tr>
</table>
<div class="button">	
<input type="submit" value="등록하기"> &nbsp; 
<input type="button" onclick="moveList();" value="목록으로">
</div>
</form>

<%@ include file="../common/footer.jsp"%>
</body>
</html>