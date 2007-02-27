<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>


<f:view locale="#{language}">
<f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head><title>Simple jsp page</title>

    <link href="../css/gameStyle.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>

    <script type="text/javascript">
        var cellFuncs = [
                function(data) {
                    return data;
                }
                ];
        var scoreArray = new Array();
        function init() {
            for (var i = ${gameBean.numberOfPlayers}; i > 0; i--) {
                document.getElementById('p' + i + 'table').style.visibility = 'visible';
            }
            GameManager.getScores('${gameBean.gameName}',
                    function(scores) {
                        var scoreArray = new Array();
                        var i = 1;
                        for (var score in scores) {
                            DWRUtil.setValue('p' + i + 'name', score);
                            DWRUtil.removeAllRows('p' + i + 'score');
                            scoreArray[0] = scores[score].ones;
                            scoreArray[1] = scores[score].twos;
                            scoreArray[2] = scores[score].threes;
                            scoreArray[3] = scores[score].fours;
                            scoreArray[4] = scores[score].fives;
                            scoreArray[5] = scores[score].sixes;
                            scoreArray[6] = '<b>' + scores[score].upperHalfWithoutBonus + '</b>';
                            scoreArray[7] = '<b>' + scores[score].upperHalfBonus + '</b>';
                            scoreArray[8] = '<b>' + scores[score].totalUpperHalf + '</b>';
                            scoreArray[9] = scores[score].threeOfAKind;
                            scoreArray[10] = scores[score].carre;
                            scoreArray[11] = scores[score].fullHouse;
                            scoreArray[12] = scores[score].smallStreet;
                            scoreArray[13] = scores[score].largeStreet;
                            scoreArray[14] = scores[score].yahtzee;
                            scoreArray[15] = scores[score].chance;
                            scoreArray[16] = scores[score].yahtzeeBonus;
                            scoreArray[17] = '<b>' + scores[score].totalLowerHalf + '</b>';
                            scoreArray[18] = '<b style="color: #ffff00">' + scores[score].totalScore + '</b>';
                            DWRUtil.addRows('p' + i + 'score', scoreArray, cellFuncs);
                            i++
                        }
                    });
        }

    </script>
</head>
<body onload="init()">
<h1>Samenvatting spel ${gameBean.gameName}</h1>
<table>
<tr>
<td>
<table>
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
            <b>
                <h:outputText value="#{labels.gameTotalUpper}"/>
            </b>
        </td>
    </tr>
    <tr>
        <td>
            <b>
                <h:outputText value="#{labels.gameBonusUpper}"/>
            </b>
        </td>
    </tr>
    <tr>
        <td>
            <b>
                <h:outputText value="#{labels.gameUpper}"/>
            </b>
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
            <b>
                <h:outputText value="#{labels.gameTotalLower}"/>
            </b>
        </td>
    </tr>
    <tr>
        <td>
            <b style="color: #ffff00">
                <h:outputText value="#{labels.gameTotal}"/>
            </b>
        </td>
    </tr>
</table>
</td>
<td width="150">
                  <span id="p1table">
                      <table width="20">
                          <thead>
                              <tr>
                                  <th id="p1name"></th>
                              </tr>
                          </thead>
                          <tbody id="p1score"></tbody>
                      </table>
                  </span>
                  <span id="p2table">
                      <table width="20">
                          <thead>
                              <tr>
                                  <th id="p2name"></th>
                              </tr>
                          </thead>
                          <tbody id="p2score"></tbody>
                      </table>
                  </span>
                  <span id="p3table">
                      <table width="20">
                          <thead>
                              <tr>
                                  <th id="p3name"></th>
                              </tr>
                          </thead>
                          <tbody id="p3score"></tbody>
                      </table>
                  </span>
                  <span id="p4table">
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

</body>

</html>
</f:view>