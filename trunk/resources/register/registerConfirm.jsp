<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css" />
        <title>
            <h:outputText value="#{labels.registerConfirmTitle}"/>
        </title>
    </head>

    <body>
    <div id="message">
        <center>
            ${message}<br />
            <a href="../login/login.jsp"><h:outputText value="#{labels.inlogButton}"/></a>
        </center>
    </div>
    </body>
    </html>
</f:view>