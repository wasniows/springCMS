<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>

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
        <h3 class="display-4">Nowa kategoria</h3>
    </div>
</div>
<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<div class="container pt-5">
    <form:form action="/editcategory" method="post" modelAttribute="category">
        <div class="row">
            <div class="form-group col-6">
                <label for="name">Nazwa</label>
                <form:input path="name" cssClass="form-control"/>
                <small><form:errors path="name" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="description">Opis</label>
                <form:input path="description" cssClass="form-control"/>
                <small><form:errors path="description" cssClass="alert-danger"/></small>
            </div>
        </div>
        <form:hidden path="id" />
        <button type="submit" class="btn btn-primary" >Dodaj</button>
    </form:form>
</div>
</body>
</html>
