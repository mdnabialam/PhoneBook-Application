<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>

<script>
		$(document).ready(function(){
			$('#contactTbl').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	

		function deleteConfirm(){
			return confirm("Are you sure,you want to Delete ? ")
		}
	</script>
</head>
<body>
	<h1>View Contacts Here</h1>
	<a href="addContact"	> + Add New Contact</a>
	<br><br>
	<table border="1" id="contactTbl">
		<thead>
			<tr>
			 <th>S.NO</th>
			 <th>NAME</th>
			 <th>EMAIL</th>
			 <th>PHONE NUMBER</th>
			 <th>ACTION</th>
			</tr>
			</thead>
		         <tbody>
					<c:forEach items="${contacts }" var="c" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${c.contactName}</td>
							<td>${c.contactEmail}</td>
							<td>${c.contactNumber}</td>
							<td>
								<a href="editContact?cid=${c.contactId}">Edit</a> |
								<a href="deleteContact?cid=${c.contactId }" onclick="deleteConfirm()" >Delete</a>
							</td>
						</tr>
					</c:forEach>
	        	</tbody>
	</table>
</body>
</html>