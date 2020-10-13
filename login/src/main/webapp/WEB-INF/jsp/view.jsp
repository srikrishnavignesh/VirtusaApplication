<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student list</title>
</head>
<body>
	<h1>Student list</h1>
	<form action = "individualreport">
	<c:forEach items="${name}" var="uname">	
		<input type="radio" name="uname" value="${uname}">${uname}<br/>
	</c:forEach>
	<input type="submit" value="view report"/>
	</form>
</body>
</html>
