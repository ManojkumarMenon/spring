<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" commandName="User" action="/spring/CreateUser">

		<table>
			<tr>
				<td><label>Enter the first name :-</label></td>
				<td><sf:input id="firstname" name="firstname" path="firstname"></sf:input> <sf:errors path="firstname"></sf:errors></td>
			</tr>
			<tr>
				<td><label>Enter the second name :-</label></td>
				<td><sf:input id="secondname" name="secondname" path="secondname"></sf:input><sf:errors path="secondname"></sf:errors></td>
			</tr>
			<tr>
				<td><label>Enter the username :-</label></td>
				<td><sf:input id="username" name="username" path="username"></sf:input><sf:errors path="username"></sf:errors></td>
			</tr>
			<tr>
				<td><label>Enter the password :-</label></td>
				<td><sf:input id="password" name="password" path="password"></sf:input><sf:errors path="password"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" value="submit">Create User</button></td>
			</tr>
		</table>
		<label >${message}</label>
	</sf:form>

	<sf:form method="post" commandName="User" action="/spring/Login">
		<table>
			<tr>
				<td><label path="">Enter the username :-</label></td>
				<td><sf:input id="username" path="username" name="username"></sf:input>
				<sf:errors  path="username"></sf:errors>
				</td>
			</tr>
			<tr>
				<td><label>Enter the password :-</label></td>
				<td><sf:password id="password" path ="password" name="password"></sf:password></td>
			</tr>
			<tr>
				<td></td>
				<td><sf:button type="submit" value="submit">Login</sf:button></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>