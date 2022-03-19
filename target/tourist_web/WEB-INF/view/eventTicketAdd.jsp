<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Event Ticket ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="eTicketAdd">
    Ticket number <form:input path="ticketNumber"/>
    <br><br>
    Events: <br>
    <c:forEach var="ev" items="${events}">
        <p>${ev.id}. ${ev.name}</p>
    </c:forEach>
    <br><br>
    Event id <input type="number" id="eventId" name="eventId" placeholder="Enter id of Event"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>