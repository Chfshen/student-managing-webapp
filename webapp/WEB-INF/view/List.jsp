<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Student Management System</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<h1>Student Management System</h1>
	<div class="split"></div>
	<br>
	
	<div id="wrapper">
		<div id="header"><h2>List of Students</h2></div>
	</div>
	<br>
	
	<div id="container">
		<div id="buttons">
				<input type="button" value="Add New" onclick="window.location.href='addNewForm'" 
					class="button-style"/>
				<input type="button" value="Select"
					class="button-style"/>
				<br><br>
		</div>
		<div id="list">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop for listing all students -->
				<c:forEach var="temp" items="${students}">
				
					<c:url var="updateLink" value="/student/getUpdateForm">
						<c:param name="id" value="${temp.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="id" value="${temp.id}" />
					</c:url>			
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
								onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete
							</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
			<br>
			
			<div id="buttons">
				<form action="${pageContext.request.contextPath}/logout" method="POST">
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			    <input type="submit" name="logout" value="logout" />
				</form>
			</div>
		</div>
		

	</div>

</body>
</html>