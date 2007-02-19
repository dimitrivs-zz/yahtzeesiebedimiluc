<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<html>
<head><title>Spel overzicht</title>
    <link href="../css/formStyle.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/interface/UserManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='gameRoom.js'></script>
</head>
<body onload='refresh()'>
<p>
    <table border="1">
        <tr>
            <td>Yahtzee</td>
            <td>Welkom ${userBean.name}</td>
            <td>
            <td>
                <table border="1">
                    <tr>
                        <td><a href="/faces/player/startNewGame.jsp">Start nieuw spel</a></td>
                    </tr>
                    <tr>
                        <td><a href="/profile/ChangeProfileServlet?userName=${userBean.username}">Change profile</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="/logout/logout.jsp"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

    </table>
</p>

<table>
    <tr>
        <td>
            <div id="games">
            </div>
        </td>
        <td>
            <table border="1">
                <tr>
                    <td>Chat</td>
                </tr>
                <tr>
                    <td>
                        <textarea id="chatlog" rows="10" cols="25"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input id="text" type="text" size="25">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input id="name" type="hidden" value="${userBean.username}">
                        <input type="button" onClick="sendMessage()" value="send" name="btnSend">
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>
<div id="onlineUsers">
</div>

<p>
    <font color="RED">${error}</font>
</p>
</body>
</html>