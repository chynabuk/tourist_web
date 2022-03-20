<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>ALL Hotels</h2>
<br>
<br>
<table>
  <tr>
    <th>City</th>
    <th>Name</th>
    <th>Tour Number</th>
    <th>Hotel Class</th>
    <th>Country</th>
    <th>Tour Type</th>
    <th>Start Date</th>
    <th>End Date</th>
    <th>Program number</th>
    <th>Update</th>
  </tr>
  <c:forEach var="hotel" items="${hotels}">
    <tr>
      <td> ${hotel.city}</td>
      <td> ${hotel.name}</td>
      <td> ${hotel.tour.tourNumber}</td>
      <td> ${hotel.hotelClass.hotelClassEnum}</td>
      <td> ${hotel.tour.country.countriesEnum}</td>
      <td> ${hotel.tour.tourType.tourTypeEnum}</td>
      <td> ${hotel.tour.startDate}</td>
      <td> ${hotel.tour.endDate}</td>
      <td> ${hotel.tour.program.programNumber}</td>
      <td>
        <form:form action="delete/${hotel.hotelCode}"><button type="submit">Delete</button></form:form>
      </td>
      <td>
        <form:form action="edit">
          <input hidden type="number" id="hotelCode" name="hotelCode" value="${hotel.hotelCode}"/>
          <button type="submit">Edit</button></form:form>
      </td>
    </tr>
  </c:forEach>
</table>

<a href="/hotel/add"> Add new Hotel</a> <br><br>
<a href="/hotelNumber/get-all">Rooms for hotel</a>
</body>