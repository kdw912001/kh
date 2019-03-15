<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>

<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//주기적으로 반복 실행되게 하려면 
		/*
			setInterval(function(){ $.ajax(); }, 시간);
			//시간은 1000 이 1초임
		*/
		setInterval(function(){
				 var timer = new Date();
	            var h = timer.getHours();
	            var m = timer.getMinutes();
	            var s = timer.getSeconds();
	            document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
	     },1000);
		setInterval(function(){
			var currentTime = new Date();
			var hour = currentTiem
		},1000);

		//게시글 조회수 많은 순으로 5개 조회 결과 출력 처리
		$.ajax({
			url: "/first/btop5",
			type: "get",
			dataType: "json",
			success: function(data){
				console.log("btop5 : " + data);
				
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var values = "";
				for(var i in json.list){
					<% if(loginUser != null){ %>
						values += "<tr><td>" + json.list[i].bnum
						+ "</td><td><a href='/first/bdetail?bnum=" +json.list[i].bnum+"&page=1'>" + decodeURIComponent(json.list[i].btitle).replace(/\+/gi," ")
						+ "</a></td><td>" + json.list[i].rcount
						+ "</td></tr>"
					<% }else{ %>
						values += "<tr><td>" + json.list[i].bnum
							+ "</td><td>" + decodeURIComponent(json.list[i].btitle).replace(/\+/gi," ")
							+ "</td><td>" + json.list[i].rcount
							+ "</td></tr>"
					<% }%>
				} //for in
				
				//테이블에 추가
				$("#toplist").html($("#toplist").html() + values);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
		
		//최근 등록된 공지글 5개 조회 출력 처리
		$.ajax({
			url: "/first/ntop5",
			type: "get",
			dataType: "json",
			success: function(data){
				console.log("success : " + data);
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				var values = "";
				for(var i in json.list){
					<% if(loginUser != null){ %>
						values += "<tr><td>" + json.list[i].no +
									"</td><td><a href='/first/ndetail?no=" + json.list[i].no + "'>" + decodeURIComponent(json.list[i].ntitle).replace(/\+/gi," ") +
									"</a></td><td>" + json.list[i].ndate + 
									"</td></tr>";
					<% }else{ %>
						values += "<tr><td>" + json.list[i].no +
								"</td><td>" + decodeURIComponent(json.list[i].ntitle).replace(/\+/gi," ") +
								"</td><td>" + json.list[i].ndate + 
								"</td></tr>";
					<% } %>
				} //for in
				$("#newnotice").html($("#newnotice").html() + values);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
	});
</script>
</head>
<body>
<h1>firstWebProject</h1>
<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<%@ include file="views/common/adminHeader.jsp" %>
<% }else{ %>
	<%@ include file="views/common/header.jsp" %>
<% } %>
<hr style="clear:left;">
<% if(loginUser == null){ //로그인 하지 않은 상태 %>
<div>
<form action="/first/login" method="post"><!-- /login이라는 가짜주소로 form태그의 정보를 전송 -->
<table>
<tr>
<th>아이디 : </th>
<td><input type="text" name="userid" required> </td>
</tr>
<tr>
<th>암호 : </th>
<td> <input type="password" name="userpwd" required> </td>
</tr> 
<tr>
	<th colspan="2">
		<input type="submit" value="로그인"> 
		&nbsp; &nbsp; 
		<a href="/first/views/member/enroll.html">회원가입</a>
	</th>
</tr>
<tr>
	<th colspan="2">
		<a href="">아이디찾기</a>
		&nbsp; &nbsp;
		<a href="">암호찾기</a>
	</th>
</tr>
</table>
</form>
<h1 id='clock'></h1>
</div>
<% } else{ //로그인 상태일 때%>
<div>
<table>
<tr>
<th><%= loginUser.getUserName() %> 님 </th>
<td><a href="/first/logout">로그아웃</a> </td>
</tr>

<tr>
	<th colspan="2">
		<a href="">쪽지</a>
		&nbsp; &nbsp;
		<a href="/first/myinfo?userid=<%= loginUser.getUserId() %>">내 정보보기</a>
	</th>
</tr>
</table>
</div>
<%} %>

<hr>
<section>
<div style="float:left; border: 1px solid; padding:5px; margin:5px;">
	<h4>인기 게시글</h4>
	<table id="toplist" border="1" cellspacing="0">
	<tr><th>번호</th><th width="200">제목</th><th>조회수</th></tr>
	</table>
</div>
<div style="float:left; border: 1px solid; padding:5px; margin:5px;">
	<h4>신규 공지글</h4>
	<table id="newnotice" border="1" cellspacing="0">
	<tr><th>번호</th><th width="200">제목</th><th>날짜</th></tr>
	</table> 
</div>
</section>
<hr style="clear:left">
<%@ include file="views/common/footer.jsp" %>
</body>
</html>