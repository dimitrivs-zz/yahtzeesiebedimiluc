<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<f:view locale="#{language}">
<f:loadBundle basename="bundles.resources" var="labels"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
    <h:outputText value="#{labels.roomTitle}"/>
</title>
    <link href="../css/gameroomStyle.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <!--<script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/interface/UserManager.js'></script>  -->
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='gameRoom.js'></script>
    <script type='text/javascript' src='/dwr/interface/DwrController.js'></script>
</head>
<body onload='refresh()'>
<div id="container">
    <div id="header">
        <div id="logo"><img src="../images/logo.png" class="logo" alt="Yahtzee"/></div>
        <div id="links">
            <h2>
                <a href="/faces/player/startNewGame.jsp">
                    <h:outputText value="#{labels.roomStart}"/>
                </a> | <a href="/faces/profile/changeProfile.jsp">
                <h:outputText value="#{labels.roomProfile}"/>
            </a> | <a href="/logout/LogoutServlet">
                <h:outputText value="#{labels.logout}"/>
            </a>
            </h2>
        </div>
    </div>
    <div id="roomsContainer">
        <div class="tekst"><span class="welkom"><h:outputText
                value="#{labels.welcomeMessage}"/>, </span>${userBean.name}<br/></div>
        <div class="hr">
            <hr/>
        </div>
        <div id="roomsWrapper">
            <div id="rooms">
                <h3>
                    <h:outputText value="#{labels.room}"/>
                </h3>

                <div id="roomTable">
                    <table width="595" class="header">
                        <tr>
                            <th width="140">
                                <h:outputText value="#{labels.roomName}"/>
                            </th>
                            <th width="85">
                                <h:outputText value="#{labels.roomMax}"/>
                            </th>
                            <th width="215">
                                <h:outputText value="#{labels.roomPlayers}"/>
                            </th>
                            <th width="75">
                                <h:outputText value="#{labels.roomState}"/>
                            </th>
                            <th width="90">
                                <h:outputText value="#{labels.roomAction}"/>
                            </th>
                        </tr>
                    </table>

                </div>
                <div id="gamesWrapper">
                    <div id="games">
                    </div>
                </div>
            </div>
            <div id="chat">
                <h3 class="chatTekst">
                    <h:outputText value="#{labels.chatTitle}"/>
                </h3>

                <div id="chatlog" class="top"></div>
                <input type="text" id="text" class="bottom" onkeypress="DWRUtil.onReturn(event, sendMessage)">
                <input id="name" type="hidden" value="${userBean.username}">
                <input type="button" onClick="sendMessage()" value="<h:outputText value="#{labels.chatButton}"/>"
                       name="btnSend" class="btn">
            </div>
        </div>
        <div id="footer">
            <div id="onlineContainer">
                <div id="users">
                    <h:outputText value="#{labels.roomOnline}"/>
                    :
                </div>
                <div id="onlineUsers"></div>
            </div>
            <div class="hr">
                <hr/>
            </div>
            <div id="footerTekst">
                <a href="info.jsp"
                   onclick="window.open('info.jsp','Info','width=300,height=225,scrollbars=no,toolbar=no,location=no,resizable=no,menubar=no'); return false">
                    <h:outputText value="#{labels.roomInfo}"/>
                </a> | <a href="help.html"
                          onclick="window.open('help.jsp','Help','width=500,height=400,scrollbars=yes,toolbar=no,location=no,resizable=no,menubar=no'); return false">
                <h:outputText value="#{labels.roomHelp}"/>
            </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</f:view>