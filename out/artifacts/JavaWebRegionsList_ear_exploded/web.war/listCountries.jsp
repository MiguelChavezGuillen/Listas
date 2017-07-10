
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 24/02/2017
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Countries List</title>
</head>
<body>
<h1>Countries List</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Region</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>
                <a href="countries?action=show&id=${country.id}">
                    <c:out value="${country.id}"/>
                </a>
            </td>
            <td><c:out value="${country.name}"/></td>
            <td><c:out value="${country.region.name}"/></td>
            <td>
                <a href="countries?action=edit&id=${country.id}">Edit</a>
                <a href="countries?action=delete&id=${country.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="countries?action=new">New Country</a></p>
</body>
</html>
