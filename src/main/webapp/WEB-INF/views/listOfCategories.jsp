<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Categories</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="/listofarticles" class="nav-link nav-item ">Artykuły</a>
            <a href="/listofdrafts" class="nav-link nav-item">Szkice</a>
            <a href="/listofcategories" class="nav-link nav-item active">Kategorie</a>
            <a href="/listofauthors" class="nav-link nav-item">Autorzy</a>
        </div>
    </div>
</nav>

<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Kategorie</h3>
    </div>
</div>
<% int num = 1; %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Nazwa</th>
        <th>Opis</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${categories}' var="category">
        <tr>
            <td><%=num%></td>
            <td><a href="/articles?categoryName=${category.name}">${category.name}</a></td>
            <td>${category.description}</td>
            <td>
                <form action="/editcategory/${category.id}">
                    <button class="btn btn-outline-primary btn-sm">edytuj</button>
                </form>
            </td>
            <td>
                <form action="/deletecategory/${category.id}">
                    <button class="btn btn-outline-danger btn-sm">usuń</button>
                </form>
            </td>
        </tr>
        <%num = num + 1;%>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-3 pl-5">
        <form action="/addcategory">
            <button class="btn btn-outline-success">Dodaj kategorię</button>
        </form>
    </div>
</div>

</body>
</html>
