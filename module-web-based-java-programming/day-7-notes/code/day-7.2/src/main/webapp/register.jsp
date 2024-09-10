<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head> 
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="user"/>
<%--Invoke B.L from JB --%>
<body>
<h4>Route : ${sessionScope.user.registerUser()}</h4>
<a href="login.jsp">Log In</a>
</body>
<%
session.invalidate();
%>
</html>