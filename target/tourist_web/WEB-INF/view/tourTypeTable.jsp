<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Tour Types</h2>
<br>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>TourType</th>
    </tr>
    <c:forEach var="tour" items="${tourTypes}">
        <tr>
            <td> ${tour.id}</td>
            <td> ${tour.tourTypeEnum}</td>
        </tr>
    </c:forEach>
</table>

<a href="/tour/add"> Add new TourType</a>
</body>