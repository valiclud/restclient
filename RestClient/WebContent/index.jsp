<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/ludvik.tld" prefix="lud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Gemalto login page</title>
<script type="text/javascript" src="simpleValidation.js"></script>
</head>
<body>
	<h1>Welcome to Gemalto login page</h1>
	<br />
	<br />
	<br />
	<form name="authForm " action="AuthenticateServlet" method="post"
		onsubmit="return validateForm(this);">
		Please enter your Username: <input type="text" name="username"
			size="20px"> <br /> Please enter your Password: <input
			type="password" name="password" size="20px"> <br /> <input
				type="submit" value="submit">
	</form>

	<form method="post" action="AuthenticateServlet"
		enctype="multipart/form-data">
		File: <input type="file" name="file" id="file" /> <br />
		Destination: <input type="text" value="/tmp" name="destination" /> <br />
		<input type="submit" value="Upload" name="upload" id="upload" />
	</form>
	<br />
	<br />
	<a href="AuthenticateServlet">klikni na error</a>
	<br />
	<p>
		Current date is:
		<lud:currentDate />
	</p>
	<br />
	<p>
		Current time is:
		<lud:currentTime />
	</p>
	<br />
	<lud:ifWeekday>
		<p>We are in working week day</p>
	</lud:ifWeekday>

	<br />
	<p>
		<lud:ifEmptyMark color='blue' field="" />
		require field
	</p>
	<br />

	<lud:car>
		<table>
			<tr valign="top" bgcolor="blue">
				<td><%=pageContext.getAttribute("name")%></td>
				<td><%=pageContext.getAttribute("immatriculation")%></td>
				<td><%=pageContext.getAttribute("prodDate")%></td>
				<td><%=pageContext.getAttribute("kms")%></td>
			</tr>
		</table>
	</lud:car>



</body>
</html>