<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Clients</h2>
<br>
<br>
<table>
    <tr>
        <th>Client number</th>
        <th>Full name</th>
        <th>Address</th>
        <th>Phone number</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="client" items="${allClients}">
        <tr>
            <td> ${client.clientNumber}</td>
            <td> ${client.name}</td>
            <td> ${client.address}</td>
            <td> ${client.phoneNumber}</td>
            <td>
                <form:form action="delete/${client.clientNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="clientNumber" name="clientNumber" value="${client.clientNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/client/add"> Add new Client</a>
</body>