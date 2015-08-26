<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1>Error page</h1>
<font color="red">
<h2>Error message:</h2>
<c:out value="${pageContext.exception.message}"/>
<c:out value="${requestScope.failed}"/>
</font>
<h2>Error stackTrace:</h2>
<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
	<p>${trace}</p>
</c:forEach>
<br/>
<br/>
<a href="index.jsp">Back to welcome page</a>
</body>
</html>