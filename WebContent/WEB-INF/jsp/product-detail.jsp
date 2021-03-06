<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--
	ustora by freshdesignweb.com
	Twitter: https://twitter.com/freshdesignweb
	URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product Page - Ustora Demo</title>

<jsp:include page="include/styles.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="include/header.jsp"></jsp:include>

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="./"><img
								src="${pageContext.request.contextPath}/resources/img/logo.png"></a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="cart.html">Cart - <span class="cart-amunt">$100</span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/shop">Shop page</a></li>
						<li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
						<li><a href="${pageContext.request.contextPath}/checkout/addresses">Checkout</a></li>
						<li><a href="#">Category</a></li>
						<li><a href="#">Others</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->

	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Shop</h2>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="product-content-right">
						<!-- <div class="product-breadcroumb">
							<a href="">Home</a> <a href="">Category Name</a> <a href="">Sony
								Smart TV - 2015</a>
						</div> -->

						<div class="row">
							<div class="col-sm-4">
								<div class="product-images">
									<div class="product-main-img">
										<img src="${product.image}" width="300" height="auto"
											alt="product">
									</div>
								</div>
							</div>

							<div class="col-sm-8">
								<div class="product-inner">
									<h2 class="product-name">${product.name }</h2>
									<div class="product-inner-price">
										<ins>
											<fmt:formatNumber type="currency" currencySymbol="$"
												maxFractionDigits="2" value="${product.price}"></fmt:formatNumber>
										</ins>
										<!-- <del>$100.00</del> -->
									</div>

									<form action="" class="cart">
										<div class="quantity">
											<input type="number" size="4" class="input-text qty text"
												title="Qty" value="1" name="quantity" min="1" step="1">
										</div>
										<button class="add_to_cart_button" type="submit">Add
											to cart</button>
									</form>

									<!-- 									<div class="product-inner-category">
										<p>
											Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>,
											<a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>.
										</p>
									</div> -->

									<div role="tabpanel">
										<ul class="product-tab" role="tablist">
											<li role="presentation" class="active"><a href="#home"
												aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
											<li role="presentation"><a href="#profile"
												aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
										</ul>
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane fade in active"
												id="home">
												<h2>Product Description</h2>

												<p>${product.description}</p>
											</div>
											<div role="tabpanel" class="tab-pane fade" id="profile">
												<h2>Reviews</h2>
												<div class="submit-review">
													<p>
														<label for="name">Name</label> <input name="name"
															type="text">
													</p>
													<p>
														<label for="email">Email</label> <input name="email"
															type="email">
													</p>
													<div class="rating-chooser">
														<p>Your rating</p>

														<div class="rating-wrap-post">
															<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i>
														</div>
													</div>
													<p>
														<label for="review">Your review</label>
														<textarea name="review" id="" cols="30" rows="10"></textarea>
													</p>
													<p>
														<input type="submit" value="Submit">
													</p>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="footer-top-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="footer-about-us">
						<h2>
							u<span>Stora</span>
						</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Perferendis sunt id doloribus vero quam laborum quas alias
							dolores blanditiis iusto consequatur, modi aliquid eveniet
							eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit,
							debitis, quisquam. Laborum commodi veritatis magni at?</p>
						<div class="footer-social">
							<a href="#" target="_blank"><i class="fa fa-facebook"></i></a> <a
								href="#" target="_blank"><i class="fa fa-twitter"></i></a> <a
								href="#" target="_blank"><i class="fa fa-youtube"></i></a> <a
								href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-menu">
						<h2 class="footer-wid-title">User Navigation</h2>
						<ul>
							<li><a href="">My account</a></li>
							<li><a href="">Order history</a></li>
							<li><a href="">Wishlist</a></li>
							<li><a href="">Vendor contact</a></li>
							<li><a href="">Front page</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-menu">
						<h2 class="footer-wid-title">Categories</h2>
						<ul>
							<li><a href="">Mobile Phone</a></li>
							<li><a href="">Home accesseries</a></li>
							<li><a href="">LED TV</a></li>
							<li><a href="">Computer</a></li>
							<li><a href="">Gadets</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-newsletter">
						<h2 class="footer-wid-title">Newsletter</h2>
						<p>Sign up to our newsletter and get exclusive deals you wont
							find anywhere else straight to your inbox!</p>
						<div class="newsletter-form">
							<input type="email" placeholder="Type your email"> <input
								type="submit" value="Subscribe">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-bottom-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="copyright">
						<p>
							&copy; 2015 uCommerce. All Rights Reserved. <a
								href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a>
						</p>
					</div>
				</div>

				<div class="col-md-4">
					<div class="footer-card-icon">
						<i class="fa fa-cc-discover"></i> <i class="fa fa-cc-mastercard"></i>
						<i class="fa fa-cc-paypal"></i> <i class="fa fa-cc-visa"></i>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="include/scripts.jsp"></jsp:include>
</body>
</html>