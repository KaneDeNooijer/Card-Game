<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Card Game - WebApp edition</title>
	
	<!-- Favicon -->
	<link rel="icon" href="images/favicon.png">
	
	<!-- Bootstrap 5 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>

	<div class="position-absolute top-50 start-50 translate-middle">
		<a href='<s:url action="setup" />'>Start</a>
	</div>
	
	<!-- Bootstrap 5 JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>