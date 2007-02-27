<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">
    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css"/>
        <title>High Score Management</title>
    </head>
    <body>
    <center><h2>High Score Management</h2></center>
    <ul>
        <li><a href="/admin/ShowHighscoresServlet?filter=top10">Toon Top 10</a></li>
        <li><a href="/admin/ShowHighscoresServlet?filter=allScores">Alle scores</a></li>
        <br>
    </ul>
    <a href="/faces/admin/administrator.jsp">Terug naar het Administrator Overzicht</a>
    </body>
    </html>
</f:view>