<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css" />
        <title><h:outputText value="#{labels.userTitle}"/></title>
    </head>

    <body>
    <div id="userManagement">
        <div class="headerText">
            <h1><h:outputText value="#{labels.admin}"/></h1>
            <h2><h:outputText value="#{labels.user}"/></h2>
            <a href="/faces/admin/administrator.jsp" class="special"> &lt; <h:outputText value="#{labels.adminBack}"/></a> | <a href="/faces/admin/createUser.jsp" class="special"><h:outputText value="#{labels.userAdd}"/></a>
            <form action="/admin/SearchUserServlet" method="post">
                <table>
                    <tr>
                        <td><input type="text" name="searchUser" class="text"/></td>
                        <td><input type="submit" value="<h:outputText value="#{labels.userButton}"/>" class="btn"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="overview">
            <yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                                  hrefBlock="/admin/BlockUserServlet"/>
        </div>
    </div>
    </body>
    </html>
</f:view>