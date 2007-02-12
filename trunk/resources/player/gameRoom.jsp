<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>


<!-- testje van dimi -->
<html>
<head><title>Spel overzicht</title>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript">
        var table = '<table border="1"><tr><th>Spelnaam</th><th>Aantal</th><th>Spelers in het spel</th><th>Status</th></tr>'

        function checkMessages()
        {
            GameManager.getGames(gotMessages)
            table += "</table>"
            DWRUtil.setValue("testDiv", table)
        }
        function gotMessages(messages)
        {
            for (var game in messages)
            {
                table += "<tr><td>" + game.gameName + "</td></tr>"
            }
            setTimeout("checkMessages()", 1000);
        }
    </script>
</head>
<body onload="setTimeout('checkMessages()', 1000)">

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
                        <td>Wijzig profiel</td>
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
    <yahtzee:showGame href="/game/JoinGameServlet"/>
    <yahtzee:showUsers/>
</p>

<div id="testDiv">

</div>


<p>
    <font color="RED">${error}</font>
</p>
</body>
</html>