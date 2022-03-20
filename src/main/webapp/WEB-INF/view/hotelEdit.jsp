<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Hotel Edit FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="hotelEdit">
    <form:hidden path="hotelCode"/>
    Name <form:input path="name"/>
    <br><br>
    City <form:input path="city"/>
    <br><br>
    Tours: <br>
    <c:forEach var="tour" items="${allTours}">
        <p>${tour.tourNumber}. ${tour.name}</p>
    </c:forEach>
    <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter number of Tour"/>
    <br><br>
    Hotel Classes:
    <c:forEach var="hotelClass" items="${allHotelClasses}">
        <p>${hotelClass.id}. ${hotelClass.hotelClassEnum}</p>
    </c:forEach> <br>
    <input type="number" id="hotelClassNumber" name="hotelClassNumber" placeholder="Enter id of Hotel Class"/>
    <br><br>
    <input type="submit" value="Update"/>
</form:form>
</body>
</html>