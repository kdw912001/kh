<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ page import="notice.model.vo.*, java.util.*, member.model.vo.Member" %>    
<%
	HashMap<Integer, Notice> map = 
		(HashMap<Integer, Notice>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");

	/* Collection<Notice> values = map.values();
	ArrayList<Notice> list = new ArrayList<Notice>(values); */
	ArrayList<Notice> list = new ArrayList<Notice>(map.values());
	Collections.sort(list, new NoticeNoDescending());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function moveWritePage(){
	//글쓰기 버튼을 클릭하면, noticeWriteForm.jsp 파일로 이동함
	location.href="/first/views/notice/noticeWriteForm.jsp";
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
<h2 align="center">공지사항 목록 보기</h2>
<br>
<%-- 글쓰기 버튼은 로그인했을 때만 보여지게 함 --%>
<% //관리자일 때만 글쓰기 제공 처리
	/* if(loginUser != null 
		&& loginUser.getUserId().equals("admin")){ */ 
	if(loginUser != null){ %>
<center>
	<button onclick="moveWritePage();">글쓰기</button>
</center>
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
	<form action="/first/nsearch" method="post">
	<input type="hidden" name="search" value="title">
	<label>검색할 제목을 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="/first/nsearch" method="post">
	<input type="hidden" name="search" value="writer">
	<label>검색할 작성자 아이디를 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="/first/nsearch" method="post">
	<input type="hidden" name="search" value="date">
	<label>검색할 날짜를 선택하시오 : 
	<input type="date" name="begin"> ~ 
	<input type="date" name="end"></label>
	<input type="submit" value="검색">
	</form>
</div>
</center>
<br>
<%-- 공지 목록 출력 --%>
<table align="center" width="650" cellspacing="0" border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>날짜</th>
	<th>첨부파일</th>
</tr>
<% 
	for(Notice notice : list){
%>
<tr>
	<td align="center"><%= notice.getNoticeNo() %></td>
	<td>
	<% if(loginUser != null){ //로그인한 상태 %>
		<a href="/first/ndetail?no=<%= notice.getNoticeNo() %>"><%= notice.getNoticeTitle() %></a>
	<% }else{ %>
		<%= notice.getNoticeTitle() %>
	<% } %>
	</td>
	<td align="center"><%= notice.getNoticeWriter() %></td>
	<td align="center"><%= notice.getNoticeDate() %></td>
	<td align="center">
	<% if(notice.getOriginalFilePath() != null){ //첨부파일이 있다면 %>
		◎
	<% }else{  //첨부파일이 없다면 %>
		&nbsp;
	<% } %>
	</td>
</tr>
<%  } %>
</table>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>







