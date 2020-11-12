$(document).ready(function(){
	$('.pbtn').click(function(){
		// 어떤 버튼이 클릭됐는지 알아낸다.
		var str = $(this).text();
		var sno = $(this).attr('id');
		
		if(!sno){
			sno = str;
		}
		$('#pfrm').attr('method', 'POST');
		$('#pfrm').attr('action', '/cls/reBoard/reBoardList.cls');
		$('#pfrm').prepend('<input type="hidden" name="nowPage" value="' +sno + '">');
		$('#pfrm').submit();
		
		
	});
	$('.pagebtn').click(function(){
		// 어떤 버튼이 클릭됐는지 알아낸다.
		var sno = $(this).attr('id');
		
		if(!sno){
			//sno가 null 또는 Undefined인 경우는 페이지번호
			sno = $(this).text();
		}
		$('#nowPage').val(sno);
		$('#pfrm').submit();
		
	});
	
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
	
	$('#mcbtn').click(function(){
		$('#wmodal').css('display','none');
	});
	
	//글쓰기 버튼 이벤트 처리
	$('#wbtn').click(function(){
		$('#wmodal').css('display','block');
	});
	
	// 글삭제 버튼 이벤트 처리
	$('.dbtn').click(function(){
		var str = $(this).attr('id');
		var tno = str.substring(1);
		$('#dbno').val(tno);
		$('#frm1').submit();
		
	});
	
	// 게시글 수정 이벤트 처리
	$('.ebtn').click(function(){
		
		/*
		// 모달창 사용해서 처리하는 방법
		$('#wrbtn').html('edit');
		
		var tno = $(this).attr('id').substring(1);
		//수정할 글번호 기억시켜놓고
		$('#tno').val(tno);
		
		//수정할 내용 읽어오고
		var tbody = $(this).parent().prev().html().replaceAll('<br>', '\r\n'); //태그라이브러리는 읽지 않는다.
							//parent().siblings().eq(0);
		//내용 입력태그에 입력하고
		$('#body').val(tbody);
		$('#wmodal').css('display', 'block');
		*/
		
		// 데이터 입력태그에 셋팅하고
		// 글번호 셋팅
		var tno = $(this).attr('id').substring(1);
		$('#tno').val(tno);
		// 글내용
		var tbody = $(this).parent().siblings().eq(0).html().replaceAll('<br>', '\r\n');
		//태그라이브러리는 읽지 않는다.
		$('#body').val(tbody);

		
		
		// 새로운 뷰를 요청해서 처리하는 방법
		$('#frm').attr('method', 'POST');
		$('#frm').attr('action', '/cls/reBoard/reBoardEditView.cls');
		$('#frm').submit();
	});
	
	
	$('#rbtn').click(function(){
		$('#body').val('');
	});
	
	$('#wrbtn').click(function(){
		// 수정 또는 등록인지 구분해준다.
		var str = $(this).text();
		
		
		// 데이터 읽고
		var txt = $('#body').val();
		var url = '/cls/reBoard/reBoardWriteProc.cls'
		if(str != 'edit'){
			if(!txt){
				alert('# 메세지를 입력하세요!');
				return;
			};
			
		} else {
			url = '/cls/reBoard/reBoardEditProc.cls';
		}
		
		
		$('#frm').attr('method', 'POST');
		$('#frm').attr('action', url);
		
		$('#frm').submit();		
	});
	$('.rebtn').click(function(){
		var tno = $(this).attr('id');
		$('#tno').val(tno);
		
		//form 태그 속성
		$('#frm').attr('method', 'POST');
		$('#frm').attr('action', '/cls/reBoard/reBoardComment.cls');
		$('#frm').submit();
		
	});
});