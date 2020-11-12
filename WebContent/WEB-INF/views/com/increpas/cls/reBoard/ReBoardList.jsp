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
	<script type="text/javascript" src="/cls/js/reBoard.js"></script>
	</head>
	<style>

	</style>
	<body>
		<h1 class="w3-amber w3-padding w3-card-4 w3 w3-center">댓글 게시판</h1>
		<div class="w3-col pdb10">
			<div class="w3-col m2 w3-left pdh1">
				<span class="w3-col w3-button w3-small w3-green w3-hover-lime w3-left mt0 btnBox" id="hbtn">Home</span>
			</div>
			<c:if test="${empty SID}">
				<div class="w3-col m2 w3-right pdh1">
					<span class="w3-col w3-button w3-small w3-orange w3-hover-deep-orange mt0 btnBox" id="lbtn">로그인</span>
				</div>
				<div class="w3-col m2 w3-right pdh1">
					<span class="w3-col w3-button w3-small w3-blue w3-hover-aqua w3-right mt0 btnBox" id="jbtn">회원가입</span>
				</div>
			</c:if>
			<c:if test="${not empty SID}">
				<div class="w3-col m2 w3-right pdh1">
					<span class="w3-col w3-button w3-small w3-red w3-hover-orange w3-right mt0 btnBox" id="obtn">로그아웃</span>
				</div>
			</c:if>
		</div>
		
		
		<!-- 글 목록창 -->
			<div class="w3-content" style="max-width: 1000px;">
			<c:forEach var="data" items="${LIST}">
				<div class="w3-col" style="padding-left: ${data.step *50}px; padding-top: 10px;">
					<div class="w3-col w3-card-4 w3-border">
						<div class="w3-col m2">
							<div class="w3-col inblock avtbox100 pdr10">
								<img src="/cls/img/avatar/${data.sname}" class="avtimg100 w3-border">
							</div>
						</div>
						<div class="w3-col m9">
							<div class="w3-col w3-border-bottom w3-border-blue w3-left w3-text-grey mb5">
								<div class="w3-cell w3-left">작성자 : ${data.id}</div>
								<div class="w3-cell w3-right"><small>${data.sdate} </small></div>
							</div>
							<div class="w3-col w3-padding h70 w3-left-align">${data.body}</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
				<!-- 
				<div class="w3-col w3-card-4 pd10 w3-margin-top">
					<span class="w3-col m2 w3-center w3-border-right ">
						${data.bno}
					</span>
					<span class="w3-col m3 w3-center w3-border-right">
						${data.id}
					</span>
					<span class="w3-col m4 w3-center w3-border-right">
						${data.body}
					</span>
					<span class="w3-col m3 w3-center">
						${data.sdate}
					</span>
				</div>
				-->
			
		
		<!-- 페이징 버튼 처리할껍니다 -->
		<form class="w3-col w3-center w3-margin-top w3-margin-bottom" id="pfrm" name="pfrm">
			
			<c:if test="${PAGE.startPage eq 1}">
				<span class="w3-bar-item w3-button w3-grey">&laquo;</span>
			</c:if>
			<c:if test="${PAGE.startPage ne 1}">
				<span class="w3-bar-item w3-button w3-hover-lime pbtn" 
						id="${PAGE.startPage - 1}">&laquo;</span>
			</c:if>
			
			<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
				<span class="w3-bar-item w3-button w3-hover-lime pbtn">${page}</span>
			</c:forEach>
			
			<c:if test="${PAGE.endPage eq PAGE.totalPage}">
				<span class="w3-bar-item w3-button w3-grey">&raquo;</span>
			</c:if>
			<c:if test="${PAGE.endPage ne PAGE.totalPage}">
				<span class="w3-bar-item w3-button w3-hover-lime pbtn" 
						id="${PAGE.endPage + 1}">&raquo;</span>
			</c:if>
		</form>
	</body>
</html>