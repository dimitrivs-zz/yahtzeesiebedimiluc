<%@ tag import="be.kdg.yahtzee.model.users.User" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>

<table>
<tr>
        <td>
        <% for (Object user1 : gameBean.getUsersOfGame()){
                User user = (User) user1;
            %>
                <%=user.getUsername()%><br>
            <%}%>
        </td>
    </tr>
</table>