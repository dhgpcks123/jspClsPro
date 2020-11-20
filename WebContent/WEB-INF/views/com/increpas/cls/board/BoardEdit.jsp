<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>BoardEdit</title>
	<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
	<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
	<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/cls/js/board.js"></script>
	</head>

	<body>
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-padding w3-card-4 w3-round-large">파일게시판 글쓰기</h1>
		<form class="w3-col w3-margin-top w3-card-4 w3-padding" encType="multipart/form-data"
			method="POST" action="/cls/board/boardEditProc.cls" id="efrm" name="efrm">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Writer : </label>
				<div class="w3-col m9 pdl20 w3-label w3-margin-left" style="padding-left: 5px;"> ${DATA.id}</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title : </label>
				<input type="text" name="title" id="title" 
						class="w3-col m9 w3-input pdl20 w3-margin-left" placeholder="제목을 입력하세요!" value="${DATA.title}">
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">File : </label>
				<div class="w3-col m9 filefr">
					<input type="file" name="file1" 
							class="w3-col w3-input pdl20 upfile w3-margin-left" placeholder="파일을 선택하세요!">
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom ">
				<label class="w3-col m2 w3-right-align w3-label">Message : </label>
				<div class="w3-col m9 pdl20 filefr">
					<textarea name="body" id="body" 
							class="w3-col w3-input w3-margin-left w3-border" placeholder="내용을 입력하세요!" rows="10" style="">${DATA.body}</textarea>
				</div>
			</div>

	<c:forEach var="fdata" items="${DATA.list}">
			<div class="imgboxfr w3-margin-top w3-margin-bottom w3-border">
				<div class="w3-margin-bottom imgbox3">
					<a href="/cls/img/upload/${fdata.savename}">
						<img src="/cls/img/upload/${fdata.savename}" class="imgsrc2">
					</a>
					<span>
						<small>${fdata.oriname}</small>
					</span>
				</div>
			</div>
	</c:forEach>
			
		</form>
		<div class="w3-col w3-margin-top w3-card-4 w3-margin-bottom">
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-red w3-hover-deep-orange" id="cbtn">취 소</div>
			<div class="w3-third w3-button w3-blue w3-hover-deep-blue" id="edit">edit</div>
		</div>
	</div>
	</body>
</html>