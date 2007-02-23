<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head><title><h:outputText value="#{labels.profile}"/></title></head>
    <body>
    <div id="container">
        <table border="1">
            <tr>
                <td><h:outputText value="#{labels.userName}"/></td>
                <td>${userName}</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.firstname}"/></td>
                <td>${firstName}</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.surname}"/></td>
                <td>${surName}</td>
            </tr>
            <tr>
                <a href="/faces/player/gameRoom.jsp"><h:outputText value="#{labels.gameroomButton}"/></a>
            </tr>
        </table>
    </div>
    </body>
    </html>
</f:view>