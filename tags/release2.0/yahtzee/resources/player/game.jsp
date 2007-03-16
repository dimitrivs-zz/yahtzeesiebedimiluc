<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>
<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>

<f:view locale="#{language}">
<f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head>
<link href="../css/gameStyle.css" rel="stylesheet" type="text/css"/>
<title>
    <h:outputText value="#{labels.gameTitle}"/>
    (${gameBean.gameName})</title>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/DwrController.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>

<script type="text/javascript">
var loadPlayerTimeout;
var keepDiceUpdatedTimeout;
var getActivePlayerTimeout;
var keepPlayersUpdatedTimeout;
var gotMessagesTimeout;
var isGameFinishedTimeout;
var playersArray = new Array();
var activePlayer = '';
var numberRolls = 0;
var numberTurns = 0;
var numberTurnsOld = 0;

function init() {
    loadPlayers();
    DwrController.getCreator('${gameBean.gameName}',
            function(creator) {
                if (creator != '${userBean.username}') {
                    document.getElementById('btnStart').style.visibility = 'hidden';
                }
            }
            );
    document.getElementById('btnRoll').style.visibility = 'hidden';
    getActivePlayer();
    isGameFinished();
}

function isGameFinished() {
    DwrController.isGameFinished('${gameBean.gameName}',
            function(gameStateFinished) {
                if (gameStateFinished) {
                    clearTimeout(getActivePlayerTimeout);
                    clearTimeout(loadPlayerTimeout);
                    clearTimeout(keepPlayersUpdatedTimeout);
                    clearTimeout(keepDiceUpdatedTimeout);
                    clearTimeout(gotMessagesTimeout);
                    clearTimeout(isGameFinishedTimeout);
                    DWRUtil.setValue('gameState', 'Game finished. Redirecting...');
                    window.location = '../../game/FinishGameServlet?game=${gameBean.gameName}';
                }
            }
            );
    isGameFinishedTimeout = setTimeout("isGameFinished()", 1000);
}

function getActivePlayer() {
    DwrController.getActivePlayer('${gameBean.gameName}',
            function(playerName) {
                if (activePlayer == '') {
                    activePlayer = playerName;
                }
                if (activePlayer != playerName || (playersArray.length == 1 && numberTurns > numberTurnsOld)) {
                    numberTurnsOld = numberTurns;
                    DWRUtil.setValue('gameState', playerName + ' <h:outputText value="#{labels.gamePlaying}"/>...');
                    numberRolls = 0;
                    if (playerName == '${userBean.username}') {
                        //if (numberTurns > 12) {
                        //    window.location = '../../game/FinishGameServlet?game=${gameBean.gameName}';
                        //} else {
                        clearTimeout(keepDiceUpdatedTimeout);
                        calculateScores();
                        document.getElementById('btnRoll').style.visibility = 'visible';
                        document.getElementById('btnRoll').disabled = false;
                        //}
                    }
                    resetDice();
                    activePlayer = playerName;
                }
            }
            );
    getActivePlayerTimeout = setTimeout('getActivePlayer()', 1000);
}

function loadPlayers() {
    document.getElementById('p1table').style.visibility = 'hidden';
    document.getElementById('p2table').style.visibility = 'hidden';
    document.getElementById('p3table').style.visibility = 'hidden';
    document.getElementById('p4table').style.visibility = 'hidden';
    DwrController.getUsersOfGame('${gameBean.gameName}', playersLoaded);
}
function playersLoaded(players) {
    playersArray.length = 0;
    var i = 0;
    for (var user in players) {
        playersArray[i] = new Array();
        playersArray[i][0] = players[user].username;
        i++;
        document.getElementById('p' + i + 'table').style.visibility = 'visible';
        DWRUtil.setValue('p' + i + 'name', players[user].username);
    }
    loadPlayerTimeout = setTimeout('loadPlayers()', 1000);
    DwrController.getGameState('${gameBean.gameName}', function(state) {
        if (state == 'Busy') {
            startGame();
        }
    })
}

function keepPlayersUpdated() {
    DwrController.getUsersOfGame('${gameBean.gameName}',
            function(playersList) {
                if (playersList.length != playersArray.length) {
                    var testArray = new Array();
                    var i = 0;
                    for (var player in playersList) {
                        testArray[i] = playersList[player].username;
                        i++;
                    }
                    for (i = 0; i < playersArray.length; i++) {
                        if (playersArray[i][0] != testArray[i]) {
                            removePlayer(playersArray[i][0]);
                            break;
                        }
                    }
                    i = 0;
                    playersArray.length = 0;
                    for (var player in playersList) {
                        playersArray[i] = new Array();
                        playersArray[i][0] = playersList[player].username;
                        i++;
                    }
                }
            }
            );
    keepPlayersUpdatedTimeout = setTimeout('keepPlayersUpdated()', 5000);
}

