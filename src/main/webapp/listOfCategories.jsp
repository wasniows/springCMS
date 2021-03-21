<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of categories</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid grey;
        }

        th, td {
            text-align: center;
            padding: 6px;
        }

        tr {
            background-color: #F2F2F2;
        }
    </style>
</head>
<body>

<table>
    <caption>List of categories</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${categories}' var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>

           <td>
              <a href="/editcategory/${category.id}">Edytuj</a> <br><br> <a href="/deletecategory/${category.id}">Usuń</a>
           </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br> <a href="/addcategory">Dodaj nową kategorię</a>

</body>
</html>
