<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Start nieuwe spel</title></head>
<body>
<form action="/game/NewGameServlet" method="post">
    <table>
        <tr>
            <td>spel naam: <input type="text" name = "gameName"></td>
        </tr>
        <tr>
            <td>aantal spelers: <input type="text" name = "maxPlayer"></td>
        </tr>
        <tr>
            <td><input type="submit" value="start" ></td>
        </tr>
    </table>
</form>
<p>
    <font color="RED">${error}</font>
</p>
</body>
</html>