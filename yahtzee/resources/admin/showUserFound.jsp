<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>
<html>
<head><title>User Search</title></head>
<body>
<yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                      hrefBlock="/admin/BlockUserServlet"/>
<a href="/admin/ShowUsersServlet">Naar Gebruikersoverzicht</a>
</body>
</html>