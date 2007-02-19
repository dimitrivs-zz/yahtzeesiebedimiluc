<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<html>
<head><title>Spel overzicht</title>
    <link href="../css/gameStyle.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/interface/UserManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='gameRoom.js'></script>
</head>
<body onload='refresh()'>
<div id="header">
    <div id="logo"> <img src="../images/logo.png" class="logo" alt="Yahtzee"/> </div>
    <div id="links">
        <h2><a href="/faces/player/startNewGame.jsp">Start new game</a> | <a href="/profile/ChangeProfileServlet?userName=${userBean.username}">Change Profile</a> | <a href="../logout/LogoutServlet">Logout</a></h2>
    </div>
</div>
<div id="roomsContainer">
    <div class="tekst"><span class="welkom">Welkom, </span>${userBean.name}<br /></div>
    <div class="hr"><hr /></div>
    <div id="roomsWrapper">
        <div id="rooms">
            <h3>Gamerooms:</h3>
            <div id="roomTable">
                <div id="games"></div>
            </div>
        </div>
        <div id="chat">
            <h3 class="chatTekst">Yahtzee chat</h3>
            <textarea id="chatlog" readonly="readonly" class="top"></textarea>
            <textarea id="text" class="bottom"></textarea>
            <input id="name" type="hidden" value="${userBean.username}">
            <input onClick="sendMessage()" name="btnSend "type="submit" value="Send" class="btn"/>
        </div>
    </div>
    <div id="footer">
        <div class="hr"><hr /></div>
        <div id="footerTekst">
            <a href="info.html" onclick="window.open('info.html','info','width=250,height=250,scrollbars=no,toolbar=no,location=no'); return false">Info</a> | <a href="help" target="_blank">Help</a> </div>
    </div>
</div>
<div id="onlineUsers">
</div>

<p>
    <font color="RED">${error}</font>
</p>
</body>
</html>