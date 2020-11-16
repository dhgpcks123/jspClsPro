$(document).ready(function(){
	$('.pagebtn').click(function(){
		//어떤 버튼이 클릭됐는지 알아낸다.
		var strPage = $(this).attr('id');
		
		if(!strPage){
			strPage = $(this).text();
		}
		
		$('#nowPage').val(strPage);
		$('#bfrm').attr('action','/cls/board/boardList.cls');
		$('#bfrm').submit();
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls')
	});
	$('#obtn').click(function(){
		$(location).attr('href', '/cls/member/logout.cls')		
	});
	$('#ibtn').click(function(){
		$(location).attr('href', '/cls/member/login.cls')		
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/cls/member/join.cls')		
	});
	
	$('.brow').click(function(){
		var no= $(this).attr('id');
		$('#bno').val(no);
		$('#bfrm').attr('action','/cls/board/boardDetail.cls')
		$('#bfrm').submit();
		
	});
	
});