<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Show All Users</title>
</head>

<body>
<center>
    <h1>Gebruikersoverzicht</h1><br>
    <yahtzee:showAllUsers hrefRemove="/admin/RemoveUserServlet" hrefChange="/admin/ChangeUserServlet"
                          hrefBlock="/admin/BlockUserServlet"/>
    <a href="userManagement.jsp">Naar Gebruikersoverzicht</a>
</center>
</body>
</html>