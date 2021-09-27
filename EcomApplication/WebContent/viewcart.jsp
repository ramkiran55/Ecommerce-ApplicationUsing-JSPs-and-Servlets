<%@page import="com.wiley.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
</head>
<body>
<%!
	Double total;
	List<Product> products;
	String userId;
%>
<%
	total = (Double) session.getAttribute("total");
	products = (List<Product>) session.getAttribute("products");
	userId = (String) session.getAttribute("userId");
%>

User ID : <%=userId %><br>


Total Amount :<%=total %>
<table>
	<tr>
		<th> Product ID </th>
		<th> Product Name </th>
		<th> Product Price </th>
	<tr>
<%
	for(Product p:products)
	{
%>
	<tr>
		<td><%=p.getProductId() %></td>
		<td><%=p.getProductName() %></td>
		<td><%=p.getProductPrice() %></td>
	

<%
	}
%>
</table>
	<br>
	<br>
	<a href="http://localhost:8080/EcomApplication/checkout.jsp">CheckOut</a>
</body>
</html>