
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<a href="register.htm">Register a new User</a><br/>

	<h2>Login</h2>
	<form action="${contextPath}/user/login.htm" method="post">
	
		<table>
		<tr>
		    <td>User Name:</td>
		    <td><input name="username" size="30" required="required" /></td>
		</tr>
		
		<tr>
		    <td>Password:</td>
		    <td><input type="password" name="password" size="30" required="required"/></td>
		</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
				
		</table>

	</form>
	
	<br><br><br><br><br>
	
	
	<div id="footer">																																																																																																																																																								<div class="inner_copy"><a href="http://tech.co/10-best-website-builder-platforms-for-beginners-2015-02">best website builders for beginners</a></div>
		
			<div id="copy">
				Copyright &copy;. All rights reserved. </a>																																																																																																																																														 
			</div>
		</div>
	</div>
<map name="Map">
	<area shape="rect" coords="145,270,336,295" href="#">
</map>
	

</body>
</html>
