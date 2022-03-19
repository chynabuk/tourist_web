<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>EMPLOYEE EDIT FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="empEdit">

    <form:hidden path="passportNumber"/>
    <br><br>
    Fullname <form:input path="fullName"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    Positions: <br>
    <c:forEach var="pos" items="${allPos}">
        <p>${pos.id}. ${pos.positionType}</p>
    </c:forEach>
    <br><br>
    <input type="submit" value="Update"/>
</form:form>
</body>
</html>