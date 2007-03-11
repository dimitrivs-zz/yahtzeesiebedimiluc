function refresh()
{
    getGames()
    getOnlineUsers()
    //getGlobalChatMessages()
}

function getGames() {
    DwrController.getGames(gotGames)
}

function getOnlineUsers() {
    DwrController.getOnlineUsers(onlineUserList)

}
function sendMessage()
{
    var text = DWRUtil.getValue("text");
    var name = DWRUtil.getValue("name");
    DWRUtil.setValue("text", "");
    GameManager.addGlobalMessage(name + " : " + text + "<br/>", gotMessages);
}

function getGlobalChatMessages() {
    GameManager.getGlobalMessages(gotMessages);
}

function onlineUserList(messages) {
    var tableOnlineUsers = '<table><tr><td>'
    for (var user in messages) {
        tableOnlineUsers += '<a href="/profile/ShowProfileServlet?user=' + messages[user].username + '" onclick=\"window.open(\'/profile/ShowProfileServlet?user=' + messages[user].username + '\',\'Help\',\'width=520,height=305,scrollbars=no,toolbar=no,location=no,scrollbars=no,resizable=no,menubar=no\'); return false">' + messages[user].username + '</a>,';
        ;
    }
    tableOnlineUsers += '</td></tr></table>'
    DWRUtil.setValue("onlineUsers", tableOnlineUsers)
    setTimeout("getOnlineUsers()", 5000);
}

function gotGames(messages)
{
    var tableGames = '<table width="595px" border="0" class="games">'

    for (var game in messages)
    {
        tableGames += "<tr>"
        tableGames += "<td width='140'>" + messages[game].gameName + "</td>"
        tableGames += "<td width='75' class='center'>" + messages[game].maxPlayer + "</td>"
        tableGames += "<td width='225'>"
        if (messages[game].state != 'Empty') {
            for (var user in messages[game].users) {
                tableGames += '<a href="/profile/ShowProfileServlet?user=' + messages[game].users[user].username + '" onclick=\"window.open(\'/profile/ShowProfileServlet?user=' + messages[game].users[user].username + '\',\'Help\',\'width=520,height=305,scrollbars=no,toolbar=no,location=no,scrollbars=no,resizable=no,menubar=no\'); return false">' + messages[game].users[user].username + '</a>';
            }
        } else {
            tableGames += "No players"
        }
        tableGames += "</td>"
        tableGames += "<td width='75' class='center'>" + messages[game].state + "</td><td width='90'>"
        if (messages[game].state == 'Waiting') {
            tableGames += "<a href=/faces/game/JoinGameServlet?join=" + messages[game].gameName + ">Join</a>"
        } else {
            tableGames += "Playing"
        }
        tableGames += "</td></tr>"
    }

    tableGames += "</table>"
    DWRUtil.setValue("games", tableGames)
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
    var objDiv = document.getElementById("chatlog");
    objDiv.scrollTop = objDiv.scrollHeight;
    setTimeout("getGlobalChatMessages()", 1000);
}