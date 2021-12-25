<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Address</h1>

	<form method="post">

		<label>Select Country</label>
		<jsp:include page="include/countries.jsp" /><br /> <label>Enter
			State</label> <input type="text" name="state" required /><br /> <label>Enter
			City</label> <input name="city" required /><br /> <label>Enter
			Street</label> <input name="street-no" type="number"
			placeholder="Street Number" required /><input name="street"
			placeholder="Street Name" required /><br /> <label>Postal
			Code/ZIP</label> <input name="zip" required />
		<button type="submit">Submit</button>
	</form>
</body>
</html>