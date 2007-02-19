<%@ tag import="be.kdg.yahtzee.model.users.User" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="onlineUsers" class="java.util.ArrayList" scope="session"/>

<table>
    <tr>
        <td>
            <% for (Object user1 : onlineUsers) {
                User user = (User) user1;
            %>
            <%=user.getUsername()%>, &nbsp
            <%
                }
            %>
        </td>
    </tr>
</table>