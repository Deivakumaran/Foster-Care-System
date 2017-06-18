<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  
  <script>
           
        </script>
     
     
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<a href="${contextPath}/organization/orphan_manage.htm" >Manage Orphans Home</a> <br/><br/><br/><br/>


        <h1>Welcome to Add Orphans </h1>
        <h3>Please Enter the Orphan detail below :</h3>
       
	<form:form id="myForm" action="${contextPath}/organization/orphan_add.htm" onsubmit="return validate()" commandName="orphan"  method="post" enctype="multipart/form-data" >

		Select photo: <input type="file" name="photo"/><br/>
 	
		<table>
		
			
			<tr>
				<td>First Name:</td>
				<td><form:input id="fname" path="firstname" size="30" required="required" />
					<font color="red"><form:errors path="firstname" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input id="lname" path="lastname" size="30" required="required" />
					<font color="red"><form:errors path="lastname" /></font></td>
			</tr>
	
		<tr>
				<td>Gender:</td>
				<td><form:input id="gender" path="gender" size="30" required="required" />
					<font color="red"><form:errors path="gender" /></font></td>
			</tr>
	
				
				<form:input path="currentstatus" type="hidden" size="30" value="Not-Adopted" />
					<font color="red"><form:errors path="currentstatus" /></font>


 	
			
			<tr>
			<td>Date of Birth:</td>
				<td><form:input path="dob" size="30" required="required" id="datepicker"/>
					<font color="red"><form:errors path="phonenumber" /></font></td>
			</tr>
	
			<tr>
			<td>Phone Number:</td>
				<td><form:input  id="phonenumber" path="phonenumber" size="30" required="required"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
					<font color="red"><form:errors path="phonenumber" /></font></td>
			</tr>

			

			<tr>
				<td>Email Id:</td>
				<td><form:input id="emailid" path="email.emailaddress" size="30"
						 type="email" required="required" /> <font color="red" ><form:errors
							path="email.emailaddress" /></font></td>
			</tr>
			<tr>
				<td>Address Street:</td>
				<td><form:input id="street" path="address.street" size="30"
						type="address" required="required" /> <font color="red" ><form:errors
							path="address.street" /></font></td>
			</tr>
			<tr>
				<td>Address City:</td>
				<td><form:input id ="city" path="address.city" size="30"
						type="address" required="required" /> <font color="red" ><form:errors
							path="address.city" /></font></td>
			</tr>
			<tr>
				<td>Address State:</td>
				<td><form:input id="state" path="address.state" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.state" /></font></td>
			</tr>
			<tr>
				<td>Address Country:</td>
				<td><form:input id="country" path="address.country" size="30"
						type="address" required="required" /> <font color="red" ><form:errors
							path="address.country" /></font></td>
			</tr>
			<tr>
				<td>Address Zip Code:</td>
				<td><form:input id="zipcode" path="address.zip" size="30"
						type="address" required="required" onkeypress='return event.charCode >= 48 && event.charCode <= 57' /> <font color="red" ><form:errors
							path="address.zip" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>

	</form:form>
	
    </body>
</html>
	