<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Tours</h2>
<br>
<br>
<table>
    <tr>
        <th>Tour number</th>
        <th>Name</th>
        <th>Status</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Tour type</th>
        <th>Country</th>
        <th>Program</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="tour" items="${tours}">
        <tr>
            <td> ${tour.tourNumber}</td>
            <td> ${tour.name}</td>
            <td> ${tour.status}</td>
            <td> ${tour.startDate}</td>
            <td> ${tour.endDate}</td>
            <td> ${tour.tourType.tourTypeEnum}</td>
            <td> ${tour.country.countriesEnum}</td>
            <td> ${tour.program.description}</td>
            <td>
                <form:form action="delete/${tour.tourNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="tourNumber" name="tourNumber" value="${tour.tourNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/tour/add"> Add new Tour</a>
</body>