<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of articles</title>

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
    <caption>List of articles</caption>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Categories</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${articles}' var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.author.firstName} ${article.author.lastName}</td>

            <td>
                <c:forEach items="${article.categories}" var="item">
                    ${item.name}<br>
                </c:forEach>

            </td>

            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td><a href="/editarticle/${article.id}">Edytuj</a> <br><br> <a href="/deletearticle/${article.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br> <a href="/addarticle">Dodaj nowy artykuł</a>

</body>
</html>
