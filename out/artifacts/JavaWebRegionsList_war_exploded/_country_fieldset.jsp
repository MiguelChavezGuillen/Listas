<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<label for="id">Id</label>
<input type="text" name="id" id="id" value="${country.id}"/>
<label for="name">Name</label>
<input type="text" name="name" id="name" value="${country.name}"/>
<select name="regionId" id="regionId">
    <c:forEach var="region" items="${regions}">
        <option value="${region.id}" ${region.id == country.region.id ? 'selected' : ''}>${region.name}</option>
    </c:forEach>
</select>

<input type="submit"/>
