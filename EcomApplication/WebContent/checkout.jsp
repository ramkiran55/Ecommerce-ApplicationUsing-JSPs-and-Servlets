<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="PaymentServlet">
	<input type="radio" id="Cash On Delivery" name="Payment Options" value="Cash On Delivery">
	<label for="Cash On Delivery">Cash On Delivery </label><br>
	<input type="radio" id="Credit Card" name="Payment Options" value="Credit Card">
	<label for="Credit Card">Credit Card </label><br>
	<input type="radio" id="Debit Card" name="Payment Options" value="Debit Card">
	<label for="Debit Card">Debit Card </label><br>
	
	<input type="submit" name = "Proceed">
</form>
</body>
</html>