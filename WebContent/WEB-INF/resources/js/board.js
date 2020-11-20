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
		$('#bfrm').attr('action','/cls/board/boardDetail.cls');
		$('#bfrm').submit();
		
	});
	$('#rbtn').click(function(){
		$(location).attr('href', '/cls/board/boardWrite.cls');		
	});
	
	/* 게시글 작성 페이지 이벤트 처리 */
	$('.wbtn').click(function(){
		var shead = $('#title').val();
		var sbody = $('#body').val();
		
		// 데이터가 입력되어있는지 확인하고...
		if(((shead.trim() == '')) || (!sbody)){
			return;
		}
		// 이 곳을 실행하는 경우는 모든 입력태그에(파일태그제외) 데이터가 입력된 경우
		$('#wfrm').submit();
		
	});
	$('#edit').click(function(){
		$('#frm').submit();
	});
	// 문서가 완성이 되면 태그에 입력된 값을 기억해 놓는다.
	var stitle = $('#title').text();
	var body = $('#body').text();
	
	$('#dit').click(function(){
		var tTitle = $('#title').html();
		var tBody = $('#body').html();
		
		if(stitle == tTitle && tBody == body){
			return;
		}
		
		if(stitle == tTitle){
			$('#title').prop('readonly', true);
		}
		
		if(tBody == body){
			$('#body').prop('readonly', true);
		}
		
		$('#efrm').submit();
	});
	
});