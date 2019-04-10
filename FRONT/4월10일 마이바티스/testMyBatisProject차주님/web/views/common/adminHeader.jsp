<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
header nav ul { list-style: none; } 
header nav ul li {
	float: left;
	margin-right: 5px;
	background: black;
}
header nav ul li a {
	display: block;
	text-align: center;
	padding-top: 5px;
	padding-bottom: 0;
	width: 120px;
	height: 35px;
	color: white;
	font-weight: bold;
}
header nav ul li a:hover {
	background: red;
	text-shadow: 1px 1px 2px white;
	box-shadow: 2px 2px 4px gray;
}

</style>
</head>
<body>
<header>
<nav>
<ul>
	<li><a href="/testm/index.jsp">home</a></li>
	<li><a href="/testm/mall">회원관리</a></li>
	<li><a href="">공지사항관리</a></li>
	<li><a href="">게시글관리</a></li>
	<li><a href="">메뉴</a></li>
</ul>
</nav>
</header>
</body>
</html>