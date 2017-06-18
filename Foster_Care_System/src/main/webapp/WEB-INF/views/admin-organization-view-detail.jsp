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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div class="container center_div">
					<img src="orphan.image" alt="Angry face" width="32" height="32" />
						<div class="row">
							<label class="control-label col-sm-2" for="prog">Organization ID</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="id"
									value="${organization.organizationid}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">First Name</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.organizationname}" readonly>
							</div>
						</div>
						
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getEmail().getEmailaddress()}" readonly>
							</div>
						</div>
						
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getAddress().getStreet()}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getAddress().getCity()}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getAddress().getState()}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getAddress().getCountry()}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">email</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${organization.getAddress().getZip()}" readonly>
							</div>
						</div>
						
							<div class="row">
							<label class="control-label col-sm-2">Contact</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="contact"
									value="${organization.phonenumber}" readonly>
							</div>
						</div>
				
			
					</form>
				</div>
	</body>
	</html>
	