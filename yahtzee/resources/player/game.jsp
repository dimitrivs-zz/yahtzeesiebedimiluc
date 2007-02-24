<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>
<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>
<html>
<head>
<link href="../css/gameStyle.css" rel="stylesheet" type="text/css"/>
<title>Yahtzee spel (${gameBean.gameName})</title>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>

<script type="text/javascript">
var loadPlayerTimeout;
var keepDiceUpdatedTimeout;
var playersArray = new Array();
var activePlayer = '';
var numberRolls = 0;
var numberTurns = 0;
var numberTurnsOld = 0;

function init() {
    loadPlayers();
    GameManager.getCreator('${gameBean.gameName}',
            function(creator) {
                if (creator != '${userBean.username}') {
                    document.getElementById('btnStart').style.visibility = 'hidden';
                }
            }
            );
    getActivePlayer();
}

function getActivePlayer() {
    GameManager.getActivePlayer('${gameBean.gameName}',
            function(playerName) {
                if (activePlayer == '') {
                    activePlayer = playerName;
                }
                if (activePlayer != playerName || (playersArray.length == 1 && numberTurns > numberTurnsOld)) {
                    numberTurnsOld = numberTurns;
                    DWRUtil.setValue('gameState', playerName + ' is playing...');
                    numberRolls = 0;
                    if (playerName == '${userBean.username}') {
                        if (numberTurns > 12) {
                            window.location = 'gameFinish.jsp';
                        } else {
                            clearTimeout(keepDiceUpdatedTimeout);
                            calculateScores();
                            document.getElementById('btnRoll').disabled = false;
                        }
                    }
                    resetDice();
                    activePlayer = playerName;
                }
            }
            );
    setTimeout('getActivePlayer()', 1000);
}

function loadPlayers() {
    document.getElementById('p1table').style.visibility = 'hidden';
    document.getElementById('p2table').style.visibility = 'hidden';
    document.getElementById('p3table').style.visibility = 'hidden';
    document.getElementById('p4table').style.visibility = 'hidden';
    GameManager.getUsersOfGame('${gameBean.gameName}', playersLoaded);
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
    GameManager.getGameState('${gameBean.gameName}', function(state) {
        if (state == 'Busy') {
            startGame();
        }
    })
}

function startGame() {
    DWRUtil.setValue('gameState', 'Starting yahtzee game...');
    GameManager.startGame('${gameBean.gameName}', gameStarted);
}

function gameStarted(state) {
    if (state == 'Busy') {
        document.getElementById('btnStart').disabled = true;
        GameManager.getActivePlayer('${gameBean.gameName}',
                function(player) {
                    if (player == '${userBean.username}') {
                        document.getElementById('btnRoll').disabled = false;
                        calculateScores();
                    } else {
                        keepDiceUpdated();
                    }
                    DWRUtil.setValue('gameState', player + ' is playing...');
                }
                );
        DWRUtil.setValue('gameState', 'Yahtzee game started.');
        clearTimeout(loadPlayerTimeout);
    } else {
        startGame();
    }
}
function keepDiceUpdated() {
    GameManager.getDiceList('${gameBean.gameName}',
            function(diceList) {
                var i = 0;
                resetDice();
                for (var die in diceList)
                {
                    if (!diceList[die].dieFixed) {
                        DWRUtil.setValue('dice' + i + 'notFixed', diceList[die].value);
                        document.getElementById('dice' + i + 'notFixed').style.visibility = 'visible';
                    } else {
                        DWRUtil.setValue('dice' + i + 'fixed', diceList[die].value);
                        document.getElementById('dice' + i + 'fixed').style.visibility = 'visible';
                    }
                    i++;
                }
            }
            );
    calculateScores();
    keepDiceUpdatedTimeout = setTimeout('keepDiceUpdated()', 2000);
}

function rollDice() {
    if (numberRolls < 3) {
        GameManager.playRound('${gameBean.gameName}', getDice);
        numberRolls++;
        if (numberRolls == 3) {
            document.getElementById('btnRoll').disabled = true;
        }
    }
}
function getDice(diceList) {
    var i = 0;
    for (var die in diceList)
    {
        DWRUtil.setValue('dice' + i + 'notFixed', diceList[die].value)
        if (!diceList[die].dieFixed) {
            document.getElementById('dice' + i + 'notFixed').style.visibility = 'visible';
        }
        i++;
    }
    GameManager.getScorePossibilities('${gameBean.gameName}', showScorePossibilities);
}

