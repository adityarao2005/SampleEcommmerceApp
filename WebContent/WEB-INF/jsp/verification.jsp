<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h1>Login</h1>

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
		<div class="form-group">
			<label for="cpassword">Confirm Password:</label> <input
				type="password" class="form-control" placeholder="Confirm password"
				id="cpassword">
		</div>
		<br />
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

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
					},
					cpassword : {
						required : true,
						equalTo : "#password"
					}
				},
				messages : {
					email : {
						required : "Email is required",
						email : "Inavlid email format",
					},
					password : {
						required : "Password is required",
					},
					cpassword : {
						equalTo : "Passwords must be equal"
					}
				}
			});
		});
	</script>
</body>
</html>