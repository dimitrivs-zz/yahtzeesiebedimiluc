<%@ tag import="be.kdg.yahtzee.model.game.Highscore" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<jsp:useBean id="highscores" class="java.util.ArrayList" scope="session"/>
<f:loadBundle basename="bundles.resources" var="labels"/>
<table border="1">
    <tr>
        <td><h:outputText value="#{labels.highRank}"/></td>
        <td><h:outputText value="#{labels.userName}"/></td>
        <td><h:outputText value="#{labels.highScore}"/></td>
    </tr>
    <% if (highscores.isEmpty()) {
    %>
    <tr>
        <td colspan="4" align="center"><h:outputText value="#{labels.highNone}"/></td>
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
        <td><%= highscore.getScore()%>
        </td>
    </tr>

    <%
        }
    %>
    <tr>
        <td colspan="3" align="center">${message}</td>
    </tr>
</table>