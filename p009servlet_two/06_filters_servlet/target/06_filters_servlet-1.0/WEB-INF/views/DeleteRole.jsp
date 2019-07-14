<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 02.03.2018
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete ROLE</title>
</head>
<body>
    <h2>DELETE ROLE</h2>
    <form action="${pageContext.servletContext.contextPath}/deleterole" method="post" >
        Role id : <input type="text" name="role_id">
        Role name : <input type="text" name="name">
        <input type="submit">
    </form>


    <table style="border : lp solid black;" cellpadding="1" cellspacing="1" border="1">
        <tr>
            <th>role id</th>
            <th>role name</th>
        </tr>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td><c:out value="${role.id}"></c:out></td>
                <td><c:out value="${role.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="${pageContext.servletContext.contextPath}/">back to menu...</a>
</body>
</html>
