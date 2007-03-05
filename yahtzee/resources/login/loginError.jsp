<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.loginErrorTitle}"/>
        </title>
    </head>

    <body>
    <div id="message">
        <center>
            <h:outputText value="#{labels.loginError}"/>
            <br>
            <h:outputText value="#{labels.loginCause}"/>
            <br>
            <a href="../faces/login/login.jsp" class="back">
                <h:outputText value="#{labels.loginAgain}"/>
            </a>
        </center>
    </div>
    </body>
    </html>
</f:view>