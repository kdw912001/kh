<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='member.model.vo.Member' %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/doggybeta/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$('#btnSend').click(function() {
			var userId = $('#userid').val();
			var useremail = $('#email').val();
			
			var data = "userid="+userId+"&email="+useremail;
			
			$.ajax({
				type: 'post',
				data: {userid : userId, email : useremail },
				url: '/doggybeta/jipsafindpwd',
				success: function(data) {
						alert(data);
				}//success
			});//ajax
		});//btn
	});
</script>
</head>
<body>
<h3>비밀번호 잊어버렸을 때 </h3>
<form action='/doggybeta/jipsafindpwd'>
아이디 : <input type='text' id='userid' name='userid'/>
이메일 : <input type='email' id='email' name='email'/>
<br>
<input type='submit' value='sending email' id='btnSend'/>

</form>
</body>
</html>