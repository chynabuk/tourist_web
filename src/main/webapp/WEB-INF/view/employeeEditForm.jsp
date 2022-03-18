<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>EMPLOYEE EDIT FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="empEdit">
    <form:hidden path="passportNumber"/>
    <br><br>
    Fullname <form:input path="fullName"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    1. DEPUTY_DIRECTOR
    <br>
    2. TOUR_MANAGER,
    <br>
    3. TOUR_PLANNER,
    <br>
    4. DEPUTY_MANAGER
    <br>
    <br><br>
    Position <input type="number" id="positionId" name="positionId" placeholder="Enter id of Position"/>
    <br><br>
    <button type="submit">Update</button>
</form:form>
</body>
</html>