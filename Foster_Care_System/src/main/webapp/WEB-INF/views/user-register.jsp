
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  <script>
            function validate(){
                var pnumber = document.forms["myForm"]["pnumber"].value;  
                         
                if (pnumber==0 ) {
                    alert("Please enter pnumber");
                    return false;
                }
            }
        </script>

<title>Charity Center</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="../resources/CSS/style.css" />
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


	<div id="wrapper">																																																																																																																																																<div class="inner_copy"><a href="http://ecommercebuilders.blogspot.com/2015/09/wix-ecommerce-review.html">wix ecommerce review</a></div>
		<div id="header">
			<a href="index.jsp" class="logo"><img src="../resources/images/logo.gif" width="342" height="109" /></a>																																																																																																																							
			<div id="menu">
				<ul>
					<li><a href="${contextPath}">Home page</a></li>																																																											
				
				</ul>
			</div>
			<img src="../resources/images/big_image.jpg" width="942" height="318" border="0" usemap="#Map" />
		</div>
		
	<br><br>
	<a href="${contextPath}">Go Back</a><br/>

	<h2>Register a New User</h2>

	<form:form id="myForm" action="${contextPath}/user/register.htm" onsubmit="return validate()" commandName="user"  method="post">

		
			
		<table>
		
		<tr>
				<td>User Name:</td>
				<td><form:input path="username" size="30" required="required" />
					<font color="red"><form:errors path="username" /></font></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			
			<tr>
				<td>Select Organization Name:</td>
		
		<td><form:select path="organizationtype">
		
	    <form:options items="${nameList}" />
		</form:select></td>
	
	</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstname" size="30" required="required" id="fname"/>
					<font color="red"><form:errors path="firstname" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastname" size="30" required="required" />
					<font color="red"><form:errors path="lastname" /></font></td>
			</tr>
		
		<tr>
				<td>Gender:</td>
				<td><form:input path="gender" size="30" required="required" />
					<font color="red"><form:errors path="gender" /></font></td>
			</tr>
	
	
			<tr>
			<td>Date of Birth:</td>
				<td><form:input path="dob" size="30" required="required" id="datepicker"/>
					<font color="red"><form:errors path="phonenumber" /></font></td>
			</tr>
	
			<tr>
			<td>Phone Number:</td>
				<td><form:input id="pnumber" path="phonenumber" size="30" required="required" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
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
						type="address" required="required"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'/> <font color="red"><form:errors
							path="address.zip" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>

	</form:form>
	
	<br><br><br><br><br>
	<div id="footer">																																																																																																																																																								<div class="inner_copy"><a href="http://tech.co/10-best-website-builder-platforms-for-beginners-2015-02">best website builders for beginners</a></div>
			<div id="bottom_navigation">
				<a href="index.html">Home page</a> |                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
				<a href="index2.html">About us</a> |
				<a href="index2.html">Our values</a> |
				<a href="index2.html">Our project</a> |
				<a href="index2.html">Payments</a> |
				<a href="index2.html">Contact us</a>
			</div>
			<div id="copy">
				Copyright &copy;. All rights reserved. Design by <a href="http://bestfreetemplates.info/" title="Best Free Templates" target="_blank">BFT</a>																																																																																																																																														 
			</div>
		</div>
	</div>
<map name="Map">
	<area shape="rect" coords="145,270,336,295" href="#">
</map>
	

</body>
</html>

