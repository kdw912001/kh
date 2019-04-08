<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "member.model.vo.Member, board.model.vo.Board, java.util.ArrayList"%>
 <%
 		ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
 		//getParameter = 뷰에서 서블릿 요청/getAttribute 포워드 요청 차이
 		int listCount = ((Integer)request.getAttribute("listCount")).intValue();
 		int startPage = ((Integer)request.getAttribute("startPage")).intValue();
 		int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
 		int endPage = ((Integer)request.getAttribute("endPage")).intValue();
 		int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
 		
 		Member loginUser = (Member)session.getAttribute("loginUser");
 		
 		
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script>
function showWriteForm(){
	location.href = "/first/views/board/boardWriteForm.jsp";
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h2 align ="center" >게시글 목록</h2>
<h4 align ="center">총 게시글 갯수 : <%=listCount %></h4>
<% if(loginUser != null){ %>
	<div style="align:center ; text-align: center";>
	<button onclick="showWriteForm()">글쓰기</button>
	</div>
<% } %>
<br>
<table align="center" border="1" cellspacing="0" width="700">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th>
<th>조회수</th><th>첨부파일</th></tr>
<% for(Board b : list){ %>
<tr><td align="center"><%= b.getBoardNum() %></td>
		<td>
		<%-- 댓글일 때는 제목을 들여쓰기함 --%>
		<% if(b.getBoardReplyLev() == 1){ //원글의 댓글일 때  %>
				&nbsp; &nbsp; ▶
		<% }else if(b.getBoardReplyLev() == 2){ //댓글의 댓글일 때 %>
				&nbsp; &nbsp;  &nbsp; &nbsp; ▶▶			
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
		<td align="center"><%= b.getBoardReadcount() %></td>
		<td align="center">
		<% if(b.getBoardOriginalFilename() != null){ %>
				♬
		<%}else{ %>
		        ♪
		<%} %>
		</td>
</tr>
<% } %>
</table>
<br>
<%--페이징 처리--%>
<div style="text-align:center;">
      <%if(currentPage <= 1) { %>
		[맨처음]&nbsp;
		<% }else { %>
		<a href="/first/blist?page=1">[맨처음]</a>&nbsp;
	<% } %>
	<%if((currentPage - 10) < startPage && (currentPage - 10) > 1){ %>
	<a href="/first/blist?page=<%= startPage - 10 %>">[prev]</a>
	<% }else{ %>
		[prev]
	<% } %>
	<%-- 현재 페이지가 포함된 페이지 그룹 숫자 출력 처리 --%>
	<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
	  %>				
	  	<font color="red" size="4"><b>[<%= p %>]</b></font>
	  	<% }else{ %>
	  	<a href="/first/blist?page=<%= p %>"><%= p %></a>
	<% }} %> &nbsp;
	
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