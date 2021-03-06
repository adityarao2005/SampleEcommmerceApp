<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-area">
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="user-menu">
					<ul>
						<c:choose>
							<c:when test="${user != null && user.active}">
								<li><a href="#"><i class="fa fa-user"></i>
										${user.email}</a></li>
								<li><a href="${pageContext.request.contextPath}/logout"><i
										class="fa fa-sign-out"></i>Logout</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/login"><i
										class="fa fa-user"></i> Login</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
						<li><a href="cart.html"><i class="fa fa-user"></i> My
								Cart</a></li>
						<li><a href="${pageContext.request.contextPath}/checkout/addresses"><i class="fa fa-user"></i>
								Checkout</a></li>
						<li><a href="#"><i class="fa fa-shopping-cart"></i> My Orders</a></li>
					</ul>
				</div>
			</div>

			<div class="col-md-4">
				<div class="header-right">
					<ul class="list-unstyled list-inline">
						<li class="dropdown dropdown-small"><a data-toggle="dropdown"
							data-hover="dropdown" class="dropdown-toggle" href="#"><span
								class="key">currency :</span><span class="value">USD </span><b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">USD</a></li>
								<li><a href="#">INR</a></li>
								<li><a href="#">GBP</a></li>
							</ul></li>

						<li class="dropdown dropdown-small"><a data-toggle="dropdown"
							data-hover="dropdown" class="dropdown-toggle" href="#"><span
								class="key">language :</span><span class="value">English
							</span><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">English</a></li>
								<li><a href="#">French</a></li>
								<li><a href="#">German</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End header area -->
