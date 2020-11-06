$(document).ready(function(){
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var target = '';
		
		switch(tid){
			case 'hbtn':
				//해줄 일 없음
				target = '/cls/main.cls';
				break;
			case 'lbtn':
				//로그인버튼
				target = '/cls/member/login.cls';
				break;
			case 'jbtn':
				//회원가입 버튼
				target = '/cls/member/join.cls';
				break;
			case 'obtn':
				target = '/cls/member/logout.cls';
				break;
			case 'rbtn':
				$('#body').val('');
				return;
				break;
			case 'wbtn':
				$('#frm').attr('method', 'POST');
				$('#frm').attr('action', '/cls/guestBoard/gBoardWrite.cls');
				
				//입력데이터 읽어오고
				var txt = $('#body').val();
				if(!txt){
					$('#body').focus();
					return;
				}
				$('#frm').submit();
				return;
				break;
		}
		$(location).attr('href', target);
	});
});