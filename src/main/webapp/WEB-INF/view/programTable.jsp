<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Programs</h2>
<br>
<br>
<table>
    <tr>
        <th>Program number</th>
        <th>Description</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="prog" items="${programs}">
        <tr>
            <td> ${prog.programNumber}</td>
            <td> ${prog.description}</td>
            <td>
                <form:form action="delete/${prog.programNumber}"><button type="submit">Delete</button></form:form>
            </td>
            <td>
                <form:form action="edit">
                    <input hidden type="number" id="programNumber" name="programNumber" value="${prog.programNumber}"/>
                    <button type="submit">Edit</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/program/add"> Add new Program</a> <br><br>

</body>