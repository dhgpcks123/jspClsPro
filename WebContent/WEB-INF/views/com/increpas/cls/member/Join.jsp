<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Cls Project Join Form</title>
	<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
	<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
	<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/cls/js/member/join.js"></script>
	<style type="text/css">
		
	</style>
	</head>

	<body>
		<div class="w3-content w3-center mw650">
			<h1 class="w3-amber w3-padding w3-card-4 w3-margin-top">Cls Join</h1>
			<form method="POST" action="/cls/member/joinProc.cls"
			 class="w3-col w3-padding w3-card-4 w3-margin-top" id="frm" name="frm">

				<div class="w3-col">
					<label for="name" class="w3-col l3 m3 w3-right-align w3-padding clslbl">회 원 이 름 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<input type="text" id="name" name="name" placeholder="이름을 입력하세요!" style="width:400px;">
					</div>
				</div>
				<div class="w3-col">
					<label for="name" class="w3-col l3 m3 w3-right-align w3-padding clslbl">회 원 아이디 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<div class="w3-col m9 pdr10">
							<input type="text" id="id" name="id" placeholder="아이디를 입력하세요!" style="width:275px;">
						</div>
						<div class="w3-col m3 w3-red w3-hover-orange w3-button w3-small w3-card " id="idck">ID Check</div>
						<p class="w3-col w3-center" id="idmsg" style="display: none;"></p>
					</div>
				</div>
				<div class="w3-col">
					<label for="pw" class="w3-col l3 m3 w3-right-align w3-padding clslbl">비 밀 번 호 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요!" style="width:400px;">
					</div>
				</div>
				<div class="w3-col">
					<label for="repw" class="w3-col l3 m3 w3-right-align w3-padding clslbl">비밀번호 확인 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<input type="password" id="repw" name="repw" placeholder="비밀번호를 재입력하세요!" style="width:400px;">
					</div>
				</div>
				<div class="w3-col">
					<label for="mail" class="w3-col l3 m3 w3-right-align w3-padding clslbl">회원 이메일 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<input type="text" id="mail" name="mail" placeholder="이메일을 입력하세요!" style="width: 400px;">
					</div>
				</div>
				<div class="w3-col">
					<label for="tel" class="w3-col l3 m3 w3-right-align w3-padding clslbl">전 화 번 호 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<input type="text" id="tel" name="tel" placeholder="전화번호를 입력하세요!" style="width: 400px;">
					</div>
				</div>
				<div class="w3-col">
					<label class="w3-col l3 m3 w3-right-align w3-padding clslbl">회 원 성 별 :</label>
					<div class="w3-col l8 m8 w3-padding">
						<div class="w3-half">
							<input type="radio" class="gen" id="genM" name="gen" value="M"><span> 남자</span>
						</div>
						<div class="w3-half">
							<input type="radio" class="gen" id="genW" name="gen" value="W"><span> 여자</span>
						</div>
					</div>
				</div>
				<div class="w3-col w3-margin-bottom">
					<label class="w3-col l3 m3 w3-right-align w3-padding clslbl">아바타 선택 : </label>
					<div class="w3-col l8 m8 w3-padding">
						<div class="w3-col avtfr">
							<c:forEach var="data" items="${LIST}">
								<div class="w3-third w3-padding w3-hide avt${data.gen}fr">
									<input type="radio" class="gen" name="avt" value="${data.ano}">
									<div class="w3-col imgbox">
										<img src="/cls/img/avatar/${data.savename}" class="imgsrc">
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</form>
			<div class="w3-col m12 w3-card-4 w3-margin-top w3-margin-bottom">
				<div class="w3-half w3-button w3-green w3-hover-lime" id="hbtn">HOME</div>
				<div class="w3-half w3-button w3-blue w3-hover-aqua" id="jbtn">JOIN</div>
			</div>
		</div>
	</body>
</html>