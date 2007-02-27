<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title><h:outputText value="#{labels.infoTitle}"/></title>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <div id="info">
        <table>
            <tr>
                <td colspan="2"><h2><h:outputText value="#{labels.infoVersion}"/></h2></td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 1:</td>
                <td>naam1</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 2:</td>
                <td>naam2</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 3:</td>
                <td>naam3</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 4:</td>
                <td>naam4</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 5:</td>
                <td>naam5</td>
            </tr>
            <tr>
                <td><h:outputText value="#{labels.infoProgrammer}"/> 6:</td>
                <td>naam6</td>
            </tr>
        </table>
    </div>
    </body>
    </html>
</f:view>