<html>
<head>
  <title>Chat-Demo</title>
  <script type='text/javascript' src='/dwr/engine.js'></script>
  <script type='text/javascript' src='/dwr/interface/Chat.js'></script>
  <script type='text/javascript' src='/dwr/util.js'></script>
  <script type='text/javascript'>
    function sendMessage()
    {
        var text = DWRUtil.getValue("text");
        DWRUtil.setValue("text", "");
        Chat.addMessage(gotMessages, text);
    }
    function checkMessages()
    {
        Chat.getMessages(gotMessages);
    }
    function gotMessages(messages)
    {
        var chatlog = "";
        for (var data in messages)
        {
            chatlog = "<div>" + messages[data].text + "</div>" + chatlog;
        }
        DWRUtil.setValue("chatlog", chatlog);
        setTimeout("checkMessages()", 1000);
    }
  </script>
</head>
<body onload="setTimeout('checkMessages()', 1000)">
<p>Messages:</p>
<div id="chatlog" style="border: 1px solid black;"></div>
<p>
  Your Message:
  <input id="text" />
  <input value="Send" onclick="sendMessage()" type="button" />
</p>
</body>
</html>
