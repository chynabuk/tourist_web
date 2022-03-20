<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Hotels</h2>
<br>
<br>
<table>
    <tr>
        <th>Passport Number</th>
        <th>Name</th>
        <th>Address</th>
        <th>Tour Number</th>
        <th>Agreement Registration date</th>
        <th>Permit number</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="per" items="${permits}">
        <tr>
            <td> ${per.tourist.passportNumber}</td>
            <td> ${per.tourist.fullName}</td>
            <td> ${per.tourist.address}</td>
            <td> ${per.agreement.tour.tourNumber}</td>
            <td> ${per.agreement.formalizationDate}</td>
            <td> ${[per.permitNumber]}</td>
            <td>
                <form:form action="delete/${per.permitNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="permitNumber" name="permitNumber" value="${per.permitNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/permit/add"> Add new Permit</a> <br><br>
</body>