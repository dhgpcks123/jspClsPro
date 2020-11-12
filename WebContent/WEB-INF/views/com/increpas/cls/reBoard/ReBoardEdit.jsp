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
	<script type="text/javascript" src="/cls/js/reBoardEdit.js"></script>
	</head>

	<body>
		<div class="w3-content mw700">
			<div class="w3-purple w3-center w3-padding mb10">게시글 수정</div>
					<div class="w3-col">
						<div class="w3-col inblock avtbox100 pdr10">
							<img src="/cls/img/avatar/${param.avatar}" class="avtimg100 w3-border">
						</div>
						<form method="POST" action="/cls/reBoard/reBoardEditProc.cls" class="w3-rest" id="frm" name="frm">
							<input type="hidden" name="bno" id="tno" value="${param.bno}">
							<input type="hidden" name="nowPage" value="${param.nowPage}">
							<input type="hidden" name="tbody" value="${param.body}">
							<textarea class="w3-input w3-border h72" style="resize: none;"
							 		id="body" name="body">${param.body}</textarea>
							
							<div class="w3-col pdh1 mt5">
								<span class="w3-col m2 w3-left w3-button w3-small w3-orange w3-hover-deep-orange btnBox"
								 		id="rbtn">reset</span>
								<span class="w3-col m2 w3-right w3-button w3-small w3-orange w3-hover-deep-orange btnBox"
										 id="wrbtn">글 수 정</span>
							</div>
						</form>
					</div>
		</div>
	</body>
</html>