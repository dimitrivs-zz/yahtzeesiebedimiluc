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
        tableOnlineUsers += '<a href=/profile/ShowProfileServlet?user=' + messages[user].username + '>' + messages[user].username + '</a>' + ', '
    }
    tableOnlineUsers += '</td></tr></table>'
    DWRUtil.setValue("onlineUsers", tableOnlineUsers)
    setTimeout("getOnlineUsers()", 5000);
}

function gotGames(messages)
{
    var tableGames = '<table border="1"><tr><th>Spelnaam</th><th>Aantal</th><th>Spelers in het spel</th><th>Status</th></tr>'

    for (var game in messages)
    {
        tableGames += "<tr>"
        tableGames += "<td>" + messages[game].gameName + "</td>"
        tableGames += "<td>" + messages[game].maxPlayer + "</td>"
        tableGames += "<td>"
        for (var user in messages[game].users) {
            tableGames += messages[game].users[user].username + ", "
        }
        tableGames += "</td>"
        tableGames += "<td>" + messages[game].state + "</td>"
        if (messages[game].state != 'Full') {
            tableGames += "<td><a href=/game/JoinGameServlet?join=" + messages[game].gameName + ">meedoen</a></td>"
        }
        tableGames += "</tr>"
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