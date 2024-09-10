<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="user" />
<%--Invoke B.L from JB --%>
<%-- <h4>Next page  : ${sessionScope.user.authenticateUser()}</h4> --%>
<%--redirect the clnt to the next page in the NEXT request --%>
<c:redirect url="${sessionScope.user.authenticateUser()}.jsp" />
<body>

</body>
</html>