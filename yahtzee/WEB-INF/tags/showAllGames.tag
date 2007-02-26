<%@ tag import="be.kdg.yahtzee.model.game.Game" %>
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
        <td><h:outputText value="#{labels.roomName}"/></td>
        <td><h:outputText value="#{labels.allGameMax}"/></td>
        <td><h:outputText value="#{labels.allGameNumber}"/></td>
        <td><h:outputText value="#{labels.roomState}"/></td>
        <td colspan="2" align="center"><h:outputText value="#{labels.roomAction}"/></td>
    </tr>
    <% if (allGames.isEmpty()) {
    %>
    <tr>
        <td colspan="7" align="center"><h:outputText value="#{labels.allGameNone}"/></td>
    </tr>
    <% }
        for (Object game1 : allGames) {
            Game game = (Game) game1;
    %>
    <tr>
        <td><%= game.getGameName()%>
        </td>
        <td><%= game.getMaxPlayer()%>
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