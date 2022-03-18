<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>Tour Type ADD FORM</h2>
<br>
<br>
<form:form action="save" modelAttribute="tourTypeAdd">
    Tour type <form:input path="tourTypeEnum"/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>