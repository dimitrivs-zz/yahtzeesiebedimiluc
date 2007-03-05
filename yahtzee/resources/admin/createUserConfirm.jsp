<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.userConfirm}"/>
        </title>
    </head>

    <body>
    <div id="message">
        <center>
                ${message}<br/>
            <a href="/faces/admin/userManagement.jsp" class="special">
                <h:outputText value="#{labels.userBack}"/>
            </a>
        </center>
    </div>
    </body>
    </html>
</f:view>