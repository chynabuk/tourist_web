<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL orders</h2>
<br>
<br>
<table>
    <tr>
        <th>Order Number</th>
        <th>Tour Name</th>
        <th>Employee full name</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="ord" items="${orders}">
        <tr>
            <td> ${ord.orderNumber}</td>
            <td> ${ord.tour.name}</td>
            <td> ${ord.employee.fullName}</td>
            <td>
                <form:form action="delete/${ord.orderNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="orderNumber" name="orderNumber" value="${ord.orderNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/permit/add"> Add new Permit</a> <br><br>
</body>