<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>EMPLOYEE ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="employee">
    Fullname <form:input path="fullName"/>
    <br><br>
    Passport number <form:input path="passportNumber"/>
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
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>