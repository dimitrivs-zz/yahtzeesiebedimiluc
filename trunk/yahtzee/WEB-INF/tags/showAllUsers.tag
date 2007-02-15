<%@ tag import="be.kdg.yahtzee.model.users.User" %>
<%@ tag body-content="empty" %>
<%@ attribute name="hrefRemove" required="true" %>
<%@ attribute name="hrefChange" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="allUsers" class="java.util.ArrayList" scope="session"/>

<table border="1">
    <tr>
        <td>User ID</td>
        <td>Username</td>
        <td colspan="2" align="center">Actions</td>
    </tr>
    <% if (allUsers.isEmpty()) {
    %>
    <tr>
        <td colspan="4" align="center">No Users</td>
    </tr>
    <% }
        for (Object user1 : allUsers) {
                User user = (User) user1;
    %>
    <tr>
        <td><%= user.getUserId()%></td>
        <td><%= user.getUsername()%></td>
        <td><a href=${hrefRemove}?username=<%= user.getUsername()%>>Remove</a></td>
        <td><a href=${hrefChange}?username=<%= user.getUsername()%>>Change User</a></td>
    </tr>
    <%
        }
    %>
</table>