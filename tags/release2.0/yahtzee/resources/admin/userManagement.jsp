<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link href="../css/adminStyle.css" rel="stylesheet" type="text/css"/>
        <title>
            <h:outputText value="#{labels.userTitle}"/>
        </title>
    </head>

    <body>
    <div id="userManagement">
        <div class="headerText">
            <h1>
                <h:outputText value="#{labels.admin}"/>
            </h1>

            <h2>
                <h:outputText value="#{labels.user}"/>
            </h2>
            <a href="/faces/admin/administrator.jsp" class="special"> &lt;
                <h:outputText value="#{labels.adminBack}"/>
            </a><span class="spacer"> | </span><a href="/faces/admin/createUser.jsp" class="special">
            <h:outputText value="#{labels.userAdd}"/>
        </a>

            <div id="search">
                <form action="/admin/SearchUserServlet" method="post">
                    <table class="special">
                        <tr>
                            <td><input type="text" name="searchUser" class="text"/></td>
                            <td><input type="submit" value="<h:outputText value="#{labels.userButton}"/>" class="btn">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div id="overview">
            <yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                                  hrefBlock="/admin/BlockUserServlet"/>
        </div>
    </div>
    </body>
    </html>
</f:view>