<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit article</title>
</head>
<body>
<%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
<form:form action="/editarticle" method="get" modelAttribute="article">
    <label for="title">Title: </label>
    <form:input path="title"/><br><br>
    <label for="author">Author: </label>
    <form:select path="author" items="${authors}" itemValue="id" itemLabel="lastName"/><br><br>
    <label>Categories: </label>
    <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/><br><br>
    <label>Content: </label>
    <form:textarea path="content" /><br><br>
    <form:hidden path="id" />
    <form:hidden path="created" />
    <input type="submit" value="Zmień">
</form:form>

</body>
</html>
