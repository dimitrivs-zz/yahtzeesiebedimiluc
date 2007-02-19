<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <title><h:outputText value="#{labels.allusersTitle}"/></title>
    </head>

    <body>
    <center>
        <h1><h:outputText value="#{labels.allusers}"/></h1><br>

        <form action="/admin/SearchUserServlet" method="post">
            <table>
                <tr>
                    <td><input type="text" name="searchUser"/></td>
                    <td><input type="submit" value="Zoeken"></td>
                </tr>
            </table>
        </form>
        <yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                              hrefBlock="/admin/BlockUserServlet"/>
        <a href="/faces/admin/userManagement.jsp"><h:outputText value="#{labels.usersBack}"/></a>
    </center>
    </body>
    </html>
</f:view>