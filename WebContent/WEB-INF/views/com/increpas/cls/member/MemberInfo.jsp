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
				<div class="w3-col m2 w3-button w3-content w3-amber w3-card-4" style="display: inline-block;">Edit</div>
				<h1 class="w3-col m1" style="display: inline-block;"></h1>
				<div class="w3-col m2 w3-button w3-content w3-amber w3-card-4" style="display: inline-block;">탈퇴</div>
			</div>
			<div class="w3-content w3-col w3-border w3-padding w3-card-4" style="margin-top:30px;">
				<div class="w3-col m5">
					<div style="max-width: 250px; max-height:250px; margin-left: 50px;">
						<img src="/cls/img/avatar/${DATA.sname}" style="border: 1px solid black; width: 247px; height: 247px; ">
					</div>
				</div>
				<span class="w3-col m1">
				</span>
				
				<div class="w3-col m6">
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="no">회원번호 : </label>
						<div class="w3-col m7" id="no">${DATA.mno}</div>
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
						<div class="w3-col m7" id="mail">${DATA.mail}</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="gen">성별 : </label>
						<div class="w3-col m7" id="gen">
						<c:if test="${DATA.gen =='M'}">
							남자
						</c:if>
						<c:if test="${DATA.gen =='W'}">
							여자
						</c:if>
						
						</div>
					</div>
					<div class="w3-col w3-padding">
						<label class="w3-col m5" for="date">가입일 : </label>
						<div class="w3-col m7" id="date">${DATA.sdate}</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>