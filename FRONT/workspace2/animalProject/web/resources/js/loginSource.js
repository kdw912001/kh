
/*$('.wrapperlogin').hide();

	$('.btn btn-1 btn-sign').click(function() {
		$('.wrapperlogin').show();
	});*/


$(document).ready(function() {

    
    /* alert("오잉"); */
    
    $(".idid > #btnLogin").click(function() {

        var userid = $("#userid").val();
        var passwd = $("#passwd").val();

        if (userid == "") {

            /* alert("아이디를 입력해주세요"); */
            $("#userid").focus();
            return;
        }

//$반복
		
		var exp = /[a-z0-9]$/; //영문자와 숫자
		//정규표현식. test(입력값) 규칙에 맞으면 true
		
		if(!exp.test(userid)){
			
			alert("영문자와 숫자만 입력가능합니다.");
			$("#userid").focus();
			return;
		}

        if (passwd == "") {

            /* alert("비밀번호를 입력해주세요"); */

            $("#passwd").focus();
            return;
        }

        //비동기 ajax 방식으로 데이터 주고 받기 방버버

        var data = "userid=" + userid + "&passwd=" + passwd;

        alert(userid+passwd);
        
        $.ajax({
            
            type : "post",
            data : data,
            url : "/web02/member_servlet/login.do",
            success : function(value) {

                $("#result").html(value);

            }

        });

    });

});
$(document).ready(function() {
	$('a.login-window').click(function() {
		
		// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup and add close button
		$(loginBox).fadeIn(300);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		
		return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.close, #mask').live('click', function() { 
	  $('#mask , .login-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	return false;
	});
});




/*function wrapWindowByMask(){
    //화면의 높이와 너비를 구한다.
    var maskHeight = $(document).height();  
    var maskWidth = $(window).width();  
	
    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
    $('#mask').css({'width':maskWidth,'height':maskHeight});  
	
    //애니메이션 효과
    $('#mask').fadeIn(1000);      
    $('#mask').fadeTo("slow",0.8);    
}

$('.window .close').click(function (e) {  
    //링크 기본동작은 작동하지 않도록 한다.
    e.preventDefault();  
    $('#mask, .window').hide();  
});       

//검은 막을 눌렀을 때
$('#mask').click(function () {  
    $(this).hide();  
    $('.window').hide();  
});*/

/*$(document).ready(function(){
    //검은 막 띄우기
    $('.openMask').click(function(e){
        e.preventDefault();
        wrapWindowByMask();
    });

    //닫기 버튼을 눌렀을 때
    $('.window .close').click(function (e) {  
        //링크 기본동작은 작동하지 않도록 한다.
        e.preventDefault();  
        $('#mask, .window').hide();  
    });       

    //검은 막을 눌렀을 때
    $('#mask').click(function () {  
        $(this).hide();  
        $('.window').hide();  
    });      
});*/