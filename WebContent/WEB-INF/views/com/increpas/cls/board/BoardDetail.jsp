<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>BoardDatail</title>
	<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
	<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
	<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/cls/js/board.js"></script>
	</head>

	<body>
		<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-padding w3-card-4 w3-round-large">게시글 상세보기</h1>
		<form class="w3-col w3-margin-top w3-card-4 w3-padding" encType="multipart/form-data"
			method="POST" action="/cls/board/boardWriteProc.cls" id="wfrm" name="wfrm">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Writer :</label>
				<div class="w3-col m9 pdl20 w3-label w3-margin-left" style="padding-left: 5px;">${BOARD.id}</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title : </label>
				<div id="title" class="w3-col m9 pdl20 w3-margin-left">${BOARD.title}</div>
			</div>
		<c:if test="${FILE.oriname!=null}">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">FileName : </label>
				<div id="oriname" class="w3-col m9 pdl20 w3-margin-left">${FILE.oriname}</div>
			</div>
		</c:if>
		<c:if test="${FILE.savename!=null}">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">IMG : </label>
				<div id="outImg" class="w3-col m9 pdl20 w3-margin-left"><img src="/cls${FILE.dir}${FILE.savename}" style="width: 100px; height: auto;"></div>
			</div>
		</c:if>
			<div class="w3-col w3-margin-top w3-margin-bottom ">
				<label class="w3-col m2 w3-right-align w3-label">Message : </label>
				<div class="w3-col m9 pdl20 filefr">
					<div id="body" class="w3-col w3-margin-left" style="">${BOARD.body}</div>
				</div>
			</div>
			
		</form>
		<div class="w3-col w3-margin-top w3-card-4 w3-margin-bottom">
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-red w3-hover-deep-orange" id="backbtn">아이고</div>
			<div class="w3-third w3-button w3-blue w3-hover-deep-blue reWritebtn">수정</div>
		</div>
	</div>
		
		
	</body>
</html>