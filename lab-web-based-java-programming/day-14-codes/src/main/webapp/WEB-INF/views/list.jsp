<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>All Departments : ${requestScope.dept_list}</h4>
	<h4>List all the emps of selected department</h4>
	<c:forEach var="dept" begin="0" items="${requestScope.dept_list}">
		<a href="/emps_list">${dept.name}</a>
		<br>
	</c:forEach>
</body>
</html>