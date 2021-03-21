<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
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
        <th>Created</th>
        <th>Content</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${articles}' var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>

<%--            <td>--%>
<%--                <a href="/editauthor/${author.id}">Edytuj</a> <br><br> <a href="/deleteauthor/${author.id}">Usuń</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>
