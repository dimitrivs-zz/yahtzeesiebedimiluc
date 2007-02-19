<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <title><h:outputText value="#{labels.allgamesTitle}"/></title>
    </head>
    <body>
    <center>
        <h1><h:outputText value="#{labels.allgames}"/></h1><br>
        <yahtzee:showAllGames hrefRemove="/admin/RemoveGameServlet" hrefWatch="/admin/WatchGameServlet"/>
        <a href="/faces/admin/gameManagement.jsp"><h:outputText value="#{labels.gameBack}"/></a>
    </center>
    </body>
    </html>
</f:view>