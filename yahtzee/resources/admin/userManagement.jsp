<%--
  Created by IntelliJ IDEA.
  User: Luc
  Date: 13-feb-2007
  Time: 15:12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>
    <html>
    <head><title><h:outputText value="#{labels.userTitle}"/></title></head>
    <body>
    <center><h2><h:outputText value="#{labels.adminUser}"/></h2></center>
    <ul>
        <li><a href="/faces/admin/ShowUsersServlet"><h:outputText value="#{labels.userShow}"/></a></li>
        <li><a href="/faces/admin/createUser.jsp"><h:outputText value="#{labels.userAdd}"/></a></li>
        <br>
    </ul>
    <a href="/faces/admin/administrator.jsp"><h:outputText value="#{labels.adminBack}"/></a>
    </body>
    </html>
</f:view>