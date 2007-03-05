<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.showScoreTitle}"/>
        </title>
    </head>
    <body>
    <div id="adminSource">
        <table align="center">
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