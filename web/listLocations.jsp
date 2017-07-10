<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02/07/2017
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Locations List</title>
</head>
<body>
<h1>Locations List</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Address</th>
        <th>Postal Code</th>
        <th>City</th>
        <th>Province</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="location" items="${locations}">
    <tr>
        <td>
            <a href="locations?action=show&id=${location.id}">
                <c:out value="${location.id}" ></c:out>
            </a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
