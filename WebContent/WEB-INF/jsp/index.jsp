<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Ecommerce Project</h1>
		</div>
	</div>
	<c:choose>
		<c:when test="${auth && user.active}">
			Welcome ${user.email}
		</c:when>
		<c:when test="${auth && !user.active}">
			Welcome ${user.email}. You have recieved a verification email. To enable your account click the link in the email.
		</c:when>
		<c:otherwise>
			<a href="login">Login</a>
			<br>
			<a href="register">Register</a>
			<br>
		</c:otherwise>
	</c:choose>
</body>
</html>