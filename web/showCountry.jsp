<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 24/02/2017
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Country Information</h1>
<p>Country Id: <c:out value="${country.id}"/> </p>
<p>Country Name: <c:out value="${country.name}"/> </p>
<p>Region: <c:out value="${country.region.name}"/> </p>
<jsp:include page="_countries_footer.jsp"/>
</body>
</html>
