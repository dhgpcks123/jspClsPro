$(document).ready(function(){
	$('#wrbtn').click(function(){
		
		var msg = $('#body').val();
		if(msg.trim() == ''){
			alert('아무 값도 입력되지 않았습니다');
			return;
		}
		
		$('#frm').submit();
		
	});
});