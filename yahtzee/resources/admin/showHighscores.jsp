<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.showScoreTitle}"/>
        </title>
    </head>
    <body>
    <div id="adminSource">
        <table class="topscore">
            <tr>
                <td id="logout">
                    <a href="../logout/LogoutServlet" class="special">
                        <h:outputText value="#{labels.logout}"/>
                    </a>
                </td>
            </tr>
            <tr>
                <td><h1>
                    <h:outputText value="#{labels.showScoreTitle}"/>
                </h1></td>
            </tr>
            <tr>
                <td>
                    <yahtzee:showHighscores/>
                </td>
            </tr>
        </table>
        <a href="/faces/admin/highscoreManagement.jsp" class="special">
            <h:outputText value="#{labels.showScoreBack}"/>
        </a>
    </div>
    </body>
    </html>
</f:view>