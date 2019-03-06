<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
function moveWritePage(){
	//글쓰기 버튼을 클릭하면, noticeWriteForm.jsp 파일로 이동함
	location.href="/first/views/notice/noticeWriteForm.jsp";
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







