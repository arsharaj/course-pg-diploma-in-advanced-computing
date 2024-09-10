<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>from 1st page ....</h4>
	<%
	out.flush();
	int productId = Integer.parseInt(request.getParameter("pid"));
	double productPrice = Double.parseDouble(request.getParameter("price"));
	request.setAttribute("product_dtls", productId + "@" + productPrice);
	//add attribute under curnt page
	pageContext.setAttribute("nm", 1234);
	%>
	<jsp:include page="test8.jsp">
		<jsp:param value="books" name="category" />
	</jsp:include>
	<h4>Contents post include ....</h4>
</body>
</html>