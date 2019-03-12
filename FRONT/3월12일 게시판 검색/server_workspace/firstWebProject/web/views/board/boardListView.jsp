<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, board.model.vo.Board, java.util.ArrayList" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	
	String search = null, keyword = null;
	java.sql.Date begin = null, end = null;
	
	if(request.getAttribute("search") != null){
		search = request.getAttribute("search").toString();	
		
		if(search.equals("date")){
			begin = (java.sql.Date)request.getAttribute("begin");
			end = (java.sql.Date)request.getAttribute("end");
		}else{
			keyword = request.getAttribute("keyword").toString();
		}
	}
	
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function showWriteForm(){
	location.href = "/first/views/board/boardWriteForm.jsp";
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
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(1).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "block");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(2).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "block");
	}
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h2 align="center">게시글 목록</h2>
<h4 align="center">총 게시글 갯수 : <%= listCount %></h4>
<% if(loginUser != null){ %>
	<div style="align:center; text-align:center;">
	<button onclick="showWriteForm();">글쓰기</button>
	</div>
<% } %>
<br>
<%-- 검색기능 --%>
<center>
<div>
	<h2>검색할 항목을 선택하시오.</h2>
	<input type="radio" name="item" value="title" checked> 제목 
	&nbsp; &nbsp; &nbsp; 
	<input type="radio" name="item" value="writer"> 작성자 
	&nbsp; &nbsp; &nbsp; 
	<input type="radio" name="item" value="date"> 날짜 
</div>
<div id="titleDiv">
	<form action="/first/bsearcht" method="post">	
	<label>검색할 제목을 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="/first/bsearchw" method="post">	
	<label>검색할 작성자 아이디를 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="/first/bsearchd" method="post">	
	<label>검색할 날짜를 선택하시오 : 
	<input type="date" name="begin"> ~ 
	<input type="date" name="end"></label>
	<input type="submit" value="검색">
	</form>
</div>
</center>
<br>
<table align="center" border="1" cellspacing="0" width="700">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th>
<th>조회수</th><th>첨부파일</th></tr>
<% for(Board b : list){ %>
<tr><td align="center"><%= b.getBoardNum() %></td>
	<td>
	<%-- 댓글일 때는 제목을 들여쓰기함 --%>
	<% if(b.getBoardReplyLev() == 1){ //원글의 댓글일 때 %>
		&nbsp; &nbsp; ▶ 
	<% }else if(b.getBoardReplyLev() == 2){ //댓글의 댓글일 때 %>
		&nbsp; &nbsp; &nbsp; &nbsp; ▶▶ 
	<% } %>
	<%-- 로그인 상태일 때만 상세보기 링크 설정함 --%>
	<% if(loginUser != null){ %>
		<a href="/first/bdetail?bnum=<%= b.getBoardNum() %>&page=<%= currentPage %>"><%= b.getBoardTitle() %></a>
	<% }else{ %>
		<%= b.getBoardTitle() %>
	<% } %>
	</td>
	<td align="center"><%= b.getBoardWriter() %></td>
	<td align="center"><%= b.getBoardDate() %></td>
	<td align="center"><%= b.getBoardReadCount() %></td>
	<td align="center">
	<% if(b.getBoardOriginalFileName() != null){ %>
		◎
	<% }else{ %>
		&nbsp;
	<% } %>
	</td>
</tr>
<% }  //for each %>
</table>
<br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
<% if(currentPage <= 1){ %>
	[맨처음]&nbsp;
<% }else{ %>
	<a href="/first/blist?page=1">[맨처음]</a>&nbsp;
<% } %>
<% if((currentPage - 10) < startPage && (currentPage - 10) > 1){ %>
	<a href="/first/blist?page=<%= startPage - 10 %>">[prev]</a>
<% }else{ %>
	[prev]
<% } %>
<%-- 현재 페이지가 포함된 페이지 그룹 숫자 출력 처리 --%>
<% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<font color="red" size="4"><b>[<%= p %>]</b></font>
	<% }else{ 
		if(search != null && search.equals("title")){%>
		<a href="/first/bsearcht?keyword=<%= keyword %>&page=<%= p %>"><%= p %></a>
		<%}else if(search != null && search.equals("writer")){ %>
		<a href="/first/bsearchw?keyword=<%= keyword %>&page=<%= p %>"><%= p %></a>
		<%}else if(search != null && search.equals("date")){ %>
		<a href="/first/bsearchd?begin=<%= begin %>&end=<%= end %>&page=<%= p %>"><%= p %></a>
		<%}else{ %>
	<a href="/first/blist?page=<%= p %>"><%= p %></a>
<% }}} %>&nbsp;
<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){ %>
	<a href="/first/blist?page=<%= endPage + 10 %>">[next]</a>&nbsp;
<% }else{ %>
	[next]&nbsp;
<% } %>
<% if(currentPage >= maxPage){ %>
	[맨끝]
<% }else{ %>
	<a href="/first/blist?page=<%= maxPage %>">[맨끝]</a>
<% } %>
</div>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>







