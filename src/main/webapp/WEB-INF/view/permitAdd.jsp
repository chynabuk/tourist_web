<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Permit ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="permitAdd">
    Permit number <form:input path="permitNumber"/>
    <br><br>
    Agreements: <br>
    <c:forEach var="ag" items="${agreements}">
        <p>${ag.agreementNumber}. ${ag.formalizationDate}</p>
    </c:forEach> <br>
    <input type="number" id="agreementNumber" name="agreementNumber" placeholder="Enter Agreement Number"/>
    <br><br>
    Tourists:
    <c:forEach var="to" items="${tourists}">
        <p>${to.passportNumber}. ${to.fullName}</p>
    </c:forEach> <br>
    <input type="number" id="passportNumber" name="passportNumber" placeholder="Enter Tourist Passport Number"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>