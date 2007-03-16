<%@ page import="be.kdg.yahtzee.remoteObjects.game.Score" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<f:view locale="#{language}">
<f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head><title>Game summary</title>

    <link href="../css/gameStyle.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/DwrController.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript">
        function leave() {
            DwrController.leaveGame('${gameBean.gameName}', '${userBean.username}');
        }
    </script>
</head>
<body onload="leave()">
<h1>Samenvatting spel ${gameBean.gameName}</h1>
<table>
<tr>
<td>

<% Map<String, Score> scores = (HashMap) session.getAttribute("scores"); %>
<table>
<tr>
    <td>&nbsp;</td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + s + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameOnes}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getOnes() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameTwos}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getTwos() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameThrees}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getThrees() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameFours}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getFours() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameFives}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getFives() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameSixes}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getSixes() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <b>
            <h:outputText value="#{labels.gameTotalUpper}"/>
        </b>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getUpperHalfWithoutBonus() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <b>
            <h:outputText value="#{labels.gameBonusUpper}"/>
        </b>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getUpperHalfBonus() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <b>
            <h:outputText value="#{labels.gameUpper}"/>
        </b>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getTotalUpperHalf() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameThree}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getThreeOfAKind() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameCarre}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getCarre() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameHouse}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getFullHouse() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameSmall}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getSmallStreet() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameLarge}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getLargeStreet() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.yahtzee}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getYahtzee() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameChance}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getChance() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <h:outputText value="#{labels.gameBonus}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getYahtzeeBonus() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <b>
                <h:outputText value="#{labels.gameTotalLower}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getTotalLowerHalf() + "</td>" %>
    <%}%>
</tr>
<tr>
    <td>
        <b style="color: #ffff00">
                <h:outputText value="#{labels.gameTotal}"/>
    </td>
    <% for (String s : scores.keySet()) {%>
    <%= "<td>" + scores.get(s).getTotalScore() + "</td>" %>
    <%}%>
</tr>
</table>
</td>
<td width="150">
</td>
</tr>
</table>
<a href="gameRoom.jsp">Terug naar Game Lobby</a>

</body>

</html>
</f:view>