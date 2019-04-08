<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice, java.util.*" %>
<%
   ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
   

%>  
<html>
<head>
<title>Dog House</title>
<link rel="shortcut icon" href="/doggybeta/resources/images/favicon.ico">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function showWriteForm(){
   location.href="/doggybeta/views/notice/noticeWriteForm.jsp"
}

$(function(){
	showDiv();
	
	$("input[name=item]").on("change", function(){
		showDiv();
	});
});

function showDiv(){
	if($("input[name=item]").eq(0).is(":checked")){
		$("#titleDiv").css("display", "block");
		$("#dateDiv").css("display", "none");
		
	}
	if($("input[name=item]").eq(1).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#dateDiv").css("display", "block");
	}

}
</script>
</head>
<style type="text/css">

/* 화면에 보여지는 글 목록 테이블 */
.main{
   position: relative;
   top: 20px;
   left : 200px;
   width: 70%
}
.board { 
   position: relative;
   left : 250px;
   top: 100px;
   width: 60%;
   border-collapse: collapse;
   text-align: left;
   line-height: 1.5;
   table-layout:fixed; 
   
}

.button{
   position: relative;
   left : 200px;
   top: 50px;
  
}

/* list_table 에서 사용되는 thead */
.board thead th{ 
	padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;}

/* list_table 에서 사용되는 tbody */
.board tbody td { 
	width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    
}

.board tbody tr:hover{
	background-color : #f3f6f7;
}
center{
	position: absolute;
	top: 130px;
	left: 250px;
	
	
}
/* 글쓰기 버튼 아래로 위치 시킨 다음에 글이 늘어나도 버튼과 겹치지 않게  */
#insert{
	position: absolute;
	top: 10px;
	left: 500px;
}
</style>
<body>
<%@ include file="../common/menu.jsp"%>
<div class="main">
<h2 align="center">공지사항 게시판</h2>
</div>

<%-- 검색기능 --%>
<center>
<div class="search">
	<input type="radio" name="item" value="title" checked> 제목
	&nbsp; &nbsp; &nbsp;
	<input type="radio" name="item" value="date"> 날짜	
</div>
<div id="titleDiv">
	<form action="/doggybeta/nsearch" method="post">
	<input type="hidden" name="search" value="title">
	<label style="background-color : ">검색할 제목을 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="/doggybeta/nsearch" method="post">
	<input type="hidden" name="search" value="date">
	<label>검색할 날짜를 를 선택하시오 :
	<input type="date" name="begin"> ~ 
	<input type="date" name="end"></label>
	<input type="submit" value="검색">
	</form>
</div>
</center>
<br>
<!-- 테이블 시작 -->
   <table class="board">
      <thead>
         <tr>
            <th width="50">번호</th>
            <th width="200">제목</th>
            <th width="100">작성자</th>
            <th width="130">작성일</th>
            <th width="70">조회수</th>
            
         </tr>   
      </thead>
      <tbody>      
       <%   for(Notice notice : list){ %>
   <tr>
   <td class="row" ><%= notice.getNoticeNo() %></td>
   <td class="row" ><a href="/doggybeta/ndetail?no=<%= notice.getNoticeNo()%>"><%= notice.getNoticeTitle() %></a></td>
   <td class="row" ><%= notice.getManagerId() %></td>
   <td class="row" ><%= notice.getNoticeDate() %></td>
   <td class="row" ><%= notice.getNoticeViews() %></td>

   </td>
   </tr>   
   <% } %>     
   </tbody>   
</table>
<br>         
<!-- 테이블 종료 -->
<div id="insert">
	<input type="button" onclick="showWriteForm();" value="글쓰기">
</div>


<%@ include file="../common/footer.jsp"%>
</body>
</html>