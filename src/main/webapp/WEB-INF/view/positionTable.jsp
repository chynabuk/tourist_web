<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Positions</h2>
<br>
<br>
<table>
    <tr>
        <th>Position</th>
    </tr>
    <c:forEach var="pos" items="${allPos}">
        <tr>
            <td> ${pos.positionType}</td>
        </tr>
    </c:forEach>
</table>

<a href="/employee/add-form"> Add new Position</a>
</body>