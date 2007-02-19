<%@ tag import="be.kdg.yahtzee.model.game.Game" %>
<%@ tag body-content="empty" %>
<%@ attribute name="hrefRemove" required="true" %>
<%@ attribute name="hrefWatch" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="allGames" class="java.util.ArrayList" scope="session"/>

<table border="1">
    <tr>
        <td>Game Name</td>
        <td>Max Players</td>
        <td>Actual Number Players</td>
        <td>State</td>
        <td colspan="2" align="center">Actions</td>
    </tr>
    <% if (allGames.isEmpty()) {
    %>
    <tr>
        <td colspan="7" align="center">No Games</td>
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