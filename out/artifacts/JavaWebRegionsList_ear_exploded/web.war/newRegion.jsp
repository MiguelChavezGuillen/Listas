<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 18/02/2017
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Region</title>
</head>
<body>
<h1>New Region</h1>
<form action="regions" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <jsp:include page="_region_fieldset.jsp"/>
    </fieldset>
</form>
<jsp:include page="_regions_footer.jsp"/>
</body>
</html>
