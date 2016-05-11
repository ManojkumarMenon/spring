<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:out value="${user.firstname}"></c:out> --%>
	<p>
		<label>Hi ${User.firstname}</label>
	</p>
	<table>
		<tr>User Details :-
		</tr>
		<tr>
			<td>First Name :-</td>
			<td>${User.firstname}</td>
		</tr>
		<tr>
			<td>Second Name :-</td>
			<td>${User.secondname}</td>
		</tr>
		<tr>
			<td>Username Name :-</td>
			<td>${User.username}</td>
		</tr>
	</table>

	<table>
		<tr>Spittles Details :-
		</tr>
		<tr>
			<th>ID</th>
			<th>Message</th>
			<th>Entrydate</th>
		</tr>
		<c:forEach items="${UserSpittles }" var="spittles">
			<tr>
				<td>${spittles.id}</td>
				<td>${spittles.message}</td>
				<td>${spittles.entrydate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>