<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="/listofarticles" class="nav-link nav-item">Artykuły</a>
            <a href="/listofdrafts" class="nav-link nav-item">Szkice</a>
            <a href="/listofcategories" class="nav-link nav-item">Kategorie</a>
            <a href="/listofauthors" class="nav-link nav-item ">Autorzy</a>
        </div>
    </div>
</nav>
<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Info</h3>
    </div>
</div>

<div class="container">

    <div class="text-center">
        <br><br>
        <h3>Usunięcie rekordu niemożliwe</h3>
    </div>
    <br><br>

    <div class="container">
        <div class="row">
            <div  class="col text-center">
                <form action="/listofauthors">
                    <button class="btn btn-outline-primary btn-lg">Powrót</button>
                </form>
            </div>
        </div>
    </div>

</div>

</body>
</html>
