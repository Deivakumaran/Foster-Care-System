<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script>
	function doAjaxPost() {
		var query = $('#query').val();
		var data = 'query=' + encodeURIComponent(query);  //id=query
		$.ajax({
			url : '${contextPath}/organization/check_orphan.htm',
			data : data,
			type : "GET",

			success : function(response) {
				alert(response);
			}
		});
		return false;
	};
</script>
</head>
<body>
				
				<form action="${contextPath}/organization/orphan_search.htm"
					onsubmit="return validate()" name="myForm" id="sampleForm">
					
						Search  Query						
							<input type="text" id="query" name="query">
					
					 <input type="submit"  value="Search" onclick="doAjaxPost()">
				</form>
				
</body>
</html>

			
	
	