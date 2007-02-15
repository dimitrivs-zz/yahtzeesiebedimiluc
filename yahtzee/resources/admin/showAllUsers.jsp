<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Show All Users</title>
</head>

<body>
<center>
    <h1>Gebruikersoverzicht</h1><br>

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
    <a href="userManagement.jsp">Naar Gebruikersoverzicht</a>
</center>
</body>
</html>