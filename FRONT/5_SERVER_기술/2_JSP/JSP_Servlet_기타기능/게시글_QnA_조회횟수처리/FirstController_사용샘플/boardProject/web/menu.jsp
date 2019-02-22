<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 탭메뉴 </title>
  <style type="text/css">
	#menu {
		width: 960px;
		height: 40px;
		clear: both;
	}

	ul.navi {
		float: left;
		width: 960px;
		margin: 0;
		padding: 0;
		list-style: none;
		background: #39F;
		-moz-border-radius-topright: 10px;
		-webkit-border-top-right-radius: 10px;
		-moz-border-radius-topleft: 10px;
		-webkit-border-top-left-radius: 10px;
	}

	ul.navi li {
		display: inline;
	}

	ul.navi li a {
		float: left;
		font: bold 14px 굴림;
		line-height: 40px;
		color: #fff;
		text-decoration: none;
		text-shadow: 1px 1px 1px #880000;
		margin: 0;
		padding: 0 30px;
		background: #39F;
		-moz-border-radius-topright: 10px;
		-webkit-border-top-right-radius: 10px;
		-moz-border-radius-topleft: 10px;
		-webkit-border-top-left-radius: 10px;
	}

	ul.navi .current a, ul.navi li:hover > a { 
		color: #fff;
		text-decoration: none; 
		text-shadow: 1px 1px 1px #330000; 
		background: #36F; 
		-moz-border-radius-topright: 10px; 
		-webkit-border-top-right-radius: 10px;
		-moz-border-radius-topleft: 10px;
		-webkit-border-top-left-radius: 10px; 
	}
	
	ul.navi ul { display: none; }
	
	ul.navi li:hover > ul {
		position: absolute; 
		display: block; 
		width: 920px; 
		height: 45px; 
		margin: 40px 0 0 0; 
		background: #33F; 
		-moz-border-radius-bottomright: 10px;
		-webkit-border-bottom-right-radius: 10px;
		-moz-border-radius-bottomleft: 10px;
		-webkit-border-bottom-left-radius: 10px; 
	}

	ul.navi li:hover > ul li a {
		float: left;
		font: bold 14px 굴림;
		line-height: 45px;
		color: #fff;
		text-decoration: none;
		text-shadow: 1px 1px 1px #110000;
		margin: 0;
		padding: 0 30px 0 0;
		background: #33F;
	}

	ul.navi li:hover > ul li a:hover {
		color: #ff0000;
		text-decoration: none;
		text-shadow: none;
	}

  </style>
 </head>

 <body>
  <h2>Mini Web Project</h2>
  <hr/>

	<div id="menu">
		<ul class="navi">
			<li><a href="/board/index.jsp"> Home </a></li>
			<li><a href="#"> 쇼핑</a>
				<ul>
					<li><a href="#"> 핸드폰</a></li>
					<li><a href="#"> 악세사리</a></li>
					<li><a href="#"> 신발</a></li>
					<li><a href="#"> 가전제품</a></li>
				</ul>
			</li>
			<li><a href="#"> 게시판</a>
				<ul>
					<li><a href="#"> 답글게시판 </a></li>
					<li><a href="#"> 공지사항</a></li>
					<li><a href="#"> 사진게시판</a></li>
					<li><a href="#"> 방명록</a></li>
				</ul>
			</li>
			<li><a href="#"> 회원서비스</a></li>
		</ul>
	</div>
 </body>
</html>
