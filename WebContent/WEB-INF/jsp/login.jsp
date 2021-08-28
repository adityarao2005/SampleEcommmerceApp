<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h1>Login</h1>

	<c:if test="${errors.size() > 0}">
		<h2>Errors</h2>
		<c:forEach var="error" items="${errors}">
			<div class="alert alert-danger alert-dismissible fade show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Error:</strong> ${error}
			</div>
		</c:forEach>
	</c:if>


	<form method="POST">
		<div class="form-group">
			<label for="email">Email address:</label> <input name="email"
				id="email" type="email" class="form-control"
				placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password"
				name="password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<a href="forgot-password">Forgot Password</a>

	<script>
		$(function() {
			$("form").validate({
				rules : {
					email : {
						required : true,
						email : true,

					},
					password : {
						required : true
					}
				},
				messages : {
					email : {
						required : "Email is required",
						email : "Inavlid email format",
					},
					password : {
						required : "Password is required",
					}
				}
			});
		});
	</script>
</body>
</html>