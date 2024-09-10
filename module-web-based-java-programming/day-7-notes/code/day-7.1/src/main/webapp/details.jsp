<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>User login Successful !!!!</h4>
	<h5>Validated User Details : ${sessionScope.user_dtls}</h5>
	<h5>
		<a href="logout.jsp">Log Out</a>
	</h5>
</body>
</html>