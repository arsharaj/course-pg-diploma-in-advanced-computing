<%@page import="dao.UserDaoImpl"%>
<%@page import="pojos.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate</title>
</head>
<body>
<%
UserDaoImpl userDao = new UserDaoImpl();
if(userDao.authenticateUser(session.getAttribute("em").toString(), session.getAttribute("pass").toString()) == null) {
	out.write("<a href='index.jsp'> Retry </a>");
} else {
	out.write("<h3>Successful Login</h3>");
}
%>
</body>
</html>