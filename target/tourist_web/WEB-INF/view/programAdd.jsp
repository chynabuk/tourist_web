<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Program ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="progAdd">
    Program number <form:input path="programNumber"/>
    <br><br>
    Description <form:input path="description"/>
    <br><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>