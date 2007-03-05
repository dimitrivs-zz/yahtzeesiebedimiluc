<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>


<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head><title>
        <h:outputText value="#{labels.userSearch}"/>
    </title></head>
    <body>
    <div id="userManagement">
        <yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                              hrefBlock="/admin/BlockUserServlet"/>
        <a href="/faces/admin/ShowUsersServlet" class="special">
            <h:outputText value="#{labels.userBack}"/>
        </a>
    </div>
    </body>

</f:view>