<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<form:form method="post" modelAttribute="category">
    <label for="name">Name: </label>
    <form:input path="name"/><br><br>
    <label for="description">Description: </label>
    <form:input path="description"/><br><br>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>
