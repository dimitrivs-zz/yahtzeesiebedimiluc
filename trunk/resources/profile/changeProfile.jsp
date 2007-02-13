<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>


<html>
<head>
    <title>
        Change profile
    </title>

    <script type="text/javascript">
        function checkForm() {
            var form = document.createUser;
            var message = "";
            if (!form.username.value) message += "* Foute username\n";
            if (!form.pw.value) message += "* Fout passwoord\n";
            if (!form.pw2.value) message += "* Fout bevestiging passwoord\n";
            if (!form.mail.value) message += "Fout \n";
            if (message != "") {
                var mes = "fout\n" + message;
                alert(mes);
                return false;
            } else {
                var illegalChars = /^[0-9a-zA-Z]+$/;
                var illegalNums = /[0-9]+$/;

                if (form.username.value.length < 4 ||
                    !form.username.value.match(illegalChars) ||
                    form.username.value == form.name.value) {
                    alert("fout");
                    return false;
                } else if (form.number.value && !form.number.value.match(illegalNums)) {
                    alert("fout");
                    return false;
                } else if (form.zip.value && (!form.zip.value.match(illegalNums) || form.zip.value.length != 4)) {
                    alert("fout");
                    return false;
                } else if (form.pw.value.length < 6 ||
                           !form.pw.value.match(illegalChars) ||
                           form.pw.value == form.name.value) {
                    alert("fout");
                    return false;
                } else if (form.pw.value != form.pw2.value) {
                    alert("fout");
                    return false;
                }
            }
            return true;
        }
    </script>
</head>

<body>

<center>
    <h1>
    </h1>

    <form autocomplete="OFF" name="createUser"
          action="/profile/ConfirmChangeProfileServlet?orgUser=${userBean.username}" method="post"
          onsubmit="return checkForm()">
        <table>
            <tr>
                <th align="right">Username</th>
                <td><input type="text" name="username" value="${userBean.username}" disabled="true"/></td>
            </tr>
            <tr>
                <th align="right"> password</th>
                <td><input type="password" name="pw"/></td>
            </tr>
            <tr>
                <th align="right"> herhaal wachtwoord</th>
                <td><input type="password" name="pw2"/></td>
            </tr>
            <tr>
                <th align="right">mail</th>
                <td><input type="text" name="mail"/></td>
            </tr>
            <tr>
                <th align="right">surname</th>
                <td><input type="text" name="surname"/></td>
            </tr>
            <tr>
                <th align="right">firstname</th>
                <td><input type="text" name="firstname"/></td>
            </tr>
            <tr>
                <th align="right"> telephone</th>
                <td><input type="text" name="telephone"/></td>
            </tr>
            <tr>
                <th align="right"> street</th>
                <td><input type="text" name="street"/></td>
            </tr>
            <tr>
                <th align="right"> number</th>
                <td><input type="text" name="number"/></td>
            </tr>
            <tr>
                <th align="right"> zip</th>
                <td><input type="text" name="zip"/></td>
            </tr>
            <tr>
                <th align="right"> city</th>
                <td><input type="text" name="city"/></td>
            </tr>
            <tr>
                <th align="right">country</th>
                <td><input type="text" name="city"/></td>
            </tr>
            <tr>
                <th colspan=2><input type=submit value="wijzig"></th>
            </tr>
        </table>
        ${message}
    </form>
</center>
</body>
</html>

