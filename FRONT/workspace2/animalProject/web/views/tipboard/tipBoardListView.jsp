<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.model.vo.Member, tipboard.model.vo.TipBoard, java.util.ArrayList"%>
<%
	ArrayList<TipBoard> list = (ArrayList<TipBoard>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();

	String search = null, keyword = null;
	java.sql.Date begin = null, end = null;

	if (request.getAttribute("search") != null) {
		search = request.getAttribute("search").toString();

		if (search.equals("date")) {
			begin = (java.sql.Date) request.getAttribute("begin");
			end = (java.sql.Date) request.getAttribute("end");
		} else {
			keyword = request.getAttribute("keyword").toString();
		}
	}

	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<link href="/doggybeta/resources/css/footer.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="/first/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function showWriteForm() {
		location.href = "/doggybeta/views/tipboard/tipBoardWriteForm.jsp";
	}

	$(function() {
		showDiv();

		$("input[name=item]").on("change", function() {
			showDiv();
		});
	});

	function showDiv() {
		if ($("input[name=item]").eq(0).is(":checked")) {
			$("#titleDiv").css("display", "block");
			$("#writerDiv").css("display", "none");
			$("#dateDiv").css("display", "none");
		}

		if ($("input[name=item]").eq(1).is(":checked")) {
			$("#titleDiv").css("display", "none");
			$("#writerDiv").css("display", "block");
			$("#dateDiv").css("display", "none");
		}

		if ($("input[name=item]").eq(2).is(":checked")) {
			$("#titleDiv").css("display", "none");
			$("#writerDiv").css("display", "none");
			$("#dateDiv").css("display", "block");
		}
	}
</script>
</head>
<body>
	<%@ include file="..//common/menu.jsp"%>
	<div id="wrap">
		<div id="content">
			<!-- 내용작성  -->

			<h2 align="center">게시글 목록</h2>
			<h4 align="center">
				총 게시글 갯수 :
				<%=listCount%></h4>
			<%
				if (loginUser != null) {
			%>
			<div style="align: center; text-align: center;">
				<button onclick="showWriteForm();">글쓰기</button>
			</div>
			<%
				}
			%>
			<br>
			<%-- 검색기능 --%>
			<center>
				<div>
					<h2>검색할 항목을 선택하시오.</h2>
					<input type="radio" name="item" value="title" checked> 제목
					&nbsp; &nbsp; &nbsp; <input type="radio" name="item" value="writer">
					작성자 &nbsp; &nbsp; &nbsp; <input type="radio" name="item"
						value="date"> 날짜
				</div>
				<div id="titleDiv">
					<form action="/first/tsearcht" method="post">
						<label>검색할 제목을 입력하시오 : <input type="text" name="keyword"></label>
						<input type="submit" value="검색">
					</form>
				</div>
				<div id="writerDiv">
					<form action="/doggybeta/tsearchw" method="post">
						<label>검색할 작성자 아이디를 입력하시오 : <input type="text"
							name="keyword"></label> <input type="submit" value="검색">
					</form>
				</div>
				<div id="dateDiv">
					<form action="/doggybeta/tsearchd" method="post">
						<label>검색할 날짜를 선택하시오 : <input type="date" name="begin">
							~ <input type="date" name="end"></label> <input type="submit"
							value="검색">
					</form>
				</div>
			</center>
			<br>
			<table align="center" border="1" cellspacing="0" width="700">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
					<th>첨부파일</th>
				</tr>
				<%
					for (TipBoard t : list) {
				%>
				<tr>
					<td align="center"><%=t.getTipBoardNo()%></td>
					<td>
						<%-- 로그인 상태일 때만 상세보기 링크 설정함 --%> <%-- <% if(loginUser != null){ %>
		<a href="/first/tdetail?tnum=<%= t.getTipBoardNo() %>&tpage=<%= currentPage %>"><%= b.getBoardTitle() %></a>
	<% }else{ %>
		<%= t.getTipBoardTitle() %>
	<% } %> --%> <%=t.getTipBoardTitle()%>
					</td>
					<td align="center"><%=t.getTipBoardTitle()%></td>
					<td align="center"><%=t.getTipBoardDate()%></td>
					<td align="center"><%=t.getTipBoardViews()%></td>
					<td align="center">
						<%
							if (t.getTipBoardOriginFile() != null) {
						%> ◎ <%
							} else {
						%> &nbsp; <%
 	}
 %>
					</td>
				</tr>
				<%
					} //for each
				%>
			</table>
			<br>
			<%-- 페이징 처리 --%>
			<div style="text-align: center;">
				<%
					if (currentPage <= 1) {
				%>
				[맨처음]&nbsp;
				<%
					} else {
				%>
				<a href="/doggybeta/tlist?tpage=1">[맨처음]</a>&nbsp;
				<%
					}
				%>
				<%
					if ((currentPage - 10) < startPage && (currentPage - 10) > 1) {
				%>
				<a href="/doggybeta/tlist?tpage=<%=startPage - 10%>">[prev]</a>
				<%
					} else {
				%>
				[prev]
				<%
					}
				%>
				현재 페이지가 포함된 페이지 그룹 숫자 출력 처리
				<%
					for (int p = startPage; p <= endPage; p++) {
						if (p == currentPage) {
				%>
				<font color="red" size="4"><b>[<%=p%>]
				</b></font>
				<%
					} else {
							if (search != null && search.equals("title")) {
				%>
				<a href="/doggybeta/tsearcht?keyword=<%=keyword%>&page=<%=p%>"><%=p%></a>
				<%
					} else if (search != null && search.equals("writer")) {
				%>
				<a href="/doggybeta/tsearchw?keyword=<%=keyword%>&page=<%=p%>"><%=p%></a>
				<%
					} else if (search != null && search.equals("date")) {
				%>
				<a
					href="/doggybeta/tsearchd?begin=<%=begin%>&end=<%=end%>&page=<%=p%>"><%=p%></a>
				<%
					} else {
				%>
				<a href="/doggybeta/tlist?page=<%=p%>"><%=p%></a>
				<%
					}
						}
					}
				%>&nbsp;
				<%
					if ((currentPage + 10) > endPage && (currentPage + 10) < maxPage) {
				%>
				<a href="/doggybeta/tlist?page=<%=endPage + 10%>">[next]</a>&nbsp;
				<%
					} else {
				%>
				[next]&nbsp;
				<%
					}
				%>
				<%
					if (currentPage >= maxPage) {
				%>
				[맨끝]
				<%
					} else {
				%>
				<a href="/doggybeta/tlist?page=<%=maxPage%>">[맨끝]</a>
				<%
					}
				%>

			</div>
			<div id="footer"><%@ include file="..//common/footer.jsp"%></div>
		</div>
</body>
</html>







