<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color: red;">${sessionScope.mesg }</h5>
	<spring:url var="url" value="/players/add" />
	<form:form action="${url}" method="post" modelAttribute="player">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Select Team</td>
				<td><form:select path="myTeam.abbreviation">
						<c:forEach var="abbr" items="${requestScope.teams_abbr}">
							<option value="${abbr}">${abbr}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Select DoB</td>
				<td><form:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><form:input type="number" value="0.00" step="0.01"
						path="battingAvg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><form:input type="number" path="wicketsTaken" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form:form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>