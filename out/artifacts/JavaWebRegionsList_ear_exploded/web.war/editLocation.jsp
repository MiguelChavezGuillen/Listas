<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02/07/2017
  Time: 09:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Location</title>
</head>
<body>
    <h1>Edit Location</h1>
    <form action="locations" method="post">
        <fieldset>
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${location.id}">
            <jsp:include page="_location_fieldset.jsp"/>
        </fieldset>
    </form>
    <jsp:include page="_location_footer.jsp"/>
</body>
</html>



