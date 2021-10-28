<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hunters List</title>
</head>
<body>
	<h3>Current Hunters</h3>
	<a href="addHunter">Add +</a>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Nen Affinity</th>
			<th>Occupation</th>
		</tr>
		<c:forEach items="${hunters}" var="hunter">
			<tr>
				<td>${hunter.firstName}</td>
				<td>${hunter.lastName}</td>
				<td>${hunter.nenAffinity}</td>
				<td>${hunter.occupation}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>