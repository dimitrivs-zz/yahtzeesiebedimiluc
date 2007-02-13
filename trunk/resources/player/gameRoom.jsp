<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<!-- testje van dimi -->
<html>
<head><title>Spel overzicht</title>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/interface/UserManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript">

        function refresh()
        {
            getGames()
            getOnlineUsers()
            getGlobalChatMessages()
        }

        function getGames() {
            GameManager.getGames(gotGames)

        }

        function getOnlineUsers() {
            UserManager.getOnlineUsers(onlineUserList)

        }
        function sendMessage()
        {
            var text = DWRUtil.getValue("text");
            DWRUtil.setValue("text", "");
            GameManager.addGlobalMessage("${userBean.name}: " + text + "\n", gotMessages);
        }

        function getGlobalChatMessages() {
            GameManager.getGlobalMessages(gotMessages);
        }

        function onlineUserList(messages) {
            var table2 = '<table><tr><td>'
            for (var user in messages) {
                table2 += messages[user].username + ", "
            }
            table2 += '</td></tr></table>'
            DWRUtil.setValue("testDiv2", table2)
            setTimeout("getOnlineUsers()", 5000);
        }

        function gotGames(messages)
        {
            var table = '<table border="1"><tr><th>Spelnaam</th><th>Aantal</th><th>Spelers in het spel</th><th>Status</th></tr>'

            for (var game in messages)
            {
                table += "<tr>"
                table += "<td>" + messages[game].gameName + "</td>"
                table += "<td>" + messages[game].maxPlayer + "</td>"
                table += "<td>"
                for (var user in messages[game].users) {
                    table += messages[game].users[user].username + ", "
                }
                table += "</td>"
                table += "<td>" + messages[game].state + "</td>"
                if (messages[game].state != 'Full') {
                    table += "<td><a href=/game/JoinGameServlet?join=" + messages[game].gameName + ">meedoen</a></td>"
                }
                table += "</tr>"
            }

            table += "</table>"
            DWRUtil.setValue("testDiv", table)
            setTimeout("getGames()", 5000);
        }

        function gotMessages(messages)
        {
            var chatlog = "";
            for (var data in messages)
            {
                chatlog = messages[data].text + chatlog;
            }
            DWRUtil.setValue("chatlog", chatlog);
            setTimeout("getGlobalChatMessages()", 1000);
        }
    </script>
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
                        <td><a href="/player/startNewGame.jsp">Start nieuw spel</a></td>
                    </tr>
                    <tr>
                        <td><a href="/profile/ChangeProfileServlet?userName="${userBean.username}">Change profile</ a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="/logout/logout.html"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

    </table>
</p>
<!--<input type="button" onclick="check()">  -->
<p>
    <!--
    <yahtzee:showGame href="/game/JoinGameServlet"/>
    <yahtzee:showUsers/>-->
</p>

<table>
    <tr>
        <td>


            <div id="testDiv">

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
                        <input type="button" onclick="sendMessage()" value="send" name="btnSend">
                    </td>
                </tr>
                <tr>
                    <td><a href="/game/LeaveGameServlet?leave=${gameBean.gameName}">leave</a></td>
                </tr>
            </table>

        </td>

    </tr>
</table>
<div id="testDiv2">

</div>


<p>
    <font color="RED">${error}</font>
</p>
</body>
</html>