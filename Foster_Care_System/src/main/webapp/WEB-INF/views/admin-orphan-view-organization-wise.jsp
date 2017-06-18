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
<form action="${contextPath}/orphan/orphan_view_Orphans.htm"
		onsubmit="return validate()" name="myForm" method="post">
<h1>Here are the search results</h1>
			you searched for:
			
			<table class="table table-striped">
				<tr>
					<td></td>
					
					
					<td>Orphan Name</td>
					<td>Orphan Date of Birth</td>
					<td>Gender</td>
					<td>Adoption Status</td>
				</tr>
				<c:forEach items="${orphanList}" var="oList">
					<tr>
						
						<td><input type="radio" name="orphanid" 
						value="${oList.personid}" /></td>
						<td>${oList.firstname}</td>
						<td>${oList.dob}</td>
						<td>${oList.gender}</td>
						
						<td>${oList.currentstatus}</td>
						
					</tr>
				</c:forEach>
			</table>
			<input type="submit" class="btn btn-info" value="Submit">
	</form>
	</body>
	</html>