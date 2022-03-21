<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>Avia Ticket Permits</h2>
<br>
<br>
<table>
    <tr>
        <th>Place</th>
        <th>Flight code</th>
        <th>Avia company</th>
        <th>Tourist Passport number</th>
        <th>Tourist Address</th>
        <th>Tourist Name</th>
        <th>Tour Number</th>
        <th>Agreement Registration Date</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="avia" items="${avitTicketPermits}">
        <tr>
            <td> ${avia.aviaTicket.place}</td>
            <td> ${avia.aviaTicket.tourFlight.flightCode}</td>
            <td> ${avia.aviaTicket.tourFlight.aviaCompany}</td>
            <td> ${avia.permit.tourist.passportNumber}</td>
            <td> ${avia.permit.tourist.address}</td>
            <td> ${avia.permit.tourist.fullName}</td>
            <td> ${avia.aviaTicket.tourFlight.tour.tourNumber}</td>
            <td> ${avia.permit.agreement.formalizationDate}</td>
            <td>
                <form:form action="delete/${avia.aviaTickedPermitCode}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="aviaTickedPermitCode" name="aviaTickedPermitCode" value="${avia.aviaTickedPermitCode}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/aviaTicketPermit/add"> Add new Avia Ticket Permit</a>
</body>