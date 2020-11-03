$(document).ready(function(){
	//	아이디 체크버튼 처리
	
	$('#id').keyup(function(){
		// 할 일
		// 1. 아이디 입력값을 알아낸다.
		var sid = $('#id').val().trim();
		
		if(!sid){
			return;
		}
		// 데이터를 서버에 보내서 응답을 받는다. 비동기통신으로
		$.ajax({
			url: '/cls/member/idCheck.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data){
				if(data.result == 'OK'){
					//사용가능한 아이디인 경우
					$('#idmsg').html('**** 사용가능한 아이디 입니다 ****');
					$('#idmsg').removeClass('w3-text-red');
					$('#idmsg').addClass('w3-text-blue');
					$('#idmsg').stop().slideDown(500);
				} else {
					//사용가능한 아이디인 경우
					$('#idmsg').html('**** 사용 불가능한 아이디 입니다 ****');
					$('#idmsg').removeClass('w3-text-blue');
					$('#idmsg').addClass('w3-text-red');
					$('#idmsg').stop().slideDown(500);
				}
			
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
});