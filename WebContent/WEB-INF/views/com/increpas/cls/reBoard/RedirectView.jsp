<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/jspcls/css/w3.css">
	<link rel="stylesheet" type="text/css" href="/jspcls/css/cls.css">
	<script type="text/javascript" src="/jspcls/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/jspcls/js/"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#frm').submit();
		});
	</script>
	</head>

	<body>
		<form method="POST" action="/cls/reBoard/reBoardList.cls" id="frm">
			<input type="hidden" name="nowPage" value="${param.nowPage}">
			<input type="hidden" name="avatar" value="${param.avatar}">
		</form>
		
		<!--
		<c:redirect url="/reBoard/reBoardList.cls">
			<c:param name="nowPage" value="${param.nowPage}"/>
		</c:redirect>
		
		겟방식으로 넘어가더라~
		-->
	
	</body>
</html>