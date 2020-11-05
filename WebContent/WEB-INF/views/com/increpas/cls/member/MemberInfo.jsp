<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
	<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
	<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/cls/js/member/info.js"></script>
	<style type="text/css">
	body{
	}
	</style>
	</head>
	
	<body>
		<input type="hidden" id="id" name="id" value="${SID}">	
		<div class="w3-content mw800">
			<h1 class="w3-col m12 w3-content w3-center w3-amber w3-card-4 w3-padding">[ ${DATA.name} ] 님 회원정보 </h1>
			<div class="w3-col m12 w3-content">
				<div class="w3-col m2 w3-button w3-content w3-amber w3-card-4" style="display: inline-block;" id="homebtn">HOME</div>
				<h1 class="w3-col m5" style="display: inline-block;"></h1>
				<div class="w3-col m2 w3-button w3-content w3-amber w3-card-4" style="display: inline-block;" id="editbtn">Edit</div>
				<h1 class="w3-col m1" style="display: inline-block;"></h1>
				<div class="w3-col m2 w3-button w3-content w3-amber w3-card-4" style="display: inline-block;" id="dropbtn">탈퇴</div>
			</div>
			
			<form method="POST" action="cls/member/memberDrop.cls"
				id="dropfrm" name="dropfrm" 
				class="w3-col w3-card-4 w3-padding w3-margin-bottom w3-margin-top" style="display:none">
				
				<div class="w3-col m4 w3-padding">
					<label for="pw" class="w3-text-grey w3-right" style="font-size: 20px;">비밀번호 : </label>
				</div>
				<input type="hidden" name="no" id="no" value="${DATA.mno}">
				<input type="password" id="pw" name="pw"
					class="w3-col m5 w3-input w3-border" style="height:50px;">
				<div class="w3-col m2 w3-padding">
					<span class="w3-button w3-padding-left w3-amber w3-hover-lime" id="del">탈퇴처리</span>
				</div>
			</form>
			
			<div class="w3-content w3-col w3-border w3-padding w3-card-4" style="margin-top:30px;">
				
				<div class="w3-col m5">
					<div style="max-width: 250px; max-height:250px; margin-left: 50px;" class="infoAvtBox">
						<img src="/cls/img/avatar/${DATA.avatar}" style="border: 1px solid black; width: 247px; height: 247px;" id="${DATA.avt}"><span class="w3-right">아바타 번호 : ${DATA.avt}</span>
					</div>
				</div>
				<span class="w3-col m1">
				</span>
				
				<div class="w3-col m6">
					<div class="w3-col w3-padding">
						<label class="w3-col m5">회원번호 : </label>
						<div class="w3-col m7">${DATA.mno}</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5">아이디 : </label>
						<div class="w3-col m7" >${SID}</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="name">이름 : </label>
						<div class="w3-col m7" id="name">${DATA.name}</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="mail">이메일 : </label>
						<div class="w3-col m7" id="cMail">${DATA.mail}</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="gen">성별 : </label>
						<div class="w3-col m7" id="gen">
							<c:if test="${DATA.gen == 'M'}">남자</c:if>
							<c:if test="${DATA.gen eq 'W'}">여자</c:if>
								<!-- 다르다 : ne로 씀, else구문 없다 -->
						</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="date">가입일 : </label>
						<div class="w3-col m7" id="date">${DATA.sdate}</div>
					</div>
				</div>
				
			<!-- 정보수정태그 -->
			<form class="w3-col w3-border-top" id="frm" name="frm" style="display: none">
				<div class="w3-col w3-margin-top">
					<div class="w3-col m2 w3-button w3-content w3-blue w3-hover-aqua w3-right w3-card-4" style="display: inline-block;" id="ebtn">수정</div>
				</div>
				
				<div class="w3-col w3-margin-top">
					<label for="mail" class="w3-col l3 m3 w3-right-align w3-padding clslbl">회원 이메일 :</label>
					<div class="w3-col l9 m9 w3-padding">
						<input type="text" id="mail" name="mail" placeholder="이메일을 입력하세요!" value="${DATA.mail}" style="width: 500px;">
					</div>
				</div>
			
				<div class="w3-col w3-margin-bottom w3-margin-top">
					<label class="w3-col l3 m3 w3-right-align w3-padding clslbl">아바타 선택 : </label>
					<div class="w3-col l8 m8 w3-padding">
						<div class="w3-col avtfr">
							<c:forEach var="data" items="${LIST}">
								<c:if test="${data.gen == DATA.gen }">
									<div class="w3-third w3-padding avt${data.gen}fr">
										<input class="w3-col w3-padding" type="radio" class="avt" name="avt" value="${data.ano}">
										<div class="w3-col w3-padding">
											<img src="/cls/img/avatar/${data.savename}" class="imgsrc">
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</form>
			
			</div>
		</div>
	</body>
</html>