<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='member.model.vo.Member' %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src='/doggybeta/resources/js/loginSource.js'></script> -->
<link href='/doggybeta/resources/css/login.css' rel='stylesheet' type='text/css'>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="/doggybeta/resources/css/mainV2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	 $(function() {
 		$('.login-form').hide();
		 
		$('.btn').click(function() {
			$('body').append('<div id="mask"></div>');
		    $('#mask').fadeIn(300);
		    $('.login-form').fadeIn(300);
			$('.login-form').show();
			
		    $('#mask').click(function() {
		    	$('#mask, .login-form').fadeOut(300);
		    });
		    
		});
		
		$('#btnLogin').click(function(){
			var userid = $('#userid').val();
			var passwd = $('#passwd').val();
			
			if(userid == "") {
				$('#userid').focus();
				return;
			}
			/* var exp = '/[a-z0-9]$/';
			if(!exp.test(userid)) {
				$('#userid').focus();
				return;
			} */
			
			if(passwd == "") {
				$('#passwd').focus();
				return;
			}
			
			var data = "userid="+userid+"&passwd="+passwd;
			alert(userid+passwd);
			
			$.ajax({
				type: 'post',
				data: {userid : $('#userid').val(), passwd : $('#passwd').val() },
				url: '/doggybeta/jipsalogin',
				success: function(value) {
					alert('사용할 수 있는 아이디입니다.');
				}//success
			});//ajax
		})//login btn
	});
	

</script>
<style>

