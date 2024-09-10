<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Emp List</caption>
		<tr>
		<th>Emp ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Salary</th>
		<th>Adhaar Card No</th>
		<th>Dept</th>
		<th>Dept Location</th>
		
		</tr>
		<c:forEach var="emp" items="${requestScope.emp_list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.salary}</td>
				<td>${emp.card.cardNumber}</td>
				<td>${emp.myDept.name}</td>
				<td>${emp.myDept.location}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>