function removePlayer(playerUsername) {
    if (DWRUtil.getValue('p1name') == playerUsername) document.getElementById('p1table').style.visibility = 'hidden';
    if (DWRUtil.getValue('p2name') == playerUsername) document.getElementById('p2table').style.visibility = 'hidden';
    if (DWRUtil.getValue('p3name') == playerUsername) document.getElementById('p3table').style.visibility = 'hidden';
    if (DWRUtil.getValue('p4name') == playerUsername) document.getElementById('p4table').style.visibility = 'hidden';
}

function startGame() {
    DWRUtil.setValue('gameState', '<h:outputText value="#{labels.gameStarting}"/>...');
    DwrController.startGame('${gameBean.gameName}', gameStarted);
}

function gameStarted(state) {
    if (state == 'Busy') {
        document.getElementById('btnStart').style.visibility = 'hidden';
        document.getElementById('btnStart').disabled = true;
        DwrController.getActivePlayer('${gameBean.gameName}',
                function(player) {
                    if (player == '${userBean.username}') {
                        document.getElementById('btnRoll').style.visibility = 'visible';
                        document.getElementById('btnRoll').disabled = false;
                    } else {
                        keepDiceUpdated();
                    }
                    calculateScores();
                    keepPlayersUpdated();
                    document.getElementById('p1name').style.visibility = 'hidden';
                    document.getElementById('p2name').style.visibility = 'hidden';
                    document.getElementById('p3name').style.visibility = 'hidden';
                    document.getElementById('p4name').style.visibility = 'hidden';
                    DWRUtil.setValue('gameState', player + ' <h:outputText value="#{labels.gamePlaying}"/>...');
                }
                );
        DWRUtil.setValue('gameState', '<h:outputText value="#{labels.gameStarted}"/>.');
        clearTimeout(loadPlayerTimeout);
    } else {
        startGame();
    }
}
function keepDiceUpdated() {
    DwrController.getDiceList('${gameBean.gameName}',
            function(diceList) {
                var i = 0;
                resetDice();
                for (var die in diceList)
                {
                    if (!diceList[die].dieFixed) {
                        document.getElementById('dice' + i + 'notFixedImg').src = '../../images/die' + diceList[die].value + '.png';
                        document.getElementById('dice' + i + 'notFixedImg').alt = diceList[die].value;
                        document.getElementById('dice' + i + 'notFixed').style.visibility = 'visible';
                    } else {
                        document.getElementById('dice' + i + 'fixedImg').src = '../../images/die' + diceList[die].value + '.png';
                        document.getElementById('dice' + i + 'fixedImg').alt = diceList[die].value;
                        document.getElementById('dice' + i + 'fixed').style.visibility = 'visible';
                    }
                    i++;
                }
            }
            );
    keepDiceUpdatedTimeout = setTimeout('keepDiceUpdated()', 2000);
}

function rollDice() {
    if (numberRolls < 3) {
        DwrController.playRound('${gameBean.gameName}', getDice);
        numberRolls++;
        if (numberRolls == 3) {
            document.getElementById('btnRoll').style.visibility = 'hidden';
            document.getElementById('btnRoll').disabled = true;
        }
    }
}
function getDice(diceList) {
    var i = 0;
    for (var die in diceList)
    {
        document.getElementById('dice' + i + 'notFixedImg').alt = diceList[die].value;
        document.getElementById('dice' + i + 'notFixedImg').src = '../../images/die' + diceList[die].value + '.png';
        if (!diceList[die].dieFixed) {
            document.getElementById('dice' + i + 'notFixed').style.visibility = 'visible';
        }
        i++;
    }
    DwrController.getScorePossibilities('${gameBean.gameName}', showScorePossibilities);
}

function showScorePossibilities(scorePossibilitiesList) {
    var table = '<table class="scores"><tr><th><h:outputText value="#{labels.gameScore}"/></th><th><h:outputText value="#{labels.gamePoints}"/></th></tr>';
    for (var scoreAspect in scorePossibilitiesList) {
        table += '<tr onclick="selectScore(\'' + scorePossibilitiesList[scoreAspect].description + '\')"><td>' + scorePossibilitiesList[scoreAspect].description + '</td>';
        table += '<td class="center">' + scorePossibilitiesList[scoreAspect].points + '</td></tr>';
    }
    table += '</table>';
    DWRUtil.setValue('possibleScores', table);
    document.getElementById('possibleScores').style.visibility = 'visible';
}

