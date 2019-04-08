<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>unicast</title>
<style type="text/css">
	#messageWindow {
		background: LightSkyBlue;
		height: 300px;
		overflow: auto;
	}
	
	.chat_content {
		background: rgb(255, 255, 102);
		padding: 10px;
		border-radius: 10px;
		display: inline-block;
		position: relative;
		margin: 10px;
		float: right;
		clear: both;
	}
	
	.chat_content:after {
		content: '';
		position: absolute;
		right: 0;
		top: 50%;
		width: 0;
		height: 0;
		border: 20px solid transparent;
		border-left-color: rgb(255, 255, 102);
		border-right: 0;
		border-top: 0;
		margin-top: -3.5px;
		margin-right: -10px;
	}
	
	.other-side {
		background: white;
		float: left;
		clear: both;
	}
	
	.other-side:after {
		content: '';
		position: absolute;
		right: 0;
		top: 50%;
		width: 0;
		height: 0;
		border: 20px solid transparent;
		border-right-color: white;
		border-left: 0;
		border-top: 0;
		margin-top: -3.5px;
		margin-left: -10px;
	}
</style>
<!-- <script type="text/javascript" src="/testw/resources/js/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>Unicast 란?</h1>
<h3>네트워크 상에서 클라이언트끼리 1:1로 통신하는 방식</h3>
<p>예 : 1:1 카톡, 전화 통화, 문자 메세지</p>
<hr>
사용할 ID : <input id="chat_id" size="10"> <br>
상대방 ID : <input id="recvUser" size="10"> <br>
<button id="startBtn">채팅하기</button>
<hr>
<!-- 채팅창 구현하기 -->
<div style="display:none;" id="chatbox">
	<fieldset>
	<div id="messageWindow"></div> <br>
	<input id="inputMessage" onkeyup="enterKey();">
	<input type="submit" value="보내기" onclick="send();">
	<input type="button" id="endBtn" value="나가기">
	</fieldset>
</div>

<script type="text/javascript">
	
		//상대방과 연결을 위한 웹소켓 객체 생성함
		var webSocket = null;
		//채팅창 부분의 내용 
		var $textarea = $("#messageWindow");
		//전송할 문자열 기록 input 태그
		var $inputMessage = $("#inputMessage");
		
		/*
			웹소켓 생성 후 동작하는 웹소켓 메소드들
			
			1. open() : 웹소켓 객체 생성시 동작함
				서버와 연결해 주는 메소드임
			2. send() : 서버에 데이터 전송하는 메소드임.
			3. message() : 서버에서 데이트를 받는 메소드.
			4. error() : 서버에 데이터 전송 중 에러 발생시
				자동 실행되는 메소드임
			5. close() : 서버와 연결 끊을 때 사용하는 메소드
		*/
		
		function connection(){
			/*
			웹소켓 객체는 생성자를 통해 생성됨.
			객체 생성시에 서버와 자동 연결됨.
			*/
			webSocket = new WebSocket(
					"ws://localhost:8888" +
					"<%=request.getContextPath()%>/unicast");
			
			//웹소켓을 통해서 연결이 될 때 동작할 이벤트핸들러
			webSocket.onopen = function(event){
				$textarea.html("<p class='chat_content'>"
					+$("#chat_id").val() + 
					"님이 입장하였습니다.</p><br>");	
				//웹소켓을 통해 채팅서버에 참여한 내용을 전송함
				//보낼 때는 send / 받은 때는 message
				webSocket.send($("#chat_id").val() + 
						"|님이 입장함.");
			};
			
			//서버로 부터 메세지 받을 때 동작하는 이벤트핸들러
			webSocket.onmessage = function(event){
				onMessage(event);
			};
			
			//서버로 메세지 보낼 때 에러 발생 처리용 이벤트핸들러
			webSocket.onerror = function(event){
				enError(event);
			};
			
			//서버와 연결을 닫을 때의 이벤트핸들러
			webSocket.onclose = function(event){
				onClose(event);
			};
		} //connection
		
		//엔터키 누를 때 메세지 보내기
		function enterKey(){
			if(window.event.keyCode == 13)
				send();
		}
		
		function send(){
			//메세지를 입력하지 않은 경우
			if($inputMessage.val() == ""){
				alert("전송할 메세지를 입력하세요.");
			}else{
				//메세지를 입력한 경우
				$textarea.html($textarea.html() + 
					"<p class='chat_content'>나 : "
					+ $inputMessage.val() + "</p><br>");
				
				webSocket.send($("#chat_id").val() + "|"
						+ $inputMessage.val());
				$inputMessage.val('');
			}
			
			$textarea.scrollTop($textarea.height());
		}  //send()
		
		//서버로 부터 오는 메세지를 받을 때의 이벤트핸들러가
		//실행하는 함수
		function onMessage(event){
			var message = event.data.split("|");
			//보낸 사람 아이디
			var sender = message[0];
			//전송온 메세지
			var content = message[1];
			
			//전달받은 글이 없거나
			//보낸 사람이 내가 연결한 사람이 아니거나 할 경우
			//아무 내용도 실행하지 않는다.
			if(content == "" ||
					!sender.match($("#recvUser").val())){
				
			}else{
				$textarea.html($textarea.html() + 
					"<p class='chat_content other-side'>"
					+ sender + " : " + content + "</p><br>");
				
				$textarea.scrollTop($textarea.height());
			}
			
		}  //onMessage
		
		function onError(event){
			alert(event.data);
		}
		
		function onClose(event){
			alert(event);
		}		
	
		$("#startBtn").on("click", function(){
			//접속하기 버튼 클릭시 chatbox 가 보이게 함
			$("#chatbox").css("display", "block");
			$(this).css("display", "none");
			connection();
		});
		
		//나가기 버튼 클릭시 소켓 닫기
		//접속하기 버튼 보이게 함, chatbox 는 안보이게 함
		$("#endBtn").on("click", function(){
			$("#chatbox").css("display", "none");
			$("#startBtn").css("display", "inline");
			webSocket.send($("#chat_id").val()
					+ " 님이 퇴장하였습니다.");
			webSocket.close();
		});
	
</script>
</body>
</html>




