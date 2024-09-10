<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>From included page</h4>
	<h4>Product Details : ${requestScope.product_dtls}</h4>
	<h5> param : ${param}</h5>
	<h5>page scoped attr ${pageScope.nm}</h5>
</body>
</html>