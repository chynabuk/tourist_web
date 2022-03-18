<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Positions</h2>
<br>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Position</th>
    </tr>
    <c:forEach var="pos" items="${allPos}">
        <tr>
            <td> ${pos.id}</td>
            <td> ${pos.positionType}</td>
        </tr>
    </c:forEach>
</table>

<a href="/position/add"> Add new Position</a>
</body>