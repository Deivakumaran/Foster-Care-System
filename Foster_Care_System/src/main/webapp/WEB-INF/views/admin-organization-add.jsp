<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
        <script>
            function validate(){
         
            }
        </script>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


        <h1>Welcome to Add Organization </h1>
        <h3>Please Enter the Organization Details below :</h3>
       
	<form:form id="myForm" action="${contextPath}/admin/organization_add.htm" onsubmit="return validate()" commandName="organization"  method="post">

		<table>
		<tr>
				<td>Organization Name:</td>
				<td><form:input path="organizationname" size="30" required="required" />
					<font color="red"><form:errors path="organizationname" /></font></td>
			</tr>
				
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
	
			<tr>
			<td>Phone Number:</td>
				<td><form:input id="pnumber" path="phonenumber" size="30" required="required" />
					<font color="red"><form:errors path="phonenumber" /></font></td>
			</tr>

			

			<tr>
				<td>Email Id:</td>
				<td><form:input path="email.emailaddress" size="30"
						type="email" required="required" /> <font color="red"><form:errors
							path="email.emailaddress" /></font></td>
			</tr>
			<tr>
				<td>Address Street:</td>
				<td><form:input path="address.street" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.street" /></font></td>
			</tr>
			<tr>
				<td>Address City:</td>
				<td><form:input path="address.city" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.city" /></font></td>
			</tr>
			<tr>
				<td>Address State:</td>
				<td><form:input path="address.state" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.state" /></font></td>
			</tr>
			<tr>
				<td>Address Country:</td>
				<td><form:input path="address.country" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.country" /></font></td>
			</tr>
			<tr>
				<td>Address Zip Code:</td>
				<td><form:input path="address.zip" size="30"
						type="address" required="required" /> <font color="red"><form:errors
							path="address.zip" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Register Organization" /></td>
			</tr>
		</table>

	</form:form>
	
    </body>
</html>
	