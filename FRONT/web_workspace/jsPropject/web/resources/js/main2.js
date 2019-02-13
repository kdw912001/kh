/** main2.js
 * 2019-02-13 작성
 * sample3.html 에서 사용
 */

function showAlert(){
	window.alert("메시지만 출력하는 알림창입니다.");
}
function showConfirm(){
	var returnValue = window.confirm(
			"찬성하면 확인, 반대하면 취소를 누르시오.");
	document.getElementById("result").innerHTML = 
		"리턴값 확인 : " + returnValue;
}
function showPrompt(){
	var inputValue = window.prompt("주소를 입력하세요.");
	document.getElementById("result").innerHTML = 
		"입력된 주소 확인 : " +inputValue;
}
function inputValue(){
	var userName = document.getElementById("username").value;
	/*window.*/alert("입력된 이름 : " + userName);
}
function calculator(op){
	var n1 = Number(document.getElementById("n1").value);
	var n2 = Number(document.getElementById("n2").value);
	var result;
	
	switch(op){
	case "+": result = n1 + n2; break;
	case "-": result = n1 - n2; break;
	case "*": result = n1 * n2; break;
	case "/": result = n1 / n2; break;
	case "%": result = n1 % n2; break;
	}
	document.getElementById("calc").innerHTML = 
		n1 + " " + op + " " + n2 + " = " + result;
}

function equalCheck(){
	alert("== 연산자 : " + (''== false) + ", "
				+ ('' == 0) + ", " + (0 == false) + ", "
				+ ('273' == 273) + "\n"+
				"=== 연산자 : "+ (''=== false) + ", "
				+ ('' === 0) + ", " + (0 === false) + ", "
				+ ('273' === 273) + "\n");
}
function switchCheck(){
	var today = new Date();
	var currentHour = today.getHours();
	console.log("현재 시간 : " + currentHour);
	
	switch(true){
	case currentHour == 9: alert("업무시작 시간입니다."); break;
	case currentHour < 12: alert("오전 업무시간입니다."); break;
	case currentHour == 12: alert("점심시간입니다."); break;
	case currentHour < 18: alert("오후 업무시간입니다."); break;
	default : alert("업무시간 종료입니다.");
	}
}
function logicCheck(){
	var value = Number(prompt("숫자를 입력하세요."));
	
	//짧은 조건문 : || 는 앞이 거짓이면 뒤를 실행,
	//&& 는 앞이 참이면 뒤를 실행
	value % 2 == 0 || alert("홀수입니다.");
	value % 2 == 0 && alert("짝수입니다.");
}