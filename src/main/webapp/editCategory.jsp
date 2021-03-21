<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>


<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<form:form action="/editcategory" method="post" modelAttribute="category">
    <label for="name">Name: </label>
    <form:input path="name"/><br><br>
    <label for="description">Description: </label>
    <form:input path="description"/><br><br>
    <form:hidden path="id" />
    <input type="submit" value="Zmień">
</form:form>

</body>
</html>
