<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit author</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="/listofarticles" class="nav-link nav-item">Artykuły</a>
            <a href="/listofcategories" class="nav-link nav-item">Kategorie</a>
            <a href="/listofauthors" class="nav-link nav-item ">Autorzy</a>
        </div>
    </div>
</nav>
<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Edycja autora</h3>
    </div>
</div>
<%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>
<div class="container pt-5">
    <form:form action="/editauthor" method="post" modelAttribute="author">
        <div class="row">
            <div class="form-group col-6">
                <label for="firstName">Imię</label>
                <form:input path="firstName" cssClass="form-control"/>
                <small><form:errors path="firstName" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="lastName">Tytuł</label>
                <form:input path="lastName" cssClass="form-control"/>
                <small><form:errors path="lastName" cssClass="alert-danger"/></small>
            </div>
        </div>
        <form:hidden path="id" />
        <button type="submit" class="btn btn-primary" >Edytuj</button>
    </form:form>
</div>
</body>
</html>