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
	<script type="text/javascript" src="/cls/js/"></script>
	</head>

	<body>
		BoardDetail입니다
		<c:forEach var="data" items="${LIST}">
			<div>${data.body}</div>
			<div>${data.id}</div>
			<div>${data.bno}</div>
		</c:forEach>
		
	</body>
</html>