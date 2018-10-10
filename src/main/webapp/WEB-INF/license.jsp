<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>License New</title>
</head>
<body>
	<H1>New License</H1>  
	
	<form:form action = "/newLicense" method="post" modelAttribute="license">
		<p>
			<form:label path="person">Driver</form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
	        	<c:forEach items="${people}" var="person">
        			<form:option value="${person}"><c:out value="${person.first_name}"></c:out></form:option>
        		</c:forEach>
	        </form:select>
		</p>
		
		<p>
			<form:label path="state">State</form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
		<p>
		<p>
			<form:label path="expire">Expiration Date</form:label>
			<form:errors path="expire"/>
			<form:input path="expire" type="date"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>