function selectScore(scoreDescription) {
    DwrController.selectScore('${gameBean.gameName}', scoreDescription, emptyFunc);
    resetDice();
    document.getElementById('possibleScores').style.visibility = 'hidden';
    document.getElementById('btnRoll').style.visibility = 'hidden';
    document.getElementById('btnRoll').disabled = true;
    calculateScores();
    numberTurns++;
    keepDiceUpdated();
}

var cellFuncs = [
        function(data) {
            return data;
        }
        ];
var count = 1;

function calculateScores() {
    DwrController.getScores('${gameBean.gameName}',
            function(scores) {
                var scoreArray = new Array();
                var i = 1;
                for (var score in scores) {
                    DWRUtil.removeAllRows('p' + i + 'score');
                    scoreArray[0] = '<b>' + score + '</b>';
                    scoreArray[1] = scores[score].ones;
                    scoreArray[2] = scores[score].twos;
                    scoreArray[3] = scores[score].threes;
                    scoreArray[4] = scores[score].fours;
                    scoreArray[5] = scores[score].fives;
                    scoreArray[6] = scores[score].sixes;
                    scoreArray[7] = scores[score].upperHalfWithoutBonus;
                    scoreArray[8] = scores[score].upperHalfBonus;
                    scoreArray[9] = scores[score].totalUpperHalf;
                    scoreArray[10] = scores[score].threeOfAKind;
                    scoreArray[11] = scores[score].carre;
                    scoreArray[12] = scores[score].fullHouse;
                    scoreArray[13] = scores[score].smallStreet;
                    scoreArray[14] = scores[score].largeStreet;
                    scoreArray[15] = scores[score].yahtzee;
                    scoreArray[16] = scores[score].chance;
                    scoreArray[17] = scores[score].yahtzeeBonus;
                    scoreArray[18] = scores[score].totalLowerHalf;
                    scoreArray[19] = scores[score].totalScore;
                    DWRUtil.addRows('p' + i + 'score', scoreArray, cellFuncs);
                    i++
                }
            }
            );
}

function emptyFunc(score) {
}

function resetDice() {
    for (var i = 0; i < 5; i++) {
        document.getElementById('dice' + i + 'notFixed').style.visibility = 'hidden';
        document.getElementById('dice' + i + 'fixed').style.visibility = 'hidden';
    }
}

function fixDice(diceNr, state) {
    if (activePlayer == '${userBean.username}') {
        if (state) {
            DwrController.fixDie('${gameBean.gameName}', diceNr);
            document.getElementById('dice' + diceNr + 'notFixed').style.visibility = 'hidden';
            document.getElementById('dice' + diceNr + 'fixedImg').src = '../../images/die' + document.getElementById('dice' + diceNr + 'notFixedImg').alt + '.png';
            document.getElementById('dice' + diceNr + 'fixedImg').alt = document.getElementById('dice' + diceNr + 'notFixedImg').alt;
            document.getElementById('dice' + diceNr + 'fixed').style.visibility = 'visible';
        } else {
            DwrController.unfixDie('${gameBean.gameName}', diceNr);
            document.getElementById('dice' + diceNr + 'fixed').style.visibility = 'hidden';
            document.getElementById('dice' + diceNr + 'notFixedImg').src = '../../images/die' + document.getElementById('dice' + diceNr + 'fixedImg').alt + '.png';
            document.getElementById('dice' + diceNr + 'notFixedImg').alt = document.getElementById('dice' + diceNr + 'fixedImg').alt;
            document.getElementById('dice' + diceNr + 'notFixed').style.visibility = 'visible';
        }
    }

}

// chat functions
function sendMessage() {
    var text = DWRUtil.getValue("text");
    if (text != '' && text != ' ') {
        DWRUtil.setValue("text", "");
        DwrController.addMessage("${userBean.name}: " + text + "\n", '${gameBean.gameName}', gotMessages);
    }
}
function checkMessages() {
    DwrController.getMessages('${gameBean.gameName}', gotMessages);
}
function gotMessages(messages) {
    var chatlog = "";
    for (var data in messages) {
        chatlog = messages[data] + chatlog;
    }
    DWRUtil.setValue("chatlog", chatlog);
    gotMessagesTimeout = setTimeout("checkMessages()", 1000);
}

</script>
</head>
<body onload='checkMessages(); init();'>
<div id="container">
<div id="header">
    <div id="logo"><img src="../images/logo.png" class="logo" alt="Yahtzee"/></div>
    <div class="headertekst">
        <h2>
            <span class="luck"><h:outputText value="#{labels.gameLuck}"/>, </span>${userBean.name}
            | <a href="/game/LeaveGameServlet?leave=${gameBean.gameName}">
            <h:outputText value="#{labels.gameLeave}"/>
        </a>
        </h2>
    </div>
