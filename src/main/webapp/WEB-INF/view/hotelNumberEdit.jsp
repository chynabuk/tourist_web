<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Hotel Number Edit FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="hotelNumberEdit">
    <form:hidden path="hotelNumberCode"/>
    Place <form:input path="place"/>
    <br><br>
    Arrival Date <form:input type="date" path="arrivalDate"/>
    <br><br>
    Departure Date <form:input type="date" path="departureDate"/>
    <br><br>
    Hotels: <br>
    <c:forEach var="hotel" items="${hotels}">
        <p>${hotel.hotelCode}. ${hotel.name}</p>
    </c:forEach> <br>
    <input type="number" id="hotelCode" name="hotelCode" placeholder="Enter Hotel code"/>
    <br><br>
    Hotel Number Categories:
    <c:forEach var="categories" items="${hotelCategories}">
        <p>${categories.id}. ${categories.hotelNumberCategoryEnum}</p>
    </c:forEach> <br>
    <input type="number" id="hotelNumberCategoryId" name="hotelNumberCategoryId" placeholder="Enter Hotel Number Category Id"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>