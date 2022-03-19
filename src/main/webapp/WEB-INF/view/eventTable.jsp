<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL EMPLOYEES</h2>
<br>
<br>
<table>
    <tr>
        <th>Flight Code</th>
        <th>Avia Company</th>
        <th>Departure date</th>
        <th>Departure city</th>
        <th>Arrival city</th>
        <th>Direction</th>
        <th>Tour name</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="ev" items="${events}">
        <tr>
            <td> ${ev.id}</td>
            <td> ${ev.name}</td>
            <td> ${ev.eventPlace}</td>
            <td> ${ev.city}</td>
            <td> ${ev.date}</td>
            <td> ${ev.tour.name}</td>
            <td>
                <form:form action="delete/${ev.id}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="tourNumber" name="tourNumber" value="${ev.id}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/event/add"> Add new Event</a> <br><br>
<a href="/eventTicket/get-all">Tickets for event</a>
</body>