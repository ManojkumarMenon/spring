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
	<form action="/spring/Spittles">
		<c:forEach items="${spittleList}" var="spittle">
			<li><c:out value="${spittle.id}" /> <c:out
					value="${spittle.message}" /> <c:out
					value="${spittle.userid}" /> <c:out
					value="${spittle.entrydate}" /></li>
		</c:forEach>
		<table>
			<tr>
				<td><label>Enter the start value</label></td>
				<td><input name="startvalue" id="startvalue"></input></td>
			</tr>
			<tr>
				<td><label>Enter the end value</label></td>
				<td><input name="endvalue" id="endvalue"></input></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><button type="submit" id="submit">Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>