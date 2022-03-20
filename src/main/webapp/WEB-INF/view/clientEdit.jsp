<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
</head>
<body>
<h2>CLIENT EDIT FORM</h2>
<br>
<br>
<form:form action="update" modelAttribute="clientEdit">

  <form:hidden path="clientNumber"/>
  <br><br>
  Name <form:input path="name"/>
  <br><br>
  Address <form:input path="address"/>
  <br><br>
  Phone number <form:input path="phoneNumber"/>
  <br><br>
  <input type="submit">Update</input>
</form:form>
</body>
</html>