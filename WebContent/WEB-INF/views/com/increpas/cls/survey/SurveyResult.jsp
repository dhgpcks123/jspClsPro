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
	<script type="text/javascript" src="/cls/js/survey.js"></script>
	</head>

	<body>
		<div class="w3-content w3-center mw700">
			<h1 class="w3-padding w3-blue">설문문항</h1>
			<div class="w3-col w3-padding w3-card-4">
				<h4 class="w3-col w3-border-bottom w3-text-blue">2020년 11월 class2 아이돌 선호도 조사</h4>
				<form class="w3-col w3-padding w3-left-align w3-border-bottom">
				
					<!-- 문항 추가 -->
					<div class="w3-col w3-margin-bottom">
						<h5 class="w3-left-align txt14">1. 당신이 좋아하는 가수는?</h5>
						<div class="w3-col pdl30">
							<div class="ft12"> 제시</div>
							<div class="w3-col m10 w3-orange" style="width: 25%; height: 7px;"><p></p></div>
							<div class="w3-col m2 w3-text-orange w3-right">25%</div>
						</div>
						<div class="w3-col pdl30">
							<div class="ft12"> 안지영</div>
							<div class="w3-col m10 w3-orange" style="width: 45%; height: 7px;"><p></p></div>
							<div class="w3-col m2 w3-text-orange w3-right">45%</div>
						</div>
						<div class="w3-col pdl30">
							<div class="ft12"> 우지윤</div>
							<div class="w3-col m10 w3-orange" style="width: 25%; height: 7px;"><p></p></div>
							<div class="w3-col m2 w3-text-orange w3-right">25%</div>
						</div>
						<div class="w3-col pdl30">
							<div class="ft12"> 헨니</div>
							<div class="w3-col m10 w3-orange" style="width: 5%; height: 7px;"><p></p></div>
							<div class="w3-col m2 w3-text-orange w3-right">5%</div>
						</div>
					</div>
					
				</form>
				<div class="w3-col w3-margin-top">
					<div class="w3-col w3-button w3-green w3-hover-lime" id="hbtn">HOME</div>
				</div>
			</div>
		</div>
	</body>
</html>