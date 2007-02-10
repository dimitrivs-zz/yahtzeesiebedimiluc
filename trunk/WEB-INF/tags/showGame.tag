<%@ tag import="be.kdg.yahtzee.model.game.Game"%>
<%@ tag import="be.kdg.yahtzee.model.users.User" %>
<%@ tag body-content="empty" %>
<%@ attribute name="href" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="games" class="java.util.HashSet" scope="session"/>


<table border ="1">
    <tr>
        <th>Spelnaam</th>
        <th>Aantal</th>
        <th>Spelers in het spel</th>
        <th>Status</th>
    </tr>
    <% if (games.isEmpty()) {
    %>
    <tr>
        <td colspan="4" align="center">Geen Games</td>
    </tr>
    <% }
        for (Object game1 : games) {
            Game game = (Game) game1;
    %>
    <tr>
        <td><%= game.getGameName()%></td>
        <td><%= game.getMaxPlayer()%></td>
        <td><% for (Object user1 : game.getUsers()){
                User user = (User) user1;
            %>
                <%=user.getUsername()%><br>
            <%}%>
        </td>
        <td><%= game.getState()%> </td>
        <td><a href=${href}?join=<%= game.getGameName()%>>meedoen</a></td>
    </tr>
    <%
        }
    %>
</table>