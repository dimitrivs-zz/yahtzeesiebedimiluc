<%@ tag import="be.kdg.yahtzee.model.remoteObjects.users.Role" %>
<%@ tag import="be.kdg.yahtzee.model.remoteObjects.users.User" %>
<%@ tag body-content="empty" %>
<%@ attribute name="hrefRemove" required="true" %>
<%@ attribute name="hrefChange" required="true" %>
<%@ attribute name="hrefBlock" required="true" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="allUsers" class="java.util.ArrayList" scope="session"/>

<f:loadBundle basename="bundles.resources" var="labels"/>
<table border="1">
    <tr>
        <th align="center">
            <h:outputText value="#{labels.allUserID}"/>
        </th>
        <th align="center">
            <h:outputText value="#{labels.userName}"/>
        </th>
        <th align="center">
            <h:outputText value="#{labels.userName}"/>
        </th>
        <th colspan="3" align="center">
            <h:outputText value="#{labels.allUserActions}"/>
        </th>
    </tr>
    <% if (allUsers.isEmpty()) {
    %>
    <tr>
        <td colspan="7" align="center">
            <h:outputText value="#{labels.allUserNone}"/>
        </td>
    </tr>
    <% } else {
        for (Object user1 : allUsers) {
            User user = (User) user1;
    %>
    <tr>
        <td class="center"><%= user.getUserId()%>
        </td>
        <td><%= user.getUsername()%>
        </td>
        <td><%= ((Role) user.getRole()).getName()%>
        </td>
        <td><a href=${hrefRemove}?username=<%= user.getUsername()%>>
            <h:outputText value="#{labels.allUserRemove}"/>
        </a></td>
        <td><a href=${hrefChange}?username=<%= user.getUsername()%>>
            <h:outputText value="#{labels.allUserChange}"/>
        </a></td>
        <% if (user.isBlocked()) { %>
        <td><a href=${hrefBlock}?username=<%= user.getUsername()%>&blocked=<%=false%>>Unblock</a></td>
        <% } else { %>
        <td><a href=${hrefBlock}?username=<%= user.getUsername()%>&blocked=<%=true%>>Block</a></td>
        <% } %>
    </tr>

    <%
            }
        }
    %>
</table>
<table>
    <tr>
</table>
