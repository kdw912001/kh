<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/testa/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>jQuery로 ajax 테스트</h1>
<hr>
<h2>1. 서버로 보내는 값 없고, 결과로 문자열 받아 출력 처리하는 방법 : get 방식</h2>
<p id="p1" style="width:300px; height:50px; border:1px solid red;"></p>
<button id="test1">테스트</button>
<!-- jquery ajax 사용 1 -->
<script type="text/javascript">
	//jQuery(document).ready(function(){//이벤트 처리 코드 작성	});
	$(function(){
		$("#test1").click(function(){
			//컨트롤러를 요청하고, 결과로  문자열만 받는 경우
			//jQuery.get() 메소드 사용
			//$.get('요청 url', {전달이름: 전달값, 리턴값 받아 처리할 콜백함수});
			//get 방식으로 요청됨
			$.get('/testa/t1.do', function(data){
				$('#p1').text(data);
			});
			
			//jQuery.ajax() 메소드 사용
			$.ajax({
				url: "/testa/t1.do",
				type: "get",
				success: function(data){
					$('#p1').html($('#p1').text() + '<br>' + data);
				}
			}); //ajax
		}); //click
	}); //ready
</script>
<hr>
<h2>2. 서버로 값을 보내고 결과로 문자열을 받아 출력 처리하는 방법 : get 방식</h2>
<!-- ajax를 쓸 때 form태그 쓰면 안되고 input만 써야됨  -->
아이디 : <input type="text" id="userid"> <br>
암 호 : <input type="password" id="userpwd"> <br>
<p id='p2' style="width:300px; height:50px; border:1px solid red;"></p>
<button id="test2">테스트</button>
<script type="text/javascript">
	$(function(){
		$("#test2").click(function(){
			//전송방식이 get 일 떄는
			//jQuery.get() 과 jQuery.ajax() 중 선택 사용
			//$.get() 사용시 
			$.get("/testa/t2.do",{userid: $("#userid").val(),//userid는 서블릿으로 전달
								  userpwd: $("#userpwd").val() },//userpwd도 서블릿으로 전달
								  function(data){
									  $('#p2').text(data);
									  //input의 기록된 값 지우기 처리
									  $('#userid').val('');
								  });
			//$.ajax() 사용시
			$.ajax({
				url: "/testa/t2.do",
				type: "get",
				data: {userid: $("#userid").val(),
					   userpwd: $("#userpwd").val()},
				success: function(returnValue){
					$("#p2").html($("#p2").text() + "<br>" + returnValue);
					$("#userid").val("");
					$("#userpwd").val("");
				}
			});
		});//click
	});//ready
</script>
<hr>
<h2>3. 서버로 여러 개의 값들을 보내고, 결과를 안 받는 경우 : post 방식</h2>
<button id="test3"></button>
</body>
</html>