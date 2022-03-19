<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Event Tickets</h2>
<br>
<br>
<table>
    <tr>
        <th>Ticket Number</th>
        <th>Event name</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="et" items="${eTickets}">
        <tr>
            <td> ${et.ticketNumber}</td>
            <td> ${et.event.name}</td>
            <td>
                <form:form action="delete/${et.ticketNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="ticketNumber" name="ticketNumber" value="${et.ticketNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/eventTicket/add"> Add new Ticket for Event</a>
</body>