<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Eigenaar
  Date: 13-feb-2007
  Time: 12:46:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<table border="1">
    <tr>
        <td>username</td>
        <td>${userName}</td>
    </tr>
    <tr>
        <td>firstName</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>surName</td>
        <td>${surName}</td>
    </tr>
    <tr>
        <a href="/faces/player/gameRoom.jsp">terug naar gameroom</a>
    </tr>
</table>
</body>
</html>