<%@ tag import="be.kdg.yahtzee.model.remoteObjects.game.Highscore" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="highscores" class="java.util.ArrayList" scope="session"/>

<table border="0">
    <tr>
        <th>Rank</th>
        <th>Username</th>
        <th>Score</th>
    </tr>
    <% if (highscores.isEmpty()) {
    %>
    <tr>
        <td colspan="4" align="center">No Highscores</td>
    </tr>
    <% }
        for (int i = 0; i < highscores.size(); i++) {
            Highscore highscore = (Highscore) highscores.get(i);
    %>
    <tr>
        <td><%= i + 1%>
        </td>
        <td><%= highscore.getUser().getUsername()%>
        </td>
        <td class="center"><%= highscore.getScore()%>
        </td>
    </tr>

    <%
        }
    %>
    <tr>
        <td colspan="3" align="center">${message}</td>
    </tr>
</table>