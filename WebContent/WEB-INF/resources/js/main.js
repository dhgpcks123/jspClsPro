$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href', '/cls/member/login.cls');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/cls/member/logout.cls');
	});
	
	$('#ibtn').click(function(){
		$('#frm').submit();
	});
	
	$('#gbtn').click(function(){
		$(location).attr('href', '/cls/guestBoard/gBoardList.cls');
	});
	$('#rbtn').click(function(){
		$(location).attr('href', '/cls/reBoard/reBoardList.cls');
	});
	$('#irbtn').click(function(){
		$(location).attr('href', '/cls/reBoard/initRBD.cls');
	});
	$('#sbtn').click(function(){
		$(location).attr('href', '/cls/survey/surveyInfo.cls');
	});
	$('#fbtn').click(function(){
		$(location).attr('href', '/cls/board/boardList.cls');
	});
	
	
	document.getElementById('jbtn').onclick = function(){
		location.href= '/cls/member/join.cls';
	};
});

//	$('#frm').submit();
		//	$.ajax({
		//		url: '/cls/member/getInfo.cls',
		//		type: 'POST',
		//		dataType: 'json',
		//		data: {
		//			id:tmpid
		//		},
		//		success: function(result){
		//		},
		//		error: function(){
		//			alert('### 통신 에러 ###');
		//		}
		//		
		//	});