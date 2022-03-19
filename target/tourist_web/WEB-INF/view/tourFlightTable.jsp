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
    <th>Flight Code</th>
    <th>Avia Company</th>
    <th>Departure date</th>
    <th>Departure city</th>
    <th>Arrival city</th>
    <th>Direction</th>
    <th>Tour name</th>
    <th>Delete</th>
    <th>Update</th>
  </tr>
  <c:forEach var="tf" items="${allTFlights}">
    <tr>
      <td> ${tf.flightCode}</td>
      <td> ${tf.aviaCompany}</td>
      <td> ${tf.departureDate}</td>
      <td> ${tf.departureCity}</td>
      <td> ${tf.arrivalCity}</td>
      <td> ${tf.direction}</td>
      <td> ${tf.tour.name}</td>
      <td>
        <form:form action="delete/${tf.flightCode}"><button type="submit">Delete</button></form:form>
      </td>
      <td>
        <form:form action="edit">
          <input hidden type="number" id="flightCode" name="flightCode" value="${tf.flightCode}"/>
          <button type="submit">Edit</button></form:form>
      </td>
    </tr>
  </c:forEach>
</table>

<a href="/tourFlight/add"> Add new Tour Flight</a>
</body>