<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Avia Tickets</h2>
<br>
<br>
<table>
    <tr>
        <th>Avia ticket code</th>
        <th>Place</th>
        <th>Avia Class</th>
        <th>Avia Company</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="at" items="${aTickets}">
        <tr>
            <td> ${at.aviaTicketCode}</td>
            <td> ${at.place}</td>
            <td> ${at.aviaClass.aviaClassEnum}</td>
            <td> ${at.tourFlight.aviaCompany}</td>
            <td>
                <form:form action="delete/${at.aviaTicketCode}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="aviaTicketCode" name="aviaTicketCode" value="${at.aviaTicketCode}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/aviaTicket/add"> Add new Avia Ticket</a>
</body>