</style>
</head>
<body>
	<% if(loginUser == null) { %>
	<input type='checkbox' id='menu_state' checked />
	<div id='mask'> </div>
	<nav>
		<ul class='doghouse'>
			<li><a><span>doghouse</span></a></li>
		</ul>
		<span class='btn btn-1 btn-sign'>회원가입/로그인</span>
		<!-- ---------------------------------------------------------------------------- -->
<!-- 		<a href="#" class="login-forgot-pass">forgot password?</a>
		<div class="underlay-photo"></div>
		<div class="underlay-black"></div>  -->
		<!-- -------------------------------------------------------------------------  -->
		<ul class='icon' id='icon'>
			<!-- <li><img id='logo' src='/doggybeta/resources/images/doglogo.png'
				width='80%' /><a><span>doghouse</span> </a></li> -->

			<li><a href='/doggybeta' id='icon1'> <span>&nbsp;&nbsp;&nbsp;홈</span>
			</a></li>
			<li class="m1"><a
				href="/doggybeta/views/aboutus/companyintroduce.jsp" id='icon2'><span>&nbsp;&nbsp;&nbsp;About
						us</span></a>
				<ul class="m2">
					<li><a href="/doggybeta/views/aboutus/companyIntroduce.jsp">회사소개</a></li>
					<li><a>연혁</a></li>
					<li><a href="/doggybeta/views/aboutus/teamIntroduce.jsp">팀
							도그집사</a></li>
					<li><a href="/doggybeta/views/aboutus/location.jsp">오시는 길</a></li>
				</ul></li>
			<li><a href='#' id='icon3'> <span>&nbsp;&nbsp;&nbsp;펫시터	찾기</span></a> </li>
			<li class="m1"><a href='#'  id='icon4'> <span>&nbsp;&nbsp;&nbsp;게시판</span>
			</a>
				<ul class="m2">
					<li><a href='/doggybeta/nlist'>공지사항</a></li>
					<li><a href='#'>자유게시판</a></li>
					<li><a href='/doggybeta/tlist'>팁</a></li>
				</ul></li>
			<li class="m1"><a href="/doggybeta/faqlist" id='icon5'> <span>&nbsp;&nbsp;&nbsp;고객센터</span></a>
				<ul class="m2">
					<li><a href='/doggybeta/faqlist'>FAQ</a></li>
					<li><a href='#'>이용방법</a></li>
					<li><a href='#'>1:1문의</a></li>
				</ul></li>

			<li class="m1"><a href="#" id='icon6'><span>&nbsp;&nbsp;&nbsp;마이페이지</span></a>
				<ul class="m2">
					<li><a href='#'>정보수정</a></li>
					<li><a href='#'>이용내역/예약확인</a></li>
					<li><a href='#'>펫시터신청</a></li>
					<li><a href='#'>사전문의확인</a></li>
				</ul></li>

		</ul>
	</nav>
	<!-- ------------------------------------------------- -->
	<form class="login-form" method='post' action='/doggybeta/jipsalogin'>
  			<p class="login-text">
    			<span class="fa-stack fa-lg">
      				<i class="fa fa-circle fa-stack-2x"></i>
      				<i class="fa fa-lock fa-stack-1x"></i>
    			</span>
  			</p>
  			<input type="text" name='userid' id='userid' class="login-username" autofocus required placeholder="Email" />
  			<input type="password" name='userpwd' id='passwd' class="login-password" required required placeholder="Password" />
  			<a href='/doggybeta/jipsalogin'>
  			<input type="submit" name="Login" value="Login" class="login-submit" id='btnLogin'/></a>
			<a href='/doggybeta/views/member/enroll.html'>
			<input type="button" name='enroll' value='회원가입' class='login-submit' id='btnEnroll'/>
			</a>
  			
  			&nbsp;
  			<a href="/doggybeta/views/member/findPassword.jsp" class="login-forgot-pass" id='tempPwd'>forgot password?</a>
	</form>
	<script type="text/javascript">
	$('.m1').hover(function() {
		if ($(this).children('.m2').is(':visible')) {
			$(this).children('.m2').slideUp(800);
		} else {
			$(this).children('.m2').slideDown(800);
		}
	});
	</script>
		
	<% } else { %>
		<%-- <%= loginUser.getUserId() %> 님 환영합니다
		<a href='/doggybeta/jipsalogout'>로그아웃</a> --%>
		<input type='checkbox' id='menu_state' checked />
	<nav>
		<ul class='doghouse'>
			<li><a><span>doghouse</span></a></li>
		</ul>
		<a  href='/doggybeta/jipsalogout'><span class='btn btn-1 btn-sign'>로그아웃</span></a>
		<%= loginUser.getUserId() %>
		<!-- ---------------------------------------------------------------------------- -->
<!-- 		<a href="#" class="login-forgot-pass">forgot password?</a>
		<div class="underlay-photo"></div>
		<div class="underlay-black"></div>  -->
		<!-- -------------------------------------------------------------------------  -->
		<ul class='icon' id='icon'>
			<li><a href='/doggybeta' id='icon1'> <span>&nbsp;&nbsp;&nbsp;홈</span>
			</a></li>
			<li class="m1"><a
				href="/doggybeta/views/aboutus/companyintroduce.jsp" id='icon2'><span>&nbsp;&nbsp;&nbsp;About
						us</span></a>
				<ul class="m2">
					<li><a href="/doggybeta/views/aboutus/companyIntroduce.jsp">회사소개</a></li>
					<li><a>연혁</a></li>
					<li><a href="/doggybeta/views/aboutus/teamIntroduce.jsp">팀
							도그집사</a></li>
					<li><a href="/doggybeta/views/aboutus/location.jsp">오시는 길</a></li>
				</ul></li>
			<li><a href='#' id='icon3'> <span>&nbsp;&nbsp;&nbsp;펫시터	찾기</span></a> </li>
			<li class="m1"><a href='#'  id='icon4'> <span>&nbsp;&nbsp;&nbsp;게시판</span>
			</a>
				<ul class="m2">
					<li><a href='#'>공지사항</a></li>
					<li><a href='#'>자유게시판</a></li>
					<li><a href='#'>팁</a></li>
				</ul></li>
			<li class="m1"><a href="#" id='icon5'> <span>&nbsp;&nbsp;&nbsp;고객센터</span></a>
				<ul class="m2">
					<li><a href='#'>FAQ</a></li>
					<li><a href='#'>이용방법</a></li>
					<li><a href='#'>1:1문의</a></li>
				</ul></li>

			<li class="m1"><a href="#" id='icon6'><span>&nbsp;&nbsp;&nbsp;마이페이지</span></a>
				<ul class="m2">
					<li><a href='#'>정보수정</a></li>
					<li><a href='#'>이용내역/예약확인</a></li>
					<li><a href='#'>펫시터신청</a></li>
					<li><a href='#'>사전문의확인</a></li>
				</ul></li>
		</ul>
	
	</nav>
	<script type="text/javascript">
	$('.m1').hover(function() {
		if ($(this).children('.m2').is(':visible')) {
			$(this).children('.m2').slideUp(800);
		} else {
			$(this).children('.m2').slideDown(800);
		}
	});
	</script>
	<% } %>

</body>
<!-- <script src="/doggybeta/resources/js/loginSource.js"></script> -->
</html>