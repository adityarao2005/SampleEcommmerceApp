<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<!-- Title Page-->
<title>Dashboard</title>

<jsp:include page="styles.jsp"></jsp:include>
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
						<li><a
							class="${pageContext.request.contextPath}/resources/js-arrow"
							href="${pageContext.request.contextPath}/admin"> <i
								class="fas fa-tachometer-alt"></i>Dashboard
						</a></li>
						<li class="active has-sub"><a href="#"> <i
								class="fas fa-table"></i>Products
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
			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">

						<div class="row">
							<div class="col-md-12">
								<div class="overview-wrap">
									<h2 class="title-1 m-b-25">Products</h2>
									<button id="addItem" data-toggle="modal"
										data-target="#mediumModal"
										class="au-btn au-btn-icon au-btn--blue">
										<i class="zmdi zmdi-plus"></i>add item
									</button>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div id="products_container"
									class="table-responsive table--no-card m-b-40">
									<jsp:include page="list_products.jsp"></jsp:include>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12" id="pagination">
								<jsp:include page="pagination.jsp"></jsp:include></div>
						</div>

						<!-- Copyright tag -->
						<div class="row">
							<div class="col-md-12">
								<div class="copyright">
									<p>
										Copyright © 2018 Colorlib. All rights reserved. Template by <a
											href="https://colorlib.com">Colorlib</a>.
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT-->
			<!-- modal medium -->
			<div class="modal fade" id="mediumModal" tabindex="-1" role="dialog"
				aria-labelledby="mediumModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document">
					<form action="product" method="post" id="create-product"
						class="form-horizontal ajax-form">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="mediumModalLabel">Create
									Product</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div id="errors"></div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="name" class=" form-control-label">Name</label>
									</div>
									<div class="col-12 col-md-9">
										<input type="text" id="name" name="name" placeholder="Name"
											class="form-control" required="required"> <small
											class="form-text text-muted">Name of the product to
											be registered</small>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="price" class=" form-control-label">Price</label>
									</div>
									<div class="col-12 col-md-9">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroupPrepend">$</span>
											</div>
											<input type="number" id="price" name="price"
												placeholder="Price" class="form-control" required="required">
										</div>
										<small class="form-text text-muted">Price of product</small>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="description" class=" form-control-label">Description</label>
									</div>
									<div class="col-12 col-md-9">
										<textarea name="description" id="description" rows="9"
											placeholder="Description of the product" class="form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" data-dismiss="modal"
									class="btn btn-secondary">Cancel</button>
								<button id="submit" type="submit" class="btn btn-primary">Create</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- end modal medium -->
			<!-- END PAGE CONTAINER-->
		</div>
	</div>

	<jsp:include page="scripts.jsp"></jsp:include>
	<script>
		/* $("#create-product")
				.validate(
						{
							rules : {
								name : {
									required : true
								},
								price : {
									required : true,
									currency : [ "$", false ]
								}
							},
							submitHandler : function(form, e) {
								e.preventDefault();
								$
										.ajax({
											type : $(form).attr('method'),
											url : $(form).attr('action'),
											data : $(form).serialize(),
											success : function() {
												updateData();
												$(".modal:visible").modal(
														"toggle");
											},
											error : function(xhr, status) {
												var response = xhr.responseText
														.trim();
												var errors = response
														.split("\n");
												var html = "";
												for (var i = 0; i < errors.length; i++) {
													html += '<div class="alert alert-danger alert-dismissible fade show"><button type="button" class="close" data-dismiss="alert">&times;</button><strong>Error!</strong> '
															+ errors[i]
															+ '</div>';
												}
												$("#errors").html(html);
											}
										});
							}
						}); */
		function updateData() {
			$.ajax({
				type : "post",
				url : "",
				success : function(xhr) {
					$("#products_container").html(xhr);
				}
			});
			updatePagination();
		}

		function updatePagination() {
			$.ajax({
				type : "get",
				url : "products/pagination",
				data : "page=${page}",
				success : function(xhr) {
					$("#pagination").html(xhr);
				}
			});
		}

		// TODO: do this only on Create/Update/Delete operation
		$(function() {

			$('#products_container')
					.on(
							"dblclick",
							'td',
							function() {
								var originalContent = $(this).text();
								var id = $(this).parent().attr("id");
								console.log("Hi");

								$(this).addClass("cell-edit");
								$(this)
										.html(
												"<input type='text' value='"+ originalContent + "'/>");
								$(this).children().first().blur(function() {
									var val = $(this).val();

									$(this).parent().removeClass("cell-edit");
									$(this).parent().text($(this).val());
									// TODO: Save edit value in the database using ajax
								});

							});
		});
	</script>
</body>

</html>
<!-- end document-->
