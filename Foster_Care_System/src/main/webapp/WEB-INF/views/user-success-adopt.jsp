<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome adopted Home</title>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<a href="${contextPath}/user/orphan_manage_adopt.htm">Home user Adoption</a>
<h1>Hi, you have successfully adopted following orphan</h1>

	<div class="container center_div">
					<img src="orphan.image" alt="Angry face" width="32" height="32" />
						
						
							<img src=${orphan.image}></img>
						
						<div class="row">
							<label class="control-label col-sm-2" for="prog">OrphanID</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="id"
									value="${orphan.personid}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">First Name</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="name"
									value="${orphan.firstname}" readonly>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-2" for="prog">Last Name</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="location"
									value="${orphan.lastname}" readonly>
							</div>
						</div>
						
						<div class="row">
							<label class="control-label col-sm-3" for="prog">Gender</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="username"
									value="${orphan.gender}" readonly>
							</div>
						</div>	
						<div class="row">
							<label class="control-label col-sm-2">Date of Birth</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="contact"
									value="${orphan.dob}" readonly>
							</div>
							</div>
							<div class="row">
							<label class="control-label col-sm-2">Contact</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" name="contact"
									value="${orphan.phonenumber}" readonly>
							</div>
						</div>
				
			
				
				</div>
	
</body>
</html>

