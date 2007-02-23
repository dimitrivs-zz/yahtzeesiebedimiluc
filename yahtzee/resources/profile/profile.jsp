<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css" />
        <title><h:outputText value="#{labels.profile}"/></title>
    </head>
    <body>
    <div id="container">
        <table>
            <tr>
                <td><img src="../images/logo.png" class="logo" alt="Yahtzee"/></td>
                <td><h1><h:outputText value="#{labels.profile}"/></h1></td>
            </tr>
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
                <td colspan="2">
                    <a href="/faces/player/gameRoom.jsp"><h:outputText value="#{labels.gameroomButton}"/></a>
                </td>
            </tr>
        </table>
    </div>
    </body>
    </html>
</f:view>