function showScorePossibilities(scorePossibilitiesList) {
    var table = '<table border="1"><tr><th>Score possibility</th><th>Points</th></tr>';
    for (var scoreAspect in scorePossibilitiesList) {
        table += '<tr onclick="selectScore(\'' + scorePossibilitiesList[scoreAspect].description + '\')"><td>' + scorePossibilitiesList[scoreAspect].description + '</td>';
        table += '<td>' + scorePossibilitiesList[scoreAspect].points + '</td></tr>';
    }
    table += '</table>';
    DWRUtil.setValue('possibleScores', table);
    document.getElementById('possibleScores').style.visibility = 'visible';
}

function selectScore(scoreDescription) {
    GameManager.selectScore('${gameBean.gameName}', scoreDescription, emptyFunc);
    resetDice();
    document.getElementById('possibleScores').style.visibility = 'hidden';
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
    GameManager.getScores('${gameBean.gameName}',
            function(scores) {
                var scoreArray = new Array();
                var i = 1;
                for (var score in scores) {
                    DWRUtil.removeAllRows('p' + i + 'score');
                    scoreArray[0] = scores[score].ones;
                    scoreArray[1] = scores[score].twos;
                    scoreArray[2] = scores[score].threes;
                    scoreArray[3] = scores[score].fours;
                    scoreArray[4] = scores[score].fives;
                    scoreArray[5] = scores[score].sixes;
                    scoreArray[6] = scores[score].upperHalfWithoutBonus;
                    scoreArray[7] = scores[score].upperHalfBonus;
                    scoreArray[8] = scores[score].totalUpperHalf;
                    scoreArray[9] = scores[score].threeOfAKind;
                    scoreArray[10] = scores[score].carre;
                    scoreArray[11] = scores[score].fullHouse;
                    scoreArray[12] = scores[score].smallStreet;
                    scoreArray[13] = scores[score].largeStreet;
                    scoreArray[14] = scores[score].yahtzee;
                    scoreArray[15] = scores[score].chance;
                    scoreArray[16] = scores[score].yahtzeeBonus;
                    scoreArray[17] = scores[score].totalLowerHalf;
                    scoreArray[18] = scores[score].totalScore;
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
            GameManager.fixDie('${gameBean.gameName}', diceNr);
            DWRUtil.setValue('dice' + diceNr + 'fixed', DWRUtil.getValue('dice' + diceNr + 'notFixed'));
            document.getElementById('dice' + diceNr + 'fixed').style.visibility = 'visible';
            document.getElementById('dice' + diceNr + 'notFixed').style.visibility = 'hidden';
        } else {
            GameManager.unfixDie('${gameBean.gameName}', diceNr);
            DWRUtil.setValue('dice' + diceNr + 'notFixed', DWRUtil.getValue('dice' + diceNr + 'fixed'));
            document.getElementById('dice' + diceNr + 'notFixed').style.visibility = 'visible';
            document.getElementById('dice' + diceNr + 'fixed').style.visibility = 'hidden';
        }
    }

}

function sendMessage() {
    var text = DWRUtil.getValue("text");
    if (text != '' && text != ' ') {
        DWRUtil.setValue("text", "");
        GameManager.addMessage("${userBean.name}: " + text + "\n", '${gameBean.gameName}', gotMessages);
    }
}
function checkMessages() {
    GameManager.getMessages('${gameBean.gameName}', gotMessages);
}

function gotMessages(messages) {
    var chatlog = "";
    for (var data in messages) {
        chatlog = messages[data].text + chatlog;
    }
    DWRUtil.setValue("chatlog", chatlog);
    setTimeout("checkMessages()", 1000);
}
</script>
</head>


<body onload='checkMessages(); init();'>
<div id="container">
<div id="possibleScores"></div>
<div id="game">
<table>
<tr>
    <td colspan="3" align="center"><h1>Good luck, ${userBean.name}</h1></td>
</tr>
<tr>
<td>
    <table border="1">
        <tr>
            <td width="150" height="150">
                            <span id="dice0notFixed" class="dice" onclick="fixDice(0, true)"
                                  style="visibility: hidden"></span>
                            <span id="dice1notFixed" class="dice" onclick="fixDice(1, true)"
                                  style="visibility: hidden"></span>
                            <span id="dice2notFixed" class="dice" onclick="fixDice(2, true)"
                                  style="visibility: hidden"></span>
                            <span id="dice3notFixed" class="dice" onclick="fixDice(3, true)"
                                  style="visibility: hidden"></span>
                            <span id="dice4notFixed" class="dice" onclick="fixDice(4, true)"
                                  style="visibility: hidden"></span>
            </td>
        </tr>
        <tr>
            <td width="150" height="150">
                            <span id="dice0fixed" class="dice" onclick="fixDice(0, false)"
                                  style="visibility: hidden"></span>
                            <span id="dice1fixed" class="dice" onclick="fixDice(1, false)"
                                  style="visibility: hidden"></span>
                            <span id="dice2fixed" class="dice" onclick="fixDice(2, false)"
                                  style="visibility: hidden"></span>
                            <span id="dice3fixed" class="dice" onclick="fixDice(3, false)"
                                  style="visibility: hidden"></span>
                            <span id="dice4fixed" class="dice" onclick="fixDice(4, false)"
                                  style="visibility: hidden"></span>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="start game" id="btnStart" onclick="startGame()">
                <input type="button" value="roll dice" id="btnRoll" disabled="disabled" onclick="rollDice()">
            </td>
        </tr>
    </table>
</td>
<td>


<table>
<tr>
<td>
    <table>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Count all ones</td>
        </tr>
        <tr>
            <td>Count all twos</td>
        </tr>
        <tr>
            <td>Count all threes</td>
        </tr>
        <tr>
            <td>Count all fours</td>
        </tr>
        <tr>
            <td>Count all fives</td>
        </tr>
        <tr>
            <td>Count all sixes</td>
        </tr>
        <tr>
            <td>Total upper half</td>
        </tr>
        <tr>
            <td>Upper half bonus</td>
        </tr>
        <tr>
            <td>Upper half with bonus</td>
        </tr>
        <tr>
            <td>Three of a kind</td>
        </tr>
        <tr>
            <td>Carre</td>
        </tr>
        <tr>
            <td>Full house</td>
        </tr>
        <tr>
            <td>Small street</td>
        </tr>
        <tr>
            <td>Large street</td>
        </tr>
        <tr>
            <td>Yahtzee</td>
        </tr>
        <tr>
            <td>Chance</td>
        </tr>
        <tr>
            <td>Yahtzee bonus</td>
        </tr>
        <tr>
            <td>Total lower half</td>
        </tr>
        <tr>
            <td>Grand total</td>
        </tr>
    </table>
</td>
<td width="150">
                <span id="p1table"
                      style="background-color: #aaffff; width: 20px; display: table-cell; visibility: hidden; ">
                    <table width="20">
                        <thead>
                            <tr>
                                <th id="p1name"></th>
                            </tr>
                        </thead>
                        <tbody id="p1score"></tbody>
                    </table>
                </span>
                <span id="p2table"
                      style="background-color: #aaaaff; width: 20px; display: table-cell; visibility: hidden; ">
                    <table width="20">
                        <thead>
                            <tr>
                                <th id="p2name"></th>
                            </tr>
                        </thead>
                        <tbody id="p2score"></tbody>
                    </table>
                </span>
                <span id="p3table"
                      style="background-color: #ffaaaa; width: 20px; display: table-cell; visibility: hidden; ">
                    <table width="20">
                        <thead>
                            <tr>
                                <th id="p3name"></th>
                            </tr>
                        </thead>
                        <tbody id="p3score"></tbody>
                    </table>
                </span>
                <span id="p4table"
                      style="background-color: #ffffaa; width: 20px; display: table-cell; visibility: hidden; ">
                    <table width="20">
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
        <h3 class="chatTekst">Yahtzee Chat</h3>
        <textarea id="chatlog" rows="10" cols="25" readonly="readonly" class="top"></textarea>
        <input id="text" type="text" size="25" onkeypress="DWRUtil.onReturn(event, sendMessage)"/>
        <input type="button" onclick="sendMessage()" value="send" name="btnSend" id="btnChat">
        <a href="/game/LeaveGameServlet?leave=${gameBean.gameName}">leave</a>
    </div>
</td>
</tr>
</table>
<h2 style="color: #ff0000">
    <div id="gameState">Waiting for game to be started...</div>
</h2>
</div>
</div>
</body>
</html>