<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Hotel Numbers</h2>
<br>
<br>
<table>
    <tr>
        <th>City</th>
        <th>Name</th>
        <th>Arrival Date</th>
        <th>Hotel Number Category</th>
        <th>Place</th>
        <th>Departure Date</th>
        <th>Update</th>
    </tr>
    <c:forEach var="hotelNumber" items="${hotelNumbers}">
        <tr>
            <td> ${hotelNumber.hotel.city}</td>
            <td> ${hotelNumber.hotel.name}</td>
            <td> ${hotelNumber.arrivalDate}</td>
            <td> ${hotelNumber.hotelNumberCategory.hotelNumberCategoryEnum}</td>
            <td> ${hotelNumber.place}</td>
            <td> ${hotelNumber.departureDate}</td>
            <td>
                <form:form action="delete/${hotelNumber.hotelNumberCode}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="hotelNumberCode" name="hotelNumberCode" value="${hotelNumber.hotelNumberCode}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/hotelNumber/add"> Add new Hotel Number</a> <br><br>
</body>