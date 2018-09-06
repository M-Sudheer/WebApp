<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
    <spring:url value="/resources/images/" var="images"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%-- <img src="${images}pro.png">  --%>
<h1>Welcome to ur Profile</h1>
<form>
<table>
<tr>
<td>UserName:</td>
<td>${user.name}</td>
</tr>
<tr>
<td>Email:</td>
<td>${user.email}</td>
</tr>
<tr>
<td>Mobile Number:</td>
<td>${user.mobile}</td>
</tr>
<tr>
<td>Company Name:</td>
<td>${user.companyName}</td>
</tr>
<tr>
<td>Role Name:</td>
<td>${user.role}</td>
</tr>
</table>
</form>
<button><a href="edit">Edit</a></button>
</body>
</html>