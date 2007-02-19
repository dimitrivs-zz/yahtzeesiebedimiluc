<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>
<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>
<html>
<head><title>Yahtzee spel (${gameBean.gameName})</title>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>

<script type="text/javascript">
var numberRolls = 0;
function rollDice() {
    if (numberRolls < 3) {
        GameManager.playRound(getDice, '${gameBean.gameName}');
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
    GameManager.getScorePossibilities(buildScores, '${gameBean.gameName}');
}
function fixDice(diceNr, state) {
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
var timeoutId;
var blinkObjects = new Array();
function buildScores(scoreList) {
    blinkObjects.length = 0;
    clearTimeout(timeoutId);
    var i = 0;
    for (var scoreaspect in scoreList) {
        DWRUtil.setValue('p1' + scoreList[scoreaspect].description, scoreList[scoreaspect].points);
        if (!scoreList[scoreaspect].fixed) {
            blinkObjects[i] = 'p1' + scoreList[scoreaspect].description;
            i++;
        }
    }
    blink();
}
var j = 0;
function blink() {
    for (var i = 0; i < blinkObjects.length; i++) {
        if (j % 2 == 0) {
            document.getElementById(blinkObjects[i]).style.backgroundColor = '#ccffcc';
        } else {
            document.getElementById(blinkObjects[i]).style.backgroundColor = '#ffffff';
        }
    }
    if (j < 1) {
        j++;
    } else {
        j--;
    }
    timeoutId = setTimeout("blink()", 500);
}
function selectScore(id) {
    if (numberRolls != 0 && document.getElementById(id).style.backgroundColor != '#ff0000') {
        clearTimeout(timeoutId);
        for (var i = 0; i < blinkObjects.length; i++) {
            document.getElementById(blinkObjects[i]).style.backgroundColor = '#ffffff';
            if (blinkObjects[i] != id) {
                DWRUtil.setValue(blinkObjects[i], '0');
            }
        }
        GameManager.selectScore('${gameBean.gameName}', id.substr(2, id.length - 2));
        document.getElementById(id).style.backgroundColor = '#ff0000';
        numberRolls = 0;
        resetDice();
        document.getElementById('btnRoll').disabled = false;
        GameManager.getTotals(calculateTotals, '${gameBean.gameName}');
    }
}
function calculateTotals(totals) {
    var i = 0;
    for (var total in totals) {
        if (i == 0) {
            DWRUtil.setValue(document.getElementById('p1upper'), totals[i]);
            if (totals[i] > 62) {
                DWRUtil.setValue(document.getElementById('p1upperbonus'), totals[i]);
            } else {
                DWRUtil.setValue(document.getElementById('p1upperbonus'), 0);
            }
        }
        if (i == 1) DWRUtil.setValue(document.getElementById('p1upperTotal'), totals[i]);
        if (i == 2) DWRUtil.setValue(document.getElementById('p1lowerTotal'), totals[i]);
        if (i == 3) DWRUtil.setValue(document.getElementById('p1total'), totals[i]);
        i++;
    }
}
function resetDice() {
    for (var i = 0; i < 5; i++) {
        document.getElementById('dice' + i + 'notFixed').style.visibility = 'hidden';
        document.getElementById('dice' + i + 'fixed').style.visibility = 'hidden';
    }
}

function sendMessage()
{
    var text = DWRUtil.getValue("text");
    DWRUtil.setValue("text", "");
    GameManager.addMessage("${userBean.name}: " + text + "\n", '${gameBean.gameName}', gotMessages);
}

function checkMessages()
{
    GameManager.getMessages('${gameBean.gameName}', gotMessages);
    GameManager.getUsersOfGame('${gameBean.gameName}', displayUsers);
}

function displayUsers(messages) {
    var users = "";
    for (var user in messages) {
        users += messages[user].username + "\n"
    }
    DWRUtil.setValue("testDiv", users);
}

function gotMessages(messages)
{
    var chatlog = "";
    for (var data in messages)
    {
        chatlog = messages[data].text + chatlog;
    }
    DWRUtil.setValue("chatlog", chatlog);
    setTimeout("checkMessages()", 1000);
}
</script>
<style type="text/css">
    .dice {
        width: 20px;
        height: 20px;
        font-family: arial, sans-serif;
        font-size: 12px;
        font-weight: bold;
        border: 1px solid #000000;
        padding: 2px;
    }

    textarea {
        font-family: arial, sans-serif;
        font-size: 12px;
    }
</style>
</head>


<body onload='checkMessages()'>
<center>
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
                        <td>player, is playing</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="roll" name="btnRoll" id="btnRoll" onclick="rollDice()">
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <yahtzee:scoreCard/>

            </td>
            <td>
                <table border="1">
                    <tr>
                        <td>Chat</td>
                    </tr>
                    <tr>
                        <td>
                            <div id="chatlog" style="width:100px; height:100px;overflow: auto"></div>
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
                    <tr>
                        <td>
                            <div id="testDiv">

                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</center>
</body>
</html>