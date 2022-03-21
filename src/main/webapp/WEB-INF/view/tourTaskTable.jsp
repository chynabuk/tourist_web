<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL tour tasks</h2>
<br>
<br>
<table>
    <tr>
        <th>Task Number</th>
        <th>Status</th>
        <th>Date</th>
        <th>Description</th>
        <th>Tour Name</th>
        <th>Employee full name</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="tt" items="${tTasks}">
        <tr>
            <td> ${tt.taskNumber}</td>
            <td> ${tt.status}</td>
            <td> ${tt.date}</td>
            <td> ${tt.description}</td>
            <td> ${tt.tour.name}</td>
            <td> ${tt.employee.fullName}</td>
            <td>
                <form:form action="delete/${tt.taskNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="taskNumber" name="taskNumber" value="${tt.taskNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/permit/add"> Add new Permit</a> <br><br>
</body>