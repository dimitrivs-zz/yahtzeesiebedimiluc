<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="yahtzee" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<html>
<head><title>Spel overzicht</title>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/interface/GameManager.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript'>
        <!--
        function checkMessages() {
            var inorde = 0
            if (inorde == 0) {
                div = document.getElementById("testdiv")
                inorde = 1
            }
            var text = "hallo"
            var code =
        <yahtzee:showGame href="/game/JoinGameServlet"/>
            var newElement = document.createElement("div")
            var newText = document.createTextNode(code)
            newElement.appendChild(newText)
            div.appendChild(newElement)
            document.getElementById("testdiv").appendChild()
        }    -->
    </script>
</head>
<body>

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