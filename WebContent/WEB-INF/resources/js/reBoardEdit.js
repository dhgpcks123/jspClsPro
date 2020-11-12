$(document).ready(function(){
	var body = $('#body').val();
	$('#wrbtn').click(function(){
		//body 글 읽어오고
		var tbody=$('#body').val();
		// 원글과 비교해서 처리
		$('#body').val();
		
		if(body == tbody){
			alert('수정 된 내용이 없습니다');
			return;
		}
		
		// 폼태그 전송하고		
		$('#frm').submit();
	});
	$('#rbtn').click(function(){
		$('#body').val(body);
	})
});