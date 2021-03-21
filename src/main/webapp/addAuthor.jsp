<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>
<%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>
<form:form method="post" modelAttribute="author">
    <label for="firstName">First name: </label>
    <form:input path="firstName"/><br><br>
    <label for="lastName">Last name: </label>
    <form:input path="lastName"/><br><br>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>
