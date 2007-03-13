<%@ tag import="be.kdg.yahtzee.model.remoteObjects.game.Game" %>
<%@ tag body-content="empty" %>

<%@ attribute name="hrefRemove" required="true" %>
<%@ attribute name="hrefWatch" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<jsp:useBean id="allGames" class="java.util.ArrayList" scope="session"/>
<f:loadBundle basename="bundles.resources" var="labels"/>
<table border="1">
    <tr>
        <th>
            <h:outputText value="#{labels.roomName}"/>
        </th>
        <th>
            <h:outputText value="#{labels.allGameMax}"/>
        </th>
        <th>
            <h:outputText value="#{labels.allGameNumber}"/>
        </th>
        <th>
            <h:outputText value="#{labels.roomState}"/>
        </th>
        <th colspan="2" align="center">
            <h:outputText value="#{labels.roomAction}"/>
        </th>
    </tr>
    <% if (allGames.isEmpty()) {
    %>
    <tr>
        <td colspan="7" align="center">
            <h:outputText value="#{labels.allGameNone}"/>
        </td>
    </tr>
    <% }
        for (Object game1 : allGames) {
            Game game = (Game) game1;
    %>
    <tr>
        <td><%= game.getGameName()%>
        </td>
        <td class="center"><%= game.getMaxPlayer()%>
        </td>
        <td><%= game.getNumberOfPlayers()%>
        </td>
        <td><%= game.getState()%>
        </td>
        <% if (game.getNumberOfPlayers() == 0) {%>
        <td><a href=${hrefRemove}?gamename=<%= game.getGameName()%>>Remove</a></td>
        <% } else { %>
        <td colspan="2"><a href=${hrefWatch}?gamename=<%= game.getGameName()%>>Watch</a></td>
        <% } %>

    </tr>
    <%
        }
    %>
</table>