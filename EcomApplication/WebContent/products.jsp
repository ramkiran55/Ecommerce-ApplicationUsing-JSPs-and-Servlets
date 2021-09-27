<%@page import="com.wiley.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>products</title>
</head>
<body>

	<%!
		List<Product> products;
		String uid;
		int count;
	%>
	<%
	uid = (String) session.getAttribute("userId");
	%>
	<form>
	<input type = "hidden" name = "userId" value = "<%=uid%>">
	</form>
	User ID: <%=uid %>
	<a href="http://localhost:8080/EcomApplication/logout.jsp">LogOut</a><br>
	<%
	count = (int) session.getAttribute("count");
	%>
	Number of product(s) in your cart are : <%=count %><br>
	<table>
		<tr>
		<th> Product ID </th>
		<th> Product Name </th>
		<th> Product Price </th>
		<th> User Action </th>
		<tr>
	<%
		
		products = (List<Product>) session.getAttribute("productList");
		for(Product p: products)
		{
	%>
		<tr>
		<form action = "AddintoCart" method="post">
		<input type = "hidden" name = "productId" value = "<%=p.getProductId()%>">
		<input type = "hidden" name = "userId" value = "<%=uid%>">
		<input type = "hidden" name = "price" value = "<%=p.getProductPrice()%>">
		<td><%=p.getProductId() %></td>
		<td><%=p.getProductName() %></td>
		<td><%=p.getProductPrice() %></td>
		<td><input type="submit" value = "add to cart"></td>
		<tr>
		</form>
	
	<%
		}
	%>
	
	</table>
	<a href="http://localhost:8080/EcomApplication/ViewCart">view cart</a>
</body>
</html>