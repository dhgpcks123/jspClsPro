$(document).ready(function(){
	
	
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var target='';
		
		switch(tid){
			case 'hbtn':
				//홈버튼
				target = '/cls/main.cls';
				break;
			case 'lbtn':
				//로그인버튼
				target = '/cls/member/login.cls';
				break;
			case 'jbtn':
				//회원가입 버튼
				target= '/cls/member/join.cls';
			case 'obtn':
				//로그아웃버튼
				target ='/cls/member/logout.cls';
		}
		$(location).attr('href', target);
	});
	
	
});