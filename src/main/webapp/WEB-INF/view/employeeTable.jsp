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
        <th>Passport number</th>
        <th>Full name</th>
        <th>Address</th>
        <th>Position</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
        <tr>
            <td> ${emp.passportNumber}</td>
            <td> ${emp.fullName}</td>
            <td> ${emp.address}</td>
            <td> ${emp.position.positionType}</td>
            <td>
                <form:form action="delete/${emp.passportNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="passportNumber" name="passportNumber" value="${emp.passportNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/employee/add-form"> Add new Employee</a>
</body>