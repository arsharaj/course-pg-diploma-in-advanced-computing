<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Handler Page</title>
</head>
<body>
	<h4 style="color: red;">Error Message :
		${pageContext.exception.message}</h4>
	<h4 style="color: red;">Error Details : ${pageContext.exception}</h4>
	<h4 style="color: red;">Error Code :
		${pageContext.errorData.statusCode}</h4>
	<h4 style="color: red;">URI of Err causing page
		:${pageContext.errorData.requestURI}</h4>
</body>
</html>