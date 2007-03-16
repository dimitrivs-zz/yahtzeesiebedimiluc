<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.adminTitle}"/>
        </title>
    </head>
    <body>
    <div id="adminSource">
        <table>
            <tr>
                <td colspan="2" id="logout"><a href="../logout/LogoutServlet" class="special">
                    <h:outputText value="#{labels.logout}"/>
                </a></td>
            </tr>
            <tr>
                <td>
                    <img src="../images/logo.png" class="logo" alt="Yahtzee"/>
                </td>
                <td>
                    <h1>
                        <h:outputText value="#{labels.admin}"/>
                    </h1>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <h2>
                        <h:outputText value="#{labels.adminFunctions}"/>
                    </h2>
                    <ul>
                        <li><a href="/faces/admin/ShowUsersServlet">
                            <h:outputText value="#{labels.adminUser}"/>
                        </a></li>
                        <li><a href="/faces/admin/ShowGamesServlet">
                            <h:outputText value="#{labels.adminGame}"/>
                        </a></li>
                        <li><a href="/faces/player/gameRoom.jsp">
                            <h:outputText value="#{labels.roomTitle}"/>
                        </a></li>
                    </ul>
                </td>
                <tr>
                    <td colspan="2">
                        <h2>
                            <h:outputText value="#{labels.adminStats}"/>
                        </h2>
                        <ul>
                            <li><a href="/faces/admin/highscoreManagement.jsp">
                                <h:outputText value="#{labels.adminScores}"/>
                            </a></li>
                            <li>
                                <h:outputText value="#{labels.adminFreqs}"/>
                            </li>
                        </ul>
                    </td>
                </tr>
        </table>
    </div>
    </body>
    </html>
</f:view>