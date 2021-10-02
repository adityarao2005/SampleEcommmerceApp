<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="admin/styles.jsp"></jsp:include>
</head>
<body class="animsition">
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="#"> <img src="resources/images/icon/logo.png" alt="CoolAdmin">
							</a>
						</div>

						<c:if test="${errors.size() > 0}">
							<h2>Errors</h2>
							<c:forEach var="error" items="${errors}">
								<div class="alert alert-danger alert-dismissible fade show">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Error:</strong> ${error}
								</div>
							</c:forEach>
						</c:if>

						<!-- TODO: Use CoolAdmin for styles -->

						<div class="login-form">
							<form action="" method="post">
								<div class="form-group">
									<label>Email Address</label> <input
										class="au-input au-input--full" type="email" name="email"
										placeholder="Email">
								</div>
								<div class="form-group">
									<label>Password</label> <input class="au-input au-input--full"
										type="password" name="password" placeholder="Password">
								</div>
								<div class="login-checkbox">
									<label> <input type="checkbox" name="remember">Remember
										Me
									</label> <label> <a href="forgot-password">Forgotten Password?</a>
									</label>
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">sign in</button>
								<!-- <div class="social-login-content">
									<div class="social-button">
										<button class="au-btn au-btn--block au-btn--blue m-b-20">sign
											in with facebook</button>
										<button class="au-btn au-btn--block au-btn--blue2">sign
											in with twitter</button>
									</div>
								</div> -->
							</form>
							<div class="register-link">
								<p>
									Don't you have account? <a href="register">Sign Up Here</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="admin/scripts.jsp"></jsp:include>
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