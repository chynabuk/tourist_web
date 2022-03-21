<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Avia ticket permit ADD FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="aviaTicketPermitEdit">
    <form:hidden path="aviaTickedPermitCode"/>
    <br><br>
    Avia tickets: <br>
    Ticket number   Place <br>
    <c:forEach var="ticket" items="${aviaTickets}">
        <p>${ticket.aviaTicketCode}. ${ticket.place}</p>
    </c:forEach> <br>
    <input type="number" id="aviaTicketCode" name="aviaTicketCode" placeholder="Enter avia Ticket Code"/>
    <br><br>
    Permits (permit number):
    <c:forEach var="per" items="${permits}">
        <p>${per.permitNumber}</p>
    </c:forEach> <br>
    <input type="number" id="permitNumber" name="permitNumber" placeholder="Enter Permit Number"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>