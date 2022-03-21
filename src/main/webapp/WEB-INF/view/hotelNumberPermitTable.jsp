<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>Hotel Number Permits</h2>
<br>
<br>
<table>
    <tr>
        <th>Hotel City</th>
        <th>Hotel Name</th>
        <th>Arrival Date</th>
        <th>Passport Number</th>
        <th>Hotel Number Category</th>
        <th>Tourist Address</th>
        <th>Tourist Name</th>
        <th>Tour Number</th>
        <th>Agreement Registration Date</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="hnp" items="${hotelNumberPermits}">
        <tr>
            <td> ${hnp.hotelNumber.hotel.city}</td>
            <td> ${hnp.hotelNumber.hotel.name}</td>
            <td> ${hnp.hotelNumber.arrivalDate}</td>
            <td> ${hnp.permit.tourist.passportNumber}</td>
            <td> ${hnp.hotelNumber.hotelNumberCategory.hotelNumberCategoryEnum}</td>
            <td> ${hnp.permit.tourist.address}</td>
            <td> ${hnp.permit.tourist.fullName}</td>
            <td> ${hnp.hotelNumber.hotel.tour.tourNumber}</td>
            <td> ${hnp.permit.agreement.formalizationDate}</td/>
            <td>
                <form:form action="delete/${hnp.hotelNumberPermitCode}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="hotelNumberPermitCode" name="hotelNumberPermitCode" value="${hnp.hotelNumberPermitCode}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/hotelNumberPermit/add"> Add new Hotel Number Permit</a>
</body>