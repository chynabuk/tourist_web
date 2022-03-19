<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL TOURISTS</h2>
<br>
<br>
<table>
    <tr>
        <th>Passport number</th>
        <th>Full name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="tour" items="${tourists}">
        <tr>
            <td> ${tour.passportNumber}</td>
            <td> ${tour.fullName}</td>
            <td> ${tour.address}</td>
            <td> ${tour.age}</td>
            <td>
                <form:form action="delete/${tour.passportNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="passportNumber" name="passportNumber" value="${tour.passportNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/tourist/add"> Add new Tourist</a>
</body>