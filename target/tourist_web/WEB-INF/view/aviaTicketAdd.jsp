<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Avia Ticket ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="aTicketAdd">
    Avia Ticket Code <form:input path="aviaTicketCode"/>
    <br><br>
    Place <form:input path="place"/>
    <br><br>
    Avia Classes: <br>
    <c:forEach var="ac" items="${avClasses}">
        <p>${ac.id}. ${ac.aviaClassEnum}</p>
    </c:forEach> <br>
    <input type="number" id="aviaClassId" name="aviaClassId" placeholder="Enter id of Avia class"/>
    <br><br>
    Tour Flights:
    <c:forEach var="tf" items="${tFlights}">
        <p>${tf.flightCode}. ${tf.aviaCompany}</p>
    </c:forEach> <br>

    <input type="number" id="flightCode" name="FlightCode" placeholder="Enter flightCode of Tour Flight"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>