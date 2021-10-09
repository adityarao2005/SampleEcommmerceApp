<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Shop Page- Ustora Demo</title>


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
							<i class="fa fa-shopping-cart"></i> <span class="product-count">
								<%-- ${session.user.cart.products.size()} --%> 5
						</span></a>
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
						<li class="active"><a href="${pageContext.request.contextPath}/shop">Shop page</a></li>
						<li><a href="cart">Cart</a></li>
						<li><a href="checkout.html">Checkout</a></li>
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
				<c:forEach var="product" items="${products}">
					<div class="col-md-3 col-sm-6">
						<div class="single-shop-product">
							<div class="product-upper">
								<img src="${product.image}" style="height:200px;width:auto" alt="Image not found">
							</div>
							<h2>
								<a href="product/${product.productID}">${product.name}</a>
							</h2>
							<div class="product-carousel-price">
								<ins>
									<fmt:formatNumber type="currency" currencySymbol="$"
										maxFractionDigits="2" value="${product.price}"></fmt:formatNumber>
								</ins>
								<!-- <del>$999.00</del> -->
							</div>

							<div class="product-option-shop">
								<a class="add_to_cart_button" data-quantity="1"
									data-product_sku="" data-product_id="70" rel="nofollow" onclick="addProduct('${product.productID}')">Add to cart</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="product-pagination text-center">
						<nav aria-label="...">
							<ul class="pagination">
								<c:choose>
									<c:when test="${page == 1 && lastPageNumber > 2}">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="shop?page=1">1</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=2">2</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=3">3</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page + 1}">Next</a></li>
									</c:when>
									<c:when test="${page == lastPageNumber && lastPageNumber > 2}">
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">Previous</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 2}">${lastPageNumber - 2}</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">${lastPageNumber - 1}</a></li>
										<li class="page-item active" aria-current="page"><span
											class="page-link"> ${lastPageNumber} <span
												class="sr-only">(current)</span>
										</span></li>
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Next</a></li>
									</c:when>
									<c:when test="${page == 1 && lastPageNumber > 1}">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="shop?page=1">1</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=2">2</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page + 1}">Next</a></li>
									</c:when>
									<c:when test="${page == lastPageNumber && lastPageNumber > 1}">
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">Previous</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">${lastPageNumber - 1}</a></li>
										<li class="page-item active" aria-current="page"><span
											class="page-link"> ${lastPageNumber} <span
												class="sr-only">(current)</span>
										</span></li>
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Next</a></li>
									</c:when>
									<c:when test="${page == lastPageNumber}">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><span
											class="page-link"> ${lastPageNumber} <span
												class="sr-only">(current)</span>
										</span></li>
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Next</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">Previous</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page - 1}">${page - 1}</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="shop?page=1">1</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page + 1}">${page + 1}</a></li>
										<li class="page-item"><a class="page-link"
											href="shop?page=${page + 1}">Next</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
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
	
	<script>
		function addProduct(productID) {
			$.ajax({
				url : "${pageContext.request.contextPath}/cart",
				type : "post",
				data : "product_id" + "=" + productID,
				success : function () {
					alert("success");
				},
				error: function () {
					alert("error");
				}
			});
		}
	</script>
</body>
</html>