<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="faq.model.vo.Faq, java.util.*" %>
<%
   ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	
	String search = null, keyword = null;

	if(request.getAttribute("search") != null){
		search = request.getAttribute("search").toString();	
		keyword = request.getAttribute("keyword").toString();
	}

%>  
<html>
<head>
<title>Dog House</title>
<link rel="shortcut icon" href="/doggybeta/resources/images/favicon.ico">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script type="text/javascript">
function showWriteForm(){
   location.href="/doggybeta/views/faq/faqWriteForm.jsp"
}
$(function(){
	$(".plusIcon").on("click",function(){
		  var obj = $(this);
		  if( obj.hasClass("glyphicon-plus") ){
		    obj.hide();
		    obj.next().show();            
		    obj.parent().parent().next().show();
		  }else{
		     obj.hide();
		     obj.prev().show();
		     obj.parent().parent().next().hide();
		  }
		});
});

</script>
</head>
<style type="text/css">

.main{
   position: relative;
   top: 20px;
   left : 200px;
   width: 70%
}
.board { 
   position: relative;
   left : 250px;
   top : 100px;
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
	top: 150px;
	left: 250px;
	
	
}
#insert{
	position: absolute;
	top: 10px;
	left: 500px;
}

</style>
<body>
<%@ include file="../common/menu.jsp"%>
<div class="main">
<h2 align="center">FAQ</h2>
</div>

<%-- 검색기능 --%>
<center>
<div id="titleDiv">
	<form action="/doggybeta/faqsearch" method="post">
	<input type="hidden" name="search" value="title">
	<label style="background-color : ">검색할 제목을 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
</center>
<br>
<!-- 테이블 시작 -->
   <table class="board">
      <thead>
         <tr>
            <th width="50">구분</th>
            <th width="200">제목</th>
         </tr>   
      </thead>
      <tbody>
   <% for(Faq faq : list){ %>      
   <tr>
   <td><%= faq.getFaqType()%></td>
   <td>
   <span class="glyphicon glyphicon-plus plusIcon"></span>
   <span class="glyphicon glyphicon-minus plusIcon" style="display:none"></span><%= faq.getFaqTitle() %></td>
   </tr>
   <tr style="display:none" >
   <td colspan="2" align="left" style="word-break:break-all;">
   <%= faq.getFaqContent() %>
   <br>
   <br>
   <br>
   <button onclick="location.href='/doggybeta/faqupview?fnum=<%= faq.getFaqNo()%>&page=<%= currentPage%>'">수정</button>
   &nbsp;
   <button onclick="location.href='/doggybeta/faqdel?fnum=<%= faq.getFaqNo()%>'">삭제</button>
   </td>
   </tr>    
      
   </tbody>   
   <% } %>
</table>
<br>    
   
<!-- 테이블 종료 -->
<div id="insert">
	<input type="button" onclick="showWriteForm();" value="글쓰기">
</div>
<%-- 페이징 처리 --%>
<br><br><br>
<div style="text-align:center;">
<% if(currentPage <= 1){ %>
	[맨처음]&nbsp;
<% }else{ %>
	<a href="/doggybeta/faqlist?page=1">[맨처음]</a>&nbsp;
<% } %>
<% if((currentPage - 10) < startPage && (currentPage - 10) > 1){ %>
	<a href="/doggybeta/faqlist?page=<%= startPage - 10 %>">[prev]</a>
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
		<a href="/doggybeta/fsearchtkeyword=<%= keyword %>&page=<%= p %>"><%= p %></a>		
		<%}%>
	<a href="/doggybeta/faqlist?page=<%= p %>"><%= p %></a>
<% }} %>&nbsp;
<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){ %>
	<a href="/doggybeta/faqlist?page=<%= endPage + 10 %>">[next]</a>&nbsp;
<% }else{ %>
	[next]&nbsp;
<% } %>
<% if(currentPage >= maxPage){ %>
	[맨끝]
<% }else{ %>
	<a href="/doggybeta/faqlist?page=<%= maxPage %>">[맨끝]</a>
<% } %>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>