</div>
<div id="scoresContainer">
    <div id="possibleScores" class="dragdropwindow"></div>
</div>
<div id="gameContainer">
<div id="game">
<table border="0" cellspacing="0">
<tr>
<td>
    <table class="dice">
        <tr>
            <td height="150">
                            <span id="dice0notFixed" class="dice" onclick="fixDice(0, true)"
                                  style="visibility: hidden"><img src="" id="dice0notFixedImg" alt=""></span>
                            <span id="dice1notFixed" class="dice" onclick="fixDice(1, true)"
                                  style="visibility: hidden"><img src="" id="dice1notFixedImg" alt=""></span>
                            <span id="dice2notFixed" class="dice" onclick="fixDice(2, true)"
                                  style="visibility: hidden"><img src="" id="dice2notFixedImg" alt=""></span>
                            <span id="dice3notFixed" class="dice" onclick="fixDice(3, true)"
                                  style="visibility: hidden"><img src="" id="dice3notFixedImg" alt=""></span>
                            <span id="dice4notFixed" class="dice" onclick="fixDice(4, true)"
                                  style="visibility: hidden"><img src="" id="dice4notFixedImg" alt=""></span>
            </td>
        </tr>
        <tr>
            <td height="150">
                            <span id="dice0fixed" class="dice" onclick="fixDice(0, false)"
                                  style="visibility: hidden"><img src="" id="dice0fixedImg" alt=""></span>
                            <span id="dice1fixed" class="dice" onclick="fixDice(1, false)"
                                  style="visibility: hidden"><img src="" id="dice1fixedImg" alt=""></span>
                            <span id="dice2fixed" class="dice" onclick="fixDice(2, false)"
                                  style="visibility: hidden"><img src="" id="dice2fixedImg" alt=""></span>
                            <span id="dice3fixed" class="dice" onclick="fixDice(3, false)"
                                  style="visibility: hidden"><img src="" id="dice3fixedImg" alt=""></span>
                            <span id="dice4fixed" class="dice" onclick="fixDice(4, false)"
                                  style="visibility: hidden"><img src="" id="dice4fixedImg" alt=""></span>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="<h:outputText value="#{labels.gameStart}"/>" id="btnStart"
                       onclick="startGame()">
                <input type="button" value="<h:outputText value='#{labels.gameRoll}'/>" id="btnRoll" disabled="disabled"
                       onclick="rollDice()">
            </td>
        </tr>
    </table>
</td>
<td>


<table border="0">
<tr>
<td>
<table border="0">
    <tr>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameOnes}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameTwos}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameThrees}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameFours}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameFives}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameSixes}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameTotalUpper}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameBonusUpper}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameUpper}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameThree}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameCarre}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameHouse}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameSmall}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameLarge}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.yahtzee}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameChance}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameBonus}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameTotalLower}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h:outputText value="#{labels.gameTotal}"/>
        </td>
    </tr>
</table>
</td>
<td width="150">
                <span id="p1table">
                    <table width="20" class="player">
                        <thead>
                            <tr>
                                <th id="p1name"></th>
                            </tr>
                        </thead>
                        <tbody id="p1score"></tbody>
                    </table>
                </span>
                <span id="p2table">
                    <table width="20" class="player">
                        <thead>
                            <tr>
                                <th id="p2name"></th>
                            </tr>
                        </thead>
                        <tbody id="p2score"></tbody>
                    </table>
                </span>
                <span id="p3table">
                    <table width="20" class="player">
                        <thead>
                            <tr>
                                <th id="p3name"></th>
                            </tr>
                        </thead>
                        <tbody id="p3score"></tbody>
                    </table>
                </span>
                <span id="p4table">
                    <table width="20" class="player">
                        <thead>
                            <tr>
                                <th id="p4name"></th>
                            </tr>
                        </thead>
                        <tbody id="p4score"></tbody>
                    </table>
                </span>
</td>
</tr>
</table>
</td>
<td>
    <div id="chat">
        <h3 class="chatTekst">
            <h:outputText value="#{labels.chatTitle}"/>
        </h3>
        <textarea id="chatlog" rows="10" cols="25" readonly="readonly" class="top"></textarea>
        <input id="text" type="text" size="25" onkeypress="DWRUtil.onReturn(event, sendMessage)"/>
        <input type="button" onclick="sendMessage()" value="<h:outputText value="#{labels.chatButton}"/>" name="btnSend"
               id="btnChat">
    </div>
</td>
</tr>
</table>
<h2 style="color: #ff0000">
    <div id="gameState">
        <h:outputText value="#{labels.gameWait}"/>
        ...
    </div>
</h2>
</div>
</div>
</div>
</body>
</html>
</f:view>