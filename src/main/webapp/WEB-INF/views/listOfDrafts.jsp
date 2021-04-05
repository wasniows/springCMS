<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Drafts</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="/listofarticles" class="nav-link nav-item">Artykuły</a>
            <a href="/listofdrafts" class="nav-link nav-item active">Szkice</a>
            <a href="/listofcategories" class="nav-link nav-item">Kategorie</a>
            <a href="/listofauthors" class="nav-link nav-item">Autorzy</a>
        </div>
    </div>
</nav>
<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Szkice</h3>
    </div>
</div>
<% int num = 1; %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Tytuł</th>
        <th>Zawartość</th>
        <th>Utworzony</th>
        <th>Zmodyfikowany</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${articles}' var="article">
        <tr>
            <td><%=num%></td>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            </td>
            <td>
                <form action="/editdraft/${article.id}">
                    <button class="btn btn-outline-primary btn-sm">edytuj</button>
                </form>
            </td>
            <td>
                <form action="/deletedraft/${article.id}">
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
        <form action="/adddraft">
            <button class="btn btn-outline-success">Dodaj szkic</button>
        </form>
    </div>
</div>

</body>
</html>
