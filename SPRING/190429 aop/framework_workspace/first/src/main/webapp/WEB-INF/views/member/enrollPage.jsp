<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enrollPage</title>
<script type="text/javascript" src="../../../resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//암호와 암호확인의 기록값이 일치하는지 확인
		$("input#userpwd2").blur(function(){
			//포커스가 없어졌을 때
			//console.log("focus 없어짐....");
			var pwd1 = $("#userpwd").val();
			var pwd2 = $("#userpwd2").val();
			
			if(pwd1 != pwd2){
				alert("암호와 암호확인이 일치하지 않습니다.\n"
					+ "다시 입력하십시요.");
				$("#userpwd").select();
			}
		});
	});

	function checkValidate(){
		var userid = $("#userid").val();
		var userpwd = $("#userpwd").val();
		
		//아이디와 암호의 글자갯수 확인
		if(!(userid.length >= 6 && userid.length <= 12)){
			alert("아이디의 글자갯수는 6글자이상 12글자이하여야 합니다.");
			$("#userid").select();
			return false;  //submit 실행 안됨.
		}
		
		if(!(userpwd.length >= 6 && userpwd.length <= 12)){
			alert("암호의 글자갯수는 6글자이상 12글자이하여야 합니다.");
			$("#userpwd").select();
			return false;  //submit 실행 안됨.
		}		
		
		//아이디와 암호의 요구한 글자만 포함 확인
		//영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)만 허용
		//정규표현식을 주로 사용함
		for(var i in userid){
			var ch = userid.charAt(i);
			if(!((ch >= 'A' && ch <= 'Z') || 
				(ch >= 'a' && ch <= 'z') || 
				(ch >= '0' && ch <= '9') || 
				(ch == '#' || ch == '_' || ch == '!' || ch == '*'))){
				alert("아이디는 영어소문자와 영어대문자, " + 
					"숫자, 기호문자(#,_,!,*)만 사용할 수 있습니다.");
				$("#userid").select();
				return false;
			}
		}
		
		for(var i in userpwd){
			var ch = userpwd.charAt(i);
			if(!((ch >= 'A' && ch <= 'Z') || 
				(ch >= 'a' && ch <= 'z') || 
				(ch >= '0' && ch <= '9') || 
				(ch == '#' || ch == '_' || ch == '!' || ch == '*'))){
				alert("암호는 영어소문자와 영어대문자, " + 
					"숫자, 기호문자(#,_,!,*)만 사용할 수 있습니다.");
				$("#userpwd").select();
				return false;
			}
		}
		
		return true;  //submit 실행함.
	}
	
	//정규표현식 사용한 값 검사와 유효성 체크 처리
	function checkValidate2(){
		/*
			정규표현식 작성, 사용방법
			1. var 변수명 = /정규표현식/플래그;
			2. var 변수명 = new RegExp("정규표현식");
			
			if(변수명.test(검사할값)){ 
				정규식을 만족했을 때 처리내용
			}
			
			예 : 입력값이 숫자로만 구성 확인
			var re = /^[0-9]+$/;
			예 : 입력값이 영어소문자와 숫자로만 구성 확인
			    첫글자는 반드시 영어소문자로 시작
			    글자갯수가 4글자이상 12글자이하로 작성
			    \d == [0-9]
				{4, 12} : 4글자이상 12글자이하
			var re = /^[a-z][a-z\d]{4,12}$/;
			예 : 한글로만 2글자 이상
			var re = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힝]{2,}$/;
			
			\w == [a-zA-Z0-9]
			\w-\.
			\.[\w-]{1,3} : .뒤에 영어,숫자가 조합된 글자가 
					1번에서 3번까지 사용 가능함
		*/
		
		var userid = $("#userid").val();
		var userpwd = $("#userpwd").val();
		
		var re = /^[a-zA-Z][\w\_\#\!\*]{6,12}$/;
		
		if(!re.test(userid)){
			alert("아이디는 영어소문자와 영어대문자, " + 
			"숫자, 기호문자(#,_,!,*)만 사용할 수 있습니다.");
			$("#userid").select();
			return false;
		}
		
		if(!re.test(userpwd)){
			alert("암호는 영어소문자와 영어대문자, " + 
			"숫자, 기호문자(#,_,!,*)만 사용할 수 있습니다.");
			$("#userpwd").select();
			return false;
		}
		
		return true;
	}
	
	function checkId(){
		//자바스크립트에서 서블릿으로 서비스요청은 할 수 있음
		//서블릿이 전송하는 결과값을 받을 수 없음
		//서블릿은 처리하고 나서 성공/실패에 대한 뷰를 
		//선택해서 내보내는 방법만 사용 가능함
		/* location.href = "/first/idchk?userid=" + 
				document.getElementById("userid").value; */
		
		//서비스를 요청한 페이지가 바뀌지 않게 하면서
		//네트워크 입출력 방식으로 서블릿이 처리한 결과를
		//자바스크립트가 받아서 사용하려면, ajax 를 사용해야 함
		//ajax 는 자바스크립트를 사용해도 되고(코드가 복잡함), 
		//jQuery 를 사용해도 됨(코드가 간단함).
		
		//jQuery.ajax() 사용
		//웹서버 컨트롤러와 아이디 중복 체크 확인용 통신 처리
		$.ajax({
			url: "idchk.do",
			type: "post",
			data: {userid: $("#userid").val()},
			success: function(data){
				console.log("success : " + data);
				
				if(data == "ok"){
					alert("사용 가능한 아이디입니다.");
					$("#username").focus();
				}else{
					alert("이미 존재하는 아이디입니다.\n"
						+ "다시 입력하십시요.");
					$("#userid").select();
				}
			},
			error: function(jqXHR, textstatus, errorthrown){
				console.log("error : " + jqXHR + ", " + textstatus
						+ ", " + errorthrown);
			}
		});
				
		return false;  //submit 못하게 함
	}
</script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<h1 align="center">회원 가입 페이지</h1>
<form action="minsert.do" method="post" 
enctype="multipart/form-data" 
onsubmit="return checkValidate1();">
<table align="center" width="600" border="1">
<tr height="20"><th width="150" bgcolor="orange">*아이디</th>
<td><input type="text" name="userid" id="userid"
placeholder="6글자이상 12글자이하로 작성" required>
 &nbsp; &nbsp; 
<button onclick="return checkId();">아이디 중복확인</button></td></tr>
<tr height="20"><th width="150" bgcolor="orange">*이 름</th>
<td><input type="text" name="username" id="username" required></td></tr>
<tr height="20"><th width="150" bgcolor="orange">*암 호</th>
<td><input type="password" name="userpwd" id="userpwd" required></td></tr>
<tr height="20"><th width="150" bgcolor="orange">암호확인</th>
<td><input type="password" id="userpwd2" required></td></tr>
<tr height="20"><th bgcolor="orange">*성 별</th>
<td>
	<input type="radio" name="gender" value="M" required> 남
	&nbsp; &nbsp;
	<input type="radio" name="gender" value="F" required> 여

</td></tr>
<tr height="20"><th bgcolor="orange">*나 이</th>
<td><input type="number" name="age" min="19" max="150" 
required></td></tr>
<tr height="20"><th bgcolor="orange">전화번호</th>
<td><input type="tel" name="phone" ></td></tr>
<tr height="20"><th bgcolor="orange">이메일</th>
<td><input type="email" name="email" "></td></tr>
<tr height="20"><th bgcolor="orange">취 미</th>
<td>
<table>
<tr>
	<td width="150">
	<input type="checkbox" name="hobby" value="game" > 게임
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="reading" > 책읽기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="music" > 음악듣기
	</td>
</tr>
<tr>
	<td width="150">
	<input type="checkbox" name="hobby" value="climb" > 등산
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="sport" > 운동
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="movie" > 영화감상
	</td>
</tr>
<tr>
	<td width="150">
	<input type="checkbox" name="hobby" value="travel" > 여행하기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="cook" > 요리하기
	</td>
	<td width="150">
	<input type="checkbox" name="hobby" value="etc" > 기타
	</td>
</tr>
</table>
</td></tr>
<tr height="20"><th bgcolor="orange">기 타</th>
<td><textarea name="etc" rows="5" cols="50">
</textarea></td></tr>
<tr><th>프로필사진</th>
<td><input type="file" name="photo"></td></tr>
<tr height="20"><th colspan="2">
<input type="submit" value="가입하기">
&nbsp; &nbsp;
<input type="reset" value="입력취소">
&nbsp; &nbsp;
<a href="main.do">시작페이지로 이동</a>
</th></tr>
</table>
</form>


</body>
</html>




