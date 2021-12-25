<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Product Name</th>
			<th>Amount in cart</th>
			<th>Price</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.key.name}</td>
				<td>${product.value}</td>
				<td>${product.key.price * product.value}</td>
			</tr>
		</c:forEach>
	</table>
	Address ${address}
	<form action="confirm-order">
		<h1>Confirm The Order</h1>
		<input type="hidden" name="address_id" value="${address.id}">
		<input type="submit" /> <a href="addresses">Select other address</a>
	</form>
</body>
</html>