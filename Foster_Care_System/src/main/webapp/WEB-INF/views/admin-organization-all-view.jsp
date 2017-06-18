<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form action="${contextPath}/admin/organization_select.htm"
		onsubmit="return validate()" name="myForm" method="post">
<h1>Here are the search results</h1>
			
			
			<table class="table table-striped">
				<tr>
					<td></td>
					
					
					<td>Organization ID</td>
					<td>Organization Name</td>
					<td>Organization Contact</td>
				
				</tr>
				<c:forEach items="${organizationList}" var="oList">
					<tr>
						
						<td><input type="radio" name="organizationid" 
						value="${oList.organizationid}" /></td>
						<td>${oList.organizationid}</td>
						<td>${oList.organizationname}</td>
						<td>${oList.phonenumber}</td>
						
						
					</tr>
				</c:forEach>
			</table>
			<input type="submit" class="btn btn-info" value="Submit">
	</form>
	</body>
	</html>