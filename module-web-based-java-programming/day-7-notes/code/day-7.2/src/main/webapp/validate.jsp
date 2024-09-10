<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="user"/>
<%--Invoke B.L from JB --%>
<h4>Route : ${sessionScope.user.authenticateUser()}</h4>
<%session.invalidate();%>
<body>
	<a href="redirect.jsp">Re0000</a>
</body>
</html>