<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Hotel Number Permit ADD FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="hotelNumberPermitEdit">
    <form:hidden path="hotelNumberPermitCode"/>
    <br><br>
    Hotel Numbers: <br>
    Room Number     Hotel Name <br>
    <c:forEach var="hn" items="${hotelNumbers}">
        <p>${hn.hotelNumberCode}. ${hn.hotel}</p>
    </c:forEach> <br>
    <input type="number" id="hotelNumberCode" name="hotelNumberCode" placeholder="Enter Hotel Number Code"/>
    <br><br>
    Permits:
    <c:forEach var="per" items="${permits}">
        <p>${per.permitNumber}</p>
    </c:forEach> <br>
    <input type="number" id="permitNumber" name="permitNumber" placeholder="Enter Permit Number"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>