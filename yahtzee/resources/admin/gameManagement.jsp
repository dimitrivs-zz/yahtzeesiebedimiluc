<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.gameManTitle}"/>
        </title>
    </head>
    <body>
    <div id="gameManagement">
        <div class="headerText">
            <h1>
                <h:outputText value="#{labels.admin}"/>
            </h1>

            <h2>
                <h:outputText value="#{labels.gameMan}"/>
            </h2>
            <a href="/faces/admin/administrator.jsp" class="special"> &lt;
                <h:outputText value="#{labels.adminBack}"/>
            </a> | <a href="remove.html" class="special">Remove all idle and empty games</a>
        </div>
        <div id="overview">
            <yahtzee:showAllGames hrefRemove="/admin/RemoveGameServlet" hrefWatch="/admin/WatchGameServlet"/>
        </div>
    </div>
    </body>
    </html>
</f:view>