$(document).ready(function(){
/* 설문 정보 페이지 이벤트 처리 */
	$('.sibtn').click(function(){
		// 버튼의 아이디값 읽고
		var tid = $(this).attr('id');
		// 입력태그에 입력하고
		$('#sno').val(tid);
		// 폼태그 전송하고
		$('#frm').submit();
		
	});
	
	$('.srbtn').click(function(){
		$(location).attr('href', '/cls/survey/surveyResult.cls');
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls');
	})
	
});