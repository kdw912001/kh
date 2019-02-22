<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>페이징</title>
<script type="text/javascript">
	function goPage(pageNo){
		document.listForm.pageNo.value = pageNo;
		document.listForm.submit();
		console.log("pageNo : " + pageNo);
	}

</script>

<style type="text/css">
	.selected {font-weight: bold;}
</style>

</head>
<body>
	나오나?<br/><br/>
	<form name="listForm" action="/paging.ok" method="post">
		<input type="text" name="pageNo" value="" /><br/><br/>
<!-- 		<table style="width: 100%;" class="table_02"> -->
<%-- 			<colgroup> --%>
<%-- 				<col width="" /> --%>
<%-- 				<col width="" /> --%>
<%-- 				<col width="" /> --%>
<%-- 				<col width="" /> --%>
<%-- 				<col width="" /> --%>
<%-- 			</colgroup> --%>
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<th>컬럼1</th> -->
<!-- 					<th>컬럼2</th> -->
<!-- 					<th>컬럼3</th> -->
<!-- 					<th>컬럼4</th> -->
<!-- 					<th>컬럼5</th> -->
<!-- 				</tr> -->
<!-- 			</thead> -->
<!-- 			<tbody> -->
<%-- 				<c:if test="${!empty dataList }"> --%>
<%-- 					<c:forEach var="data" items="${dataList }"> --%>
<!-- 						<tr> -->
<%-- 							<td>${data.column1 }</td> --%>
<%-- 							<td>${data.column2 }</td> --%>
<%-- 							<td>${data.column3 }</td> --%>
<%-- 							<td>${data.column4 }</td> --%>
<%-- 							<td>${data.column5 }</td> --%>
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<%-- 				</c:if> --%>
<!-- 			</tbody> -->
<!-- 		</table> -->
		
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
			<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
			<jsp:param name="startPageNo" value="${paging.startPageNo}" />
			<jsp:param name="pageNo" value="${paging.pageNo}" />
			<jsp:param name="endPageNo" value="${paging.endPageNo}" />
			<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
			<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
		</jsp:include>
	</form>
</body>
</html>