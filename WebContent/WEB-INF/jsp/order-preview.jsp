<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	</table>
	<form action="confirm-order">
		<h1>Confirm The Order</h1>
		<input type="hidden" name="cart_id" value="${cart_id}"> <input
			type="hidden" name="address_id" value="${address_id}"> <input
			type="submit" />
	</form>
</body>
</html>