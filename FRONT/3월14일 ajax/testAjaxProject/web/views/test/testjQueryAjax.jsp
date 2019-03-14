<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testjQueryAjax</title>
<script type="text/javascript" src="/testa/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>jQuery 로 ajax 테스트</h1>
<hr>
<h2>1. 서버로 보내는 값 없고, 
결과로 문자열 받아 출력 처리하는 방법 : get 방식</h2>
<p id="p1" style="width:300px;height:50px;border:1px solid red;"></p>
<button id="test1">테스트</button>
<!-- jquery ajax 사용 1 -->
<script type="text/javascript">
	//jQuery(document).ready(function(){ //이벤트 처리 코드 작성 });
	$(function(){
		$("#test1").click(function(){
			//컨트롤러를 요청하고, 결과로 문자열만 받는 경우
			//jQuery.get() 메소드 사용
			//$.get("요청url", {전달이름: 전달값}, 리턴값 받아 처리할 콜백함수);
			//get 방식으로 요청됨
			$.get("/testa/t1.do", function(data){
				$("#p1").text(data);
			});			
			
			//jQuery.ajax() 메소드 사용 : get 방식
			$.ajax({
				url: "/testa/t1.do",
				type: "get",
				success: function(data){
					$("#p1").html($("#p1").text() + "<br>" + data);
				}
			}); //ajax
		});  //click
	}); //ready
</script>
<hr>
<h2>2. 서버로 값을 보내고, 
결과로 문자열을 받아 출력 처리하는 방법 : get 방식</h2>
아이디 : <input type="text" id="userid"> <br>
암 호 : <input type="password" id="userpwd"> <br>
<p id="p2" style="width:300px;height:50px;border:1px solid red;"></p>
<button id="test2">테스트</button>
<script type="text/javascript">
	$(function(){
		$("#test2").click(function(){
			//전송방식이 get 일 때는
			//jQuery.get() 과 jQuery.ajax() 중 선택 사용
			//$.get() 사용시
			$.get("/testa/t2.do", 
				{userid: $("#userid").val(), 
				userpwd: $("#userpwd").val() }, 
				function(data){
					$("#p2").text(data);
					//input 의 기록된 값 지우기 처리
					$("#userid").val("");
					$("#userpwd").val("");
				}); //get
				
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
			});  //ajax
			
		});  //click
	});  //ready
</script>
<hr>
<h2>3. 서버로 여러 개의 값들을 보내고, 
결과를 안 받는 경우 : post 방식</h2>
제목 : <input type="text" id="title"> <br>
작성자 : <input type="text" id="writer"> <br>
내용 : <textarea rows="5" cols="50" id="content"></textarea> <br>
<button id="test3">테스트</button>
<script type="text/javascript">
	$(function(){
		$("#test3").click(function(){
			//전송방식을 post 로 할 경우
			//jQuery.post() 와 jQuery.ajax() 중 선택 사용
			//$.post() 사용시
			$.post("/testa/t3.do", 
				{title : $("#title").val(), 
				 writer : $("#writer").val(),
				 content : $("#content").val() });
			
			//$.ajax 사용시
			$.ajax({
				url : "/testa/t3.do",
				data : { title : $("#title").val(), 
					   writer : $("#writer").val(),
					   content : $("#content").val() },
				type : "post"
			});
			
			//input 값 지우기
			$("#title").val("");
			$("#writer").val("");
			$("#content").val("");
		});  //click
	});  //ready
</script>
<hr>
<h2>4. 서버로 값 보내고, 
결과로 JSON 으로 받아 출력 처리하는 방법 : get 방식</h2>
번호 : <input type="number" id="no"> <br>
<p id="p4" style="width:500px;height:150px;border:1px solid red;"></p>
<button id="test4">테스트</button>
<script type="text/javascript">
	$(function(){
		$("#test4").click(function(){
			//jQuery.getJSON() 과 jQuery.ajax() 중 선택사용
			//$.getJSON() 사용시
			$.getJSON("/testa/t4.do", 
					{no : $("#no").val() }, 
					function(data){
						console.log(data);
						//한 개의 json 객체가 문자열형태로
						//전송이 왔을때는 받아서 바로 사용함
						//한글깨짐을 막기위해 문자 인코딩 처리한 값은
						//디코딩 처리함 : 자바스크립트 내장함수인
						//decodeURIComponent() 사용함
						$("#p4").text(data.no + ", " + data.userid
							+ ", " + data.userpwd + ", "
							+ decodeURIComponent(data.username)
							+ ", " + data.age + ", " + data.email
							+ ", " + data.phone);
					});
			
			//$.ajax() 사용시
			$.ajax({
				url: "/testa/t4.do",
				data: {no : $("#no").val() },
				type: "get",
				dataType: "json",
				success: function(data){
					$("#p4").html($("#p4").text() + "<br>"
							+ data.no + ", " + data.userid
							+ ", " + data.userpwd + ", "
							+ decodeURIComponent(data.username)
							+ ", " + data.age + ", " + data.email
							+ ", " + data.phone);
				}
			});
			
			
		});  //click
	});  //ready
</script>
<hr>
<h2>5. 서버로 값 보내고, 결과로 list 나 map 을 
json 배열로 받아 출력 처리하는 방법 : get 방식</h2>
번호 : <input type="number" id="no2"> <br>
<p id="p5" style="width:500px;height:300px;border:1px solid red;"></p>
<button id="test5">테스트</button>
<script type="text/javascript">
	$(function(){
		$("#test5").click(function(){
			//jQuery.getJSON() 과 jQuery.ajax() 중 선택사용
			//$.getJSON() 사용시
			
			//$.ajax() 사용시
			
			
		});  //click
	}); //ready
</script>







<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>










