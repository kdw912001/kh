<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<!-- 상대경로 사용 -->
<!-- <script type="text/javascript" src="../../../resources/js/jquery-3.3.1.min.js"></script> -->
<!-- 절대경로 사용 : /first/webapp  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#test1").on("click", function(){
		$.ajax({
			url: "test1.do",
			data: { name: "박혁거세", age: 33},
			type: "post",
			success: function(result){
				if(result == "ok"){
					alert("전송 성공!");
					console.log("result : " + result);
					$("#d1").html("<h5>" + result + "</h5>");
				}else{
					alert("전송 실패!");
				}
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
						+ "\nmessage : " + request.responseText
						+ "\nerror : " + errorData);
			}
		});
	});
	
	$("#test2").on("click", function(){
		//test2.do 로부터 json 객체를 리턴받아, div에 출력
		$.ajax({
			url: "test2.do",
			type: "post",
			dataType: "json",
			success: function(jsonData){
				console.log("jsonData : " + jsonData);
				$("#d2").html("번호 : " + jsonData.no +
						"<br>제목 : " + 
						decodeURIComponent(jsonData.title.replace(/\+/g, " ")) +
						"<br>작성자 : " + jsonData.writer
						+ "<br>내용 : " +
						decodeURIComponent(jsonData.content.replace(/\+/g, " ")));
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
						+ "\nmessage : " + request.responseText
						+ "\nerror : " + errorData);
			}
		});
	});
	
	$("#test3").on("click", function(){
		//컨트롤러에서 list 를 json 배열로 바꾸어 리턴한 경우
		$.ajax({
			url: "test3.do",
			type: "post",
			dataType: "json",
			success: function(obj){
				console.log(obj);  //object 라고 출력됨
				//리턴된 객체 하나를 문자열로 변환 처리
				var objStr = JSON.stringify(obj);
				//문자열을 json 객체로 바꿈
				var jsonObj = JSON.parse(objStr);
				
				//출력용 문자열 준비
				var outValues = $("#d3").html();
				
				for(var i in jsonObj.list){
					outValues += jsonObj.list[i].userid
						+ ", " + jsonObj.list[i].userpwd
						+ ", " + decodeURIComponent(jsonObj.list[i].username)
						+ ", " + jsonObj.list[i].age
						+ ", " + jsonObj.list[i].email
						+ ", " + jsonObj.list[i].phone + "<br>";
				}
				
				$("#d3").html(outValues);
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
					+ "\nmessage : " + request.responseText
					+ "\nerror : " + errorData);
			}
		});
	});
	
	$("#test4").on("click", function(){
		//컨트롤러에서 Map 객체를 JsonView 를 이용해
		//json 객체로 리턴하면 받아서 출력
		$.ajax({
			url: "test4.do",
			type: "post",
			dataType: "json",
			success: function(jsonObj){
				console.log(jsonObj);
				
				$("#d4").html(
					"받은 Map 안의 객체 정보 확인<br>"
					+ "이름 : " + 
					decodeURIComponent(jsonObj.hashMap.samp.name)
					+ ", 나이 : " + jsonObj.hashMap.samp.age);
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
					+ "\nmessage : " + request.responseText
					+ "\nerror : " + errorData);
			}
		});
	});
	
	$("#test5").on("click", function(){
		//자바스크립트 또는 제이쿼리에서 json 객체 만들어서
		//컨트롤러로 보내기
		var job = new Object();
		job.name = "강감찬";
		job.age = 33;
		
		//var job = {name: "강감찬", age: 33};
		console.log("job : " + job);
		
		$.ajax({
			url: "test5.do",
			type: "post",
			data: JSON.stringify(job),
			contentType: "application/json; charset=utf-8",
			success: function(result){
				alert("전송 성공 : " + result);
				
				$("#d5").html("전송한 json 객체 값 : "
						+ job.name + ", " + job.age);
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
					+ "\nmessage : " + request.responseText
					+ "\nerror : " + errorData);
			}
		});
	});
	
	$("#test6").on("click", function(){
		//자바스크립트 또는 제이쿼리에서 jsonArray 객체를
		//만들어서 컨트롤러로 보내기
		//var jarr = new Array(5);  => index 사용
		//var jarr = new Array(); => push(), pop() 사용
		var jarr = [{"name": "이율곡", "age": 33}, 
			{"name": "황진이", "age": 22}, 
			{"name": "김춘추", "age": 29}];
		
		$.ajax({
			url: "test6.do",
			type: "post",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(jarr),
			success: function(result){
				alert("전송 성공 : " + result);
				
				var values = $("#d6").html();
				for(var i in jarr){
					values += "이름 : " + jarr[i].name
						+ ", 나이 : " + jarr[i].age
						+ "<br>";
				}
				
				$("#d6").html(values);
			},
			error: function(request, status, errorData){
				console.log("error code : " + request.status
					+ "\nmessage : " + request.responseText
					+ "\nerror : " + errorData);
			}
		});
	});
});
</script>
</head>
<body>
<h1>spring framework ajax test</h1>
<ol>
<li>서버쪽 컨트롤러로 값 보내기 &nbsp; 
<button id="test1">테스트1</button></li>
<p><div id="d1"></div></p>
<li>컨트롤러로 부터 json 객체 받아서 출력 &nbsp; 
<button id="test2">테스트2</button></li>
<p><div id="d2"></div></p>
<li>컨트롤러로 부터 json 배열 받아서 출력 &nbsp; 
<button id="test3">테스트3</button></li>
<p><div id="d3"></div></p>
<li>컨트롤러로 부터 맵(Map) 객체 받아서 출력 &nbsp; 
<button id="test4">테스트4</button></li>
<p><div id="d4"></div></p>
<li>컨트롤러에 json 객체 보내기 &nbsp; 
<button id="test5">테스트5</button></li>
<p><div id="d5"></div></p>
<li>컨트롤러에 json 배열 보내기 &nbsp; 
<button id="test6">테스트6</button></li>
<p><div id="d6"></div></p>
</ol>
</body>
</html>