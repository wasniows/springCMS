<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form article</title>
</head>
<body>
<%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
<form:form method="post" modelAttribute="article">
    <label for="title">Title: </label>
    <form:input path="title"/><br><br>
    <label for="author">Author: </label>
    <form:select path="author" items="${authors}" itemValue="id" itemLabel="lastName"/><br><br>
    <label>Categories: </label>
    <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name"/><br><br>
    <label>Content: </label>
    <form:textarea path="content" /><br><br>
    <input type="submit" value="Dodaj">
</form:form>

</body>
</html>
