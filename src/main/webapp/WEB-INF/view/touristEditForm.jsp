<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>TOURIST EDIT FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="touristEdit">

    <form:hidden path="passportNumber"/>
    <br><br>
    Fullname <form:input path="fullName"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    Age <form:input path="age"/>
    <br><br>
    <input type="submit">Update</input>
</form:form>
</body>
</html>