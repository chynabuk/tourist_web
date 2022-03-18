<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Position ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="positionAdd">
    Position <form:input path="positionType"/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>