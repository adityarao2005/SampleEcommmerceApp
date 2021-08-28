<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">
<jsp:include page="styles.jsp"></jsp:include>
<!-- Title Page-->
<title>Dashboard</title>

</head>

<body class="animsition">
	<div class="page-wrapper">

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/images/icon/logo.png"
					alt="Cool Admin" />
				</a>
			</div>
			<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="active has-sub"><a
							class="${pageContext.request.contextPath}/resources/js-arrow"
							href="#"> <i class="fas fa-tachometer-alt"></i>Dashboard
						</a></li>
						<li><a href="admin/products"> <i class="fas fa-table"></i>Products
						</a></li>
					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->
		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<jsp:include page="header.jsp"></jsp:include>
			<!-- MAIN CONTENT-->
			<div class="main-content"></div>
			<!-- END MAIN CONTENT -->
			<!-- END PAGE CONTAINER-->
		</div>
	</div>

	<jsp:include page="scripts.jsp"></jsp:include>

</body>

</html>
<!-- end document-->
