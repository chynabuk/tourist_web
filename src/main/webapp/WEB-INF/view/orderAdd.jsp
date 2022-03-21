<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Order ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="orderAdd">
    Order number <form:input path="orderNumber"/>
    <br><br>
    Tours: <br>
    <c:forEach var="tour" items="${tours}">
        <p>${tour.tourNumber}. ${tour.name}</p>
    </c:forEach> <br>
    <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter Tour Number"/>
    <br><br>
    Employees:
    <c:forEach var="empl" items="${empls}">
        <p>${impl.passportNumber}. ${empl.fullName}</p>
    </c:forEach> <br>
    <input type="number" id="passportNumber" name="passportNumber" placeholder="Enter Passport Number"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>