<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Tour ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="tourAdd">
    Tour number <form:input path="tourNumber"/>
    <br><br>
    Name <form:input path="name"/>
    <br><br>
    Status <form:input path="status"/>
    <br><br>
    Start date <form:input type="date" path="startDate"/>
    <br><br>
    End date <form:input type="date" path="endDate"/>
    <br><br>
    Tour types:<br>
    <c:forEach var="tType" items="${tourTypes}">
        <p>${tType.id}. ${tType.tourTypeEnum}</p>
    </c:forEach>
    <input type="number" id="tourTypeId" name="tourTypeId" placeholder="Enter id of tour type"/>
    <br><br>
    Countries:<br>
    <c:forEach var="country" items="${countries}">
        <p>${country.id}. ${country.countriesEnum}</p>
    </c:forEach>
    <input type="number" id="countryId" name="countryId" placeholder="Enter id of country"/>
    <br><br>
    Programs:<br>
    <c:forEach var="program" items="${programs}">
        <p>${program.programNumber}. ${program.description}</p>
    </c:forEach> <br>
    <input type="number" id="programNumber" name="programNumber" placeholder="Enter number of Program"/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>