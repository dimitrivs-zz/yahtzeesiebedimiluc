<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head>
    <title>
        <h:outputText value="#{labels.userConfirm}"/>
    </title>
</head>

<body>
<center>
    ${message}
    <a href="/faces/admin/userManagement.jsp">
        <h:outputText value="#{labels.userBack}"/>
    </a>
</center>
</body>
</html>
</f:view>