<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1st JSP파일</title>
	<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
	<!-- http://localhost/jspcls/main.cls 어디서 시작되는지 서버가 뭔지 명시해줘야함.-->
	<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
	<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/cls/js/main.js"></script>
	<script type="text/javascript">
		$(function(){
			var sid = '${SID}';

			if(sid){
				$('#lbtn').css('display', 'none');
				$('#btnfr').css('display', 'block');
			}
		});
	</script>
	<style>
		h5 {
			height: 40px;
		}
	</style>

</head>
<body>
	<form method="POST" action="/cls/member/memberInfo.cls" id="frm" name="frm">
		<input type="hidden" id="id" name="id" value="${SID}">	
	</form>
	<div class="w3-content w3-center mw700">
		<h1 class="w3-teal w3-padding w3-border-bottom">CLS Project</h1>
		<div class="w3-col w3-padding w3-margin-top">
			
			<c:if test="${empty SID}">
				<h5 class="w3-col m5 w3-button w3-light-blue w3-hover-cyan w3-left" id="jbtn">Join</h5>
				<div class="w3-col m2"></div>
				<h5 class="w3-col m5 w3-button w3-light-blue w3-hover-cyan w3-right" id="lbtn">Login</h5>
			</c:if>
			
			<c:if test="${not empty sessionScope.SID}">
				<div class="w3-left w3-padding" style="color: gray;">[ ${SID} ] 회원님이 로그인 되어 있습니다</div>
				<div class="w3-col" id="btnfr">
					<div class="w3-col w3-margin-bottom w3-border-bottom">
						<h5 class="w3-col m5 w3-button w3-red w3-hover-pink w3-right" id="obtn">LogOut</h5>
						<div class="w3-col m2"></div>
						<h5 class="w3-col m5 w3-button w3-red w3-hover-pink w3-left" id="ibtn">회원정보</h5>
					</div>
					<div class="w3-col w3-margin-top mt10" style="display:flex; justify-content: space-between;">
						<h5 class="w3-button w3-lime w3-hover-green mw150" id="gbtn">방명록</h5>
						<h5 class="w3-button w3-lime w3-hover-green mw150" id="sbtn">설문조사</h5>
						<h5 class="w3-button w3-lime w3-hover-green mw150" id="bbtn">게시판</h5>
						<h5 class="w3-button w3-lime w3-hover-green mw150" id="fbtn">파일게시판</h5>
					</div>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>