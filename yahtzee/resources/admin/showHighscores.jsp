<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<center>
    <h1>Show Highscores</h1><br>
    <yahtzee:showHighscores/>
    <a href="/faces/admin/highscoreManagement.jsp">Terug naar het Highscore Management</a>
</center>
</body>
</html>