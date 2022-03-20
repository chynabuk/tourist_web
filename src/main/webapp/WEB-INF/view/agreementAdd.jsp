<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Agreement ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="agreementAdd">
    Agreement number <form:input path="agreementNumber"/>
    <br><br>
    Date of registration <form:input type="date" path="formalizationDate"/>
    <br><br>
    Clients: <br>
    <c:forEach var="client" items="${clients}">
        <p>${client.clientNumber}. ${client.name}</p>
    </c:forEach> <br>
    <input type="number" id="clientNumber" name="clientNumber" placeholder="Enter Client Number"/>
    <br><br>
    Tours:
    <c:forEach var="tour" items="${tours}">
        <p>${tour.tourNumber}. ${tour.name}</p>
    </c:forEach> <br>
    <input type="number" id="tourNumber" name="tourNumber" placeholder="Enter Tour Number"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>