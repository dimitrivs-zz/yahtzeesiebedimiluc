<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <title>
            <h:outputText value="#{labels.registerConfirmTitle}"/>
        </title>
    </head>

    <body>
    <center>
            ${message}
        <a href="../login/login.html">
            <h:outputText value="#{labels.inlogButton}"/>
        </a>
    </center>
    </body>
    </html>
</f:view>