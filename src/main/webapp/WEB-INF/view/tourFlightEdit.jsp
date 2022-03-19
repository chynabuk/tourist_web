<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Tour Flight ADD FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="tFlightEdit">
   <form:hidden path="flightCode"/>
   Avia company <form:input path="aviaCompany"/>
   <br><br>
   Departure date <form:input type="date" path="departureDate"/>
   <br><br>
   Departure city <form:input path="departureCity" />
   <br><br>
   Arrival city <form:input path="arrivalCity" />
   <br><br>
   Direction <form:input path="direction"/>

   <c:forEach var="tour" items="${allTours}">
      <p>${tour.tourNumber}. ${tour.name}</p>
   </c:forEach>
   <br><br>
   Tour number <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter id of Tour number"/>
   <br><br>
   <input type="submit" value="Update"/>
</form:form>
</body>
</html>