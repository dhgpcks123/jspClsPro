$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href', '/cls/member/login.cls');
	});
	$('#obtn').click(function(){
		$(location).attr('href', '/cls/member/logout.cls');
	})
});