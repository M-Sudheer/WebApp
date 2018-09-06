<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form action="update" method="post" modelAttribute="user">
<table>

<tr>
<td>user_id</td>
<td><springform:input path="user_id" type="hidden"/></td>
</tr>

<tr>
<td>UserName:</td>
<td><springform:input path="name"/></td>
</tr>



<tr>
<td>Email:</td>
<td><springform:input path="email"/></td>
</tr>

<tr>
<td>Mobile Number:</td>
<td><springform:input path="mobile"/></td>
</tr>

<tr>
<td>Company Name</td>
<td><springform:input path="companyName"/></td>
</tr>

<tr>
<td>Role Name:</td>
<td><springform:input path="role"/></td>
</tr>

<tr>
<td>password</td>
<td><springform:input path="password" type="hidden"/></td>
</tr>


<tr>
<td><input type="submit" value="Update"></td>
</tr>

</table>
</springform:form>
</body>
</html>