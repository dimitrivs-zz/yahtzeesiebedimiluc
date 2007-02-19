<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head><title><h:outputText value="#{labels.adminTitle}"/></title></head>
    <body>
    <center><h1><h:outputText value="#{labels.admin}"/></h1></center>
    <u><b><h:outputText value="#{labels.adminFunctions}"/></b></u>
    <ul>
        <li><a href="/faces/admin/userManagement.jsp"><h:outputText value="#{labels.adminUser}"/></a></li>
        <li><a href="/faces/admin/gameManagement.jsp"><h:outputText value="#{labels.adminGame}"/></a></li>
        <li><a href="../logout/LogoutServlet"><h:outputText value="#{labels.logout}" /></a></li>
    </ul>
    <br>
    <u><b><h:outputText value="#{labels.adminStats}"/></b></u>
    <ul>
        <li><h:outputText value="#{labels.adminScores}"/></li>
        <li><h:outputText value="#{labels.adminFreqs}"/></li>
    </ul>
    </body>
    </html>
</f:view>