<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--session.getAttribute("user").getUserDetails().getFirstName() sent to clnt --%>
	<h5>Hello , ${sessionScope.user.userDetails.firstName}
		${sessionScope.user.userDetails.lastName}, logged in under
		${sessionScope.user.userDetails.role} role</h5>
	<h5>
		<a href="logout.jsp">Admin Log Out</a>
	</h5>
</body>
</html>