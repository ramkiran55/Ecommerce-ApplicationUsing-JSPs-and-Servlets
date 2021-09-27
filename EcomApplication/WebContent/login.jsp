<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log IN</title>
</head>
<body>

	<form action = "LoginServlet">
		Email ID :<input type="text" name="email-id"><br><br>
		Password :<input type="text" name="password"><br>
		<input type="submit" value="login">
	</form>
<a href="http://localhost:8080/EcomApplication/register.jsp">register</a>
</body>
</html>