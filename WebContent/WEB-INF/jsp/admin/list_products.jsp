<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${products.isEmpty()}">
		<h2>The amount of products are empty.</h2>
	</c:when>
	<c:otherwise>
		<table id="products"
			class="table table-borderless table-striped table-earning">
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Number in Stock</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr id="${product.productID}">
						<td><img src="${product.image}" alt="Image not found" class="img-thumbnail" width="200" height="200"/></td>
						<td class="editable p-name">${product.name}</td>
						<td class="editable p-desc">${fn:substring(product.description, 0, 50)}</td>
						<td class="editable p-pr">
									<fmt:formatNumber type="currency" currencySymbol="$"
										maxFractionDigits="2" value="${product.price}"></fmt:formatNumber></td>
						<td class="editable p-no">${product.numberInStock}</td>
						<!-- TODO use confirm modal bootstrap to delete -->
						<td><i class="fas fa-edit mr-3 "></i><i
							class="fas fa-trash-alt delete"></i></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
