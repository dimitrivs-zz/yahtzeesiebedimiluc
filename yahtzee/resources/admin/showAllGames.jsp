<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all Games</title>
</head>
<body>
<center>
    <h1>Speloverzicht</h1><br>
    <yahtzee:showAllGames hrefRemove="/admin/RemoveGameServlet" hrefWatch="/admin/WatchGameServlet"/>
    <a href="gameManagement.jsp">Naar Gameoverzicht</a>
</center>
</body>
</html>