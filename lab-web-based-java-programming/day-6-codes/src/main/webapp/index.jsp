<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
	<h3>Login Page</h3>
	<form action="validate.jsp" method="post">
		<table>
			<tr>
				<td> Email : </td>
				<td> <input type="email" name="em"> </td>
			</tr>
			<tr>
				<td> Password : </td>
				<td> <input type="password" name="pass"> </td>
			</tr>
			<tr> 
				<td> <input type="submit" value="Log In"> </td>
			</tr>
		</table>
	</form>
</body>
</html>