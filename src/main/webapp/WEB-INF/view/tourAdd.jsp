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
    1. SPORT<br>
    2. SHOP<br>
    3. SIGHTSEEING<br><br>
    <input type="number" id="tourTypeId" name="tourTypeId" placeholder="Enter id of tour type"/>
    <br><br>
    Countries:<br>
    1. Kyrgyzstan<br>
    2. Germany<br>
    3. USA<br><br>
    <input type="number" id="countryId" name="countryId" placeholder="Enter id of country"/>
    <br><br>

    Programs:<br>
    <input type="number" id="programNumber" name="programNumber" placeholder="Enter number of Program"/>

    <input type="submit" value="Save"/>
</form:form>
</body>
</html>