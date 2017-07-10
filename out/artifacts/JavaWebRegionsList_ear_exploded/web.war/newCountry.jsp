<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 24/02/2017
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Country</title>
</head>
<body>
<h1>New Country</h1>
<form action="countries" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <jsp:include page="_country_fieldset.jsp"/>
    </fieldset>
</form>
<jsp:include page="_countries_footer.jsp"/>
</body>
</html>
