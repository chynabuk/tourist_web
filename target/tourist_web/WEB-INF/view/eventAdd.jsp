<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Event ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="eventAdd">
    Name <form:input path="name"/>
    <br><br>
    City <form:input path="city"/>
    <br><br>
    Event place <form:input path="eventPlace"/>
    <br><br>
    Date <form:input type="date" path="date"/>
    <br><br>
    Tours: <br>
    <c:forEach var="tour" items="${allTours}">
        <p>${tour.tourNumber}. ${tour.name}</p>
    </c:forEach>
    <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter number of Tour"/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>