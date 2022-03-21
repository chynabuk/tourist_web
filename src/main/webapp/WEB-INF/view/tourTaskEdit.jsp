<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Tour task Edit FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="tTaskEdit">
  <form:hidden path="taskNumber"/>
  <br><br>
  Status <form:input path="status"/>
  <br><br>
  Date <form:input path="date"/>
  <br><br>
  Description <form:input path="description"/>
  <br><br>
  Tours: <br>
  <c:forEach var="tour" items="${tours}">
    <p>${tour.tourNumber}. ${tour.name}</p>
  </c:forEach> <br>
  <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter Tour Number"/>
  <br><br>
  Employees:
  <c:forEach var="empl" items="${empls}">
    <p>${impl.passportNumber}. ${empl.fullName}</p>
  </c:forEach> <br>
  <input type="number" id="passportNumber" name="passportNumber" placeholder="Enter Passport Number"/>
  <br><br>
  <input type="submit" value="Update"/>
</form:form>
</body>
</html>