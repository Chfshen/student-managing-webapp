<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-new-style.css">
</head>
<body>

	<h1>Student Management System</h1>
	<div class="split"></div>
	<br>
	
	<div id="wrapper">
		<div id="header"><h2>Add New Student</h2></div>
	</div>
	<br>
	
	<div id="container">
		<div id="buttons">
				<input type="button" value="<<Back" onclick="window.location.href='list'"
					class="button-style"/>
				<br><br>
		</div>
		<div>
			<div class="split-short"></div>
			<br>
			<form:form action="saveNewStudent" modelAttribute="new-student" method="POST"> 
				<table>
					<tbody>
						<tr>
							<td><lable>First Name:</lable></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><lable>Last Name:</lable></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><lable>Email:</lable></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><lable></lable></td>
							<td><input type="submit" value="Confirm" class="button-style"/></td>
						</tr>
					</tbody>
				</table>
				
			</form:form>
		</div>
	</div>

</body>
</html>