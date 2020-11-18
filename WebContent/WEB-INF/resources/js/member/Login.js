$(document).ready(function(){
	$('#id').keydown(function(key){
		binReturn();
		if(key.keyCode == 13){
			$('#frm').submit();
		}
	});
	$('#pw').keydown(function(key){
		binReturn();
		if(key.keyCode == 13){
			$('#frm').submit();
		}
	});
	
	$('#btn1').click(function(){
		$(location).attr('href', '/cls/main.cls')
	});
	$('#btn2').click(function(){
		// 할 일
		// 1. 입력한 데이터 읽고
		binReturn();
		
		$('#frm').submit();
	});
});


// id, pw 비었을 경우 리턴해주는 함수
var binReturn = function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		if(!(sid && spw)){
			return;
		}
		
	}