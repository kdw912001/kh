<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/doggybeta/resources/css/footer.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="..//common/menu.jsp" %>
	<div id="wrap">
		<div id="content">
			<!-- 내용작성  -->
			<table align="center" width=600; border=1px;>
				<tr>
					<th>서비스</th>
					<th>견종</th>
					<th>반려견크기</th>
					<th>반려견나이</th>
				</tr>
				<tr>
					<td>  
						<select>
						  <option value="volvo">Volvo</option>
						  <option value="saab">Saab</option>
						  <option value="opel">Opel</option>
						  <option value="audi">Audi</option>
						</select>
					</td>
					<td>
					<select>
						  <option value="volvo">Volvo</option>
						  <option value="saab">Saab</option>
						  <option value="opel">Opel</option>
						  <option value="audi">Audi</option>
					</select>
					</td>
					<td>
					<select>
						  <option value="volvo">Volvo</option>
						  <option value="saab">Saab</option>
						  <option value="opel">Opel</option>
						  <option value="audi">Audi</option>
					</select>
					</td>
					<td>
					<select>
						  <option value="volvo">Volvo</option>
						  <option value="saab">Saab</option>
						  <option value="opel">Opel</option>
						  <option value="audi">Audi</option>
					</select>
					</td>
					<td>
						<button></button>
					</td>
				</tr>
			</table>
		</div>
		<div id="footer"><%@ include file="..//common/footer.jsp"%></div>
	</div>
</body>
</html>