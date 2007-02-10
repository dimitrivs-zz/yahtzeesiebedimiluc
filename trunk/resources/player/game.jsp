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
        function rollDice() {
            GameManager.playRound(getDice, '${gameBean.gameName}');
        }
        function getDice(diceList) {
            var dices = '';
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
        function buildScores(scoreList) {
            for (var scoreaspect in scoreList) {
                alert(scoreList[scoreaspect].description + ' / ' + scoreList[scoreaspect].points);
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
    </style>
</head>


<body onload="setTimeout('checkMessages()', 1000)">
<center>
    hallo
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
                            <input type="button" value="roll" name="btnRoll" onclick="rollDice()">
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
                </table>
            </td>
        </tr>
    </table>
</center>
</body>
</html>