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
	
	//성별 선택하면 성별에 맞는 아바타 선택창 보여주는 기능 처리
	$('.gen').click(function(){
		// 할 일
		// 1. 무슨 성별이 선택됐는지 알아낸다.
		var sgen = $(this).val();
		if(sgen == 'M'){
			$('.avtFfr').stop().hide();
			$('.avtMfr').stop().slideDown(300);
		}else if(sgen =='F'){
			$('.avtMfr').stop().hide();
			$('.avtFfr').stop().slideDown(300);
		}
	});
	
	
	//비밀번호 확인 기능
	$('#repw').keyup(function(){
			//할 일
			// 1. 비밀번호 읽어오고
			var spw = $('#pw').val();
			// 2. 확인번호 읽어오고
			var srepw = $(this).val();
			// 3. 비교하고
			if(spw==srepw){
			// 4. 결과 처리하고
				$('#pwmsg').css('color','green');
				$('#pwmsg').html('***** 비밀번호가 일치합니다 *****');
				setTimeout(hidePwTag, 1500);
			}else{
				$('#pwmsg').css('color','red');
				$('#pwmsg').html('***** 비밀번호가 불일치합니다 *****');
			}
				$('#pwmsg').stop().show();
	});
	
	function hidePwTag(){
		$('#repw').parent().parent().stop().slideUp(300);
	}
	
	// 회원이름 정규식 검사
	$('#name').change(function(){
		var sname = $(this).val();
		
		var pattern =/^[가-힣]{2,10}$/;
		
		var result = pattern.test(sname);
	});
	
	
	$('#pw').keyup(function(){
		// 비밀번호는 영대소문자 각 1개씩 숫자 1개 특수문자(#@!$%&-_) 1ro
		// 가 반드시 한개가 포함되는 형식을 사용하기러 한다.
		var spw = $(this).val();
		// 정규식 패턴 만들고
		var pattern = /^.*(?=^[a-zA-Z0-9#@!$%&-_*]{8,})(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#@!$%&-_*]).*$/;
//		var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}/
		// 검사하고
		var result = pattern.test(spw);
		// 결과로 처리하고
		if(result){
			$(this).removeClass('w3-pale-red')
			$(this).addClass('w3-teal')
		}else{
			$(this).removeClass('w3-teal')
			$(this).addClass('w3-pale-red')
			
		}
	});

	//버튼 이벤트 처리
	//홈버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls');
	});
	
	$('#jbtn').click(function(){
		//할 일
		//데이터 유효성 검사하고
		var sid = $('#id').val();
		var spw = $('#pw').val();
		var sname = $('#name').val();
		var smail = $('#mail').val();
		var stel = $('#tel').val();
//		*********:checked
		var sgen = $('.gen:checked').val();
		var savt = $('.avt:checked').val();
		
		if(!(sid && spw && sname && smail && stel && sgen && savt )){
			// 입력하지 않은 태그가 적어도 한 개 이상 존재한다.
			return;
		}
		$('#frm').attr('method', 'POST');
		$('#frm').attr('action', '/cls/member/joinProc.cls');
		
		$('#frm').submit();
	});
});