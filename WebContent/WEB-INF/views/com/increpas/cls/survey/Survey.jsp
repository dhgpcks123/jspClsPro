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
				<h4 class="w3-col w3-border-bottom w3-text-blue">못넣겠다????</h4>
				<form class="w3-col w3-padding w3-left-align w3-border-bottom">
				
					<!-- 문항 추가 -->
					<div class="w3-col w3-margin-bottom">
						<c:forEach var="data" items="${LIST}">
						
						<c:if test="${data.step eq 0}">
							<div class="w3-col pdl30">
								<div class="ft12 w3-margin-top"><h5 class="w3-left-align txt14">* ${data.qbody}</h5></div>
							</div>
						</c:if>
						<c:if test="${data.step eq 1}">
							<div class="w3-col pdl30">
								<div class="ft12 w3-padding"><input type="radio" name="${data.upno}" value="${data.qbody}">${data.qbody}</div>
							</div>
						</c:if>
						</c:forEach>
					</div>
					
				</form>
				<div class="w3-col w3-margin-top">
					<div class="w3-col m2 w3-left w3-button w3-green" id="hbtn">HOME</div>
					<div class="w3-col m2 w3-right w3-button w3-green" id="sbtn">제 출</div>
				</div>
			</div>
		</div>
	</body>
</html>