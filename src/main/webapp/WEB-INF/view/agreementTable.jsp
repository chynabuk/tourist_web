<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>Agreeements Tickets</h2>
<br>
<br>
<table>
    <tr>
        <th>Client name</th>
        <th>Client address</th>
        <th>Tour number</th>
        <th>Registration date</th>
        <th>Agreement number</th>
        <th>Country</th>
        <th>Tour type</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Program number</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="ag" items="${agreements}">
        <tr>
            <td> ${ag.client.name}</td>
            <td> ${ag.client.address}</td>
            <td> ${ag.tour.tourNumber}</td>
            <td> ${ag.formalizationDate}</td>
            <td> ${ag.agreementNumber}</td>
            <td> ${ag.tour.country.countriesEnum}</td>
            <td> ${ag.tour.tourType.tourTypeEnum}</td>
            <td> ${ag.tour.startDate}</td>
            <td> ${ag.tour.endDate}</td>
            <td> ${ag.tour.program.programNumber}</td>
            <td>
                <form:form action="delete/${ag.agreementNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="agreementNumber" name="agreementNumber" value="${ag.agreementNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/agreement/add"> Add new Agreement</a>
</body>