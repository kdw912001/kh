<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/second/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function showWriteForm(){
	location.href = "/second/views/board/boardWriteForm.jsp";
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
<c:import url="../common/header.jsp"/>
<%-- <%@ include file="../common/header.jsp" %> --%>
<hr style="clear:both;">
<h2 align="center">게시글 목록</h2>
<h4 align="center">총 게시글 갯수 : ${ listCount }</h4>
<c:if test="${!empty loginUser }">
	<div style="align:center; text-align:center;">
	<button onclick="showWriteForm();">글쓰기</button>
	</div>
</c:if>
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
	<form action="/second/bsearcht" method="post">	
	<label>검색할 제목을 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="/second/bsearchw" method="post">	
	<label>검색할 작성자 아이디를 입력하시오 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="/second/bsearchd" method="post">	
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
<c:forEach items="${list }" var="b">
<tr><td align="center">${b.boardNum }</td>
	<td>
	<%-- 댓글일 때는 제목을 들여쓰기함 --%>
	<c:if test="${b.boardReplyLev eq 1 }">
		&nbsp; &nbsp; ▶ 
	</c:if>
	<c:if test="${b.boardReplyLev eq 2 }">
		&nbsp; &nbsp; &nbsp; &nbsp; ▶▶ 
	</c:if>
	<%-- 로그인 상태일 때만 상세보기 링크 설정함 --%>
	<c:if test="${!empty loginUser }">
		<c:url var="detail" value="/bdetail">
		<c:param name="bnum" value="${b.boardNum }"/>
		<c:param name="page" value="${currentPage }"/>
		</c:url>
		<a href="${detail }">${b.boardTitle }</a>
		<%-- <a href="/second/bdetail?bnum=${b.boardNum }&page=${ currentPage }">${b.boardTitle }</a> --%>
	</c:if>
	<c:if test="${empty loginUser }">
		${b.boardTitle }
	</c:if>
	</td>
	<td align="center">${b.boardWriter }</td>
	<td align="center">${b.boardDate }</td>
	<td align="center">${b.boardReadCount }</td>
	<td align="center">
	<c:if test="${!empty b.boardOriginalFileName}">
			◎
	</c:if>
	<c:if test="${empty b.boardOriginalFileName}">
		&nbsp;
	</c:if>
	</td>
</tr>
</c:forEach>
</table>
<br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
<c:if test="${ currentPage le 1 }">
	[맨처음]&nbsp;
</c:if>
<c:if test="${ currentPage gt 1 }">
	<c:url var="blist1" value="/blist">
		<c:param name="page" value="1"></c:param>
	</c:url>
<!--<a href="/second/blist?page=1">[맨처음]</a>&nbsp; -->
	<a href="${blist1 }">[맨처음]</a>&nbsp;
</c:if>
<%-- <c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1)}"> --%>
<c:if test="${(currentPage - 10) < startPage && (currentPage - 10) > 1 }">
	<c:url var="blist2" value="/blist">
		<c:param name="page" value="${startPage - 10 }"></c:param>
	</c:url>
	<a href="${blist2 }">[prev]</a>
	<%-- <a href="/second/blist?page=${ startPage - 10 }">[prev]</a> --%>
</c:if>
<c:if test="${currentPage >1  }">
	[prev]
</c:if>
<%-- 현재 페이지가 포함된 페이지 그룹 숫자 출력 처리 --%>
<c:forEach var="p" begin="${ startPage }" end="${ endPage }"> 
	<c:if test="${ p eq currentPage }">
	<font color="red" size="4"><b>[${p }]</b></font>
	</c:if>
	<c:if test="${ p ne currentPage }">
		<c:if test="${ !empty search and search eq 'title' }">
		<c:url var="bsearcht" value="/bearcht">
			<c:param name="keyword" value="${keyword }"/>
			<c:param name="page" value="${p }"></c:param>
		</c:url>
		<a href="${bearcht }">${p }</a>
		<%-- <a href="/second/bsearcht?keyword=${ keyword }&page=${ p }">${ p }</a> --%>
		</c:if>
		<c:if test="${ !empty search and search eq 'writer' }">
		<c:url var="bsearchw" value="/bsearchw">
			<c:param name="keyword" value="${keyword }"/>
			<c:param name="page" value="${p }"></c:param>
		</c:url>
		<a href="${bearchw}">${p }</a>
		<%-- <a href="/second/bsearchw?keyword=${ keyword }&page=${ p }">${ p }</a> --%>
		</c:if>
		<c:if test="${ !empty search and search eq 'date' }">
		<c:url var="bsearchd" value="/bsearchd">
			<c:param name="begin" value="${begin }"/>
			<c:param name="end" value="${end }"/>
			<c:param name="page" value="${p }"></c:param>
		</c:url>
		<a href="${bsearchd }"></a>
		<%-- <a href="/second/bsearchd?begin=${ begin }&end=${ end }&page=${ p }">${ p }</a> --%>
		</c:if>
	<c:url var="blist2" value="/blist">
		<c:param name="page" value="${p }"></c:param>
	</c:url>
	<a href="${blist2 }">${p }</a>
	<%-- <a href="/second/blist?page=${ p }">${ p }</a> --%>
	</c:if>
</c:forEach>
<%-- <c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }"> --%>
<%-- <c:if test="${(currentPage + 10) > endPage && (currentPage + 10) < maxPage) }"> --%>
<c:if test="${(currentPage + 10) > endPage && (currentPage + 10) < maxPage }">
	<c:url var="blist3" value="/blist">
		<c:param name="page" value="${endPage + 10 }"/>
	</c:url>
	<a href="${blist3}">[next]</a>&nbsp;
	<%-- <a href="/second/blist?page=${ endPage + 10 }">[next]</a>&nbsp; --%>
</c:if>
<%-- <c:if test="${ (currentPage + 10) le endPage or (currentPage + 10) ge maxPage) }"> --%>
<c:if test="${(currentPage + 10) <= endPage || (currentPage + 10) < maxPage }">
	[next]&nbsp;
</c:if>
<c:if test="${ currentPage ge maxPage }">
	[맨끝]
</c:if>
<c:if test="${ currentPage lt maxPage }">
	<c:url var="blist4" value="/blist">
		<c:param name="page" value="${maxPage }"/>
	</c:url>
	<a href="${blist4 }">[맨끝]</a>
	<%-- <a href="/second/blist?page=${ maxPage }">[맨끝]</a> --%>
</c:if>
</div>
<hr>
<%-- <%@ include file="../common/footer.jsp" %> --%>
<c:import url="../common/footer.jsp"/>
</body>
</html>







