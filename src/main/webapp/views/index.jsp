<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>phone book</title>
<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>

</head>
<body style=" border: solid;">
	
		<h1>Phone Book Application </h1>
	<p>
		<font color='yellow'>${succMsg }</font>
	</p>
	<p>
		<font color='red'>${errMsg }</font>
	</p>
	
	<form:form action="saveContact"
			   modelAttribute="contact" 
			   method="POST">
		<table style=" table-layout border: solid;">
			<tr>
				<form:hidden path="contactId"/>
				
				<td>Contact Name  :</td>
				<td><form:input path="contactName"/></td>
			</tr>
			
			<tr>
				<td>Contact Email :</td>
				<td><form:input path="contactEmail"/></td>
			</tr>
			
			<tr>
				<td>Contact Phone :</td>
				<td><form:input path="contactNumber"/></td>
			</tr>
			
			<tr>
				<td><input type="reset" value="Rest"></td>
				<td><input type="submit" value="Save"></td>
			</tr>
			<tr>
			</tr>
		</table>
	
	</form:form><br>
	<a href="viewContacts">View All Contacts</a>
	
</body>
</html>