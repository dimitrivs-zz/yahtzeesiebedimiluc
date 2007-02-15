<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

<f:loadBundle basename="bundles.resources" var="labels"/>

<html>
<head>
    <title>
        Create new User
    </title>

    <script type="text/javascript">
        function checkForm() {
            var form = document.createUser;
            var message = "";
            if (!form.username.value) message += "* <h:outputText value="#{labels.userName}"/>\n";
            if (!form.pw.value) message += "* <h:outputText value="#{labels.password}"/>\n";
            if (!form.pw2.value) message += "* <h:outputText value="#{labels.repeatPassword}"/>\n";
            if (!form.mail.value) message += "* <h:outputText value="#{labels.mail}"/>\n";
            if (message != "") {
                var mes = "<h:outputText value="#{labels.registerRequired}"/>\n" + message;
                alert(mes);
                return false;
            } else {
                var illegalChars = /^[0-9a-zA-Z]+$/;
                var illegalNums = /[0-9]+$/;

                if (form.username.value.length < 4 ||
                    !form.username.value.match(illegalChars) ||
                    form.username.value == form.name.value) {
                    alert("<h:outputText value="#{labels.registerUsernameError}"/>");
                    return false;
                } else if (form.number.value && !form.number.value.match(illegalNums)) {
                    alert("<h:outputText value="#{labels.registerNumberError}"/>");
                    return false;
                } else if (form.zip.value && (!form.zip.value.match(illegalNums) || form.zip.value.length != 4)) {
                    alert("<h:outputText value="#{labels.registerZipError}"/>");
                    return false;
                } else if (form.pw.value.length < 6 ||
                           !form.pw.value.match(illegalChars) ||
                           form.pw.value == form.name.value) {
                    alert("<h:outputText value="#{labels.registerPasswordError}"/>");
                    return false;
                } else if (form.pw.value != form.pw2.value) {
                    alert("<h:outputText value="#{labels.registerRepeatError}"/>");
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
        Create New User
    </h1>
    <h:outputText value="#{labels.registerInfoLabel}"/>
    <form autocomplete="OFF" name="createUser" action="/admin/CreateUserServlet" method="post"
          onsubmit="return checkForm()">
        <table>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.userName}"/>
                </th>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.password}"/>
                </th>
                <td><input type="password" name="pw"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.repeatPassword}"/>
                </th>
                <td><input type="password" name="pw2"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.mail}"/>
                </th>
                <td><input type="text" name="mail"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.surname}"/>
                </th>
                <td><input type="text" name="surname"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.firstname}"/>
                </th>
                <td><input type="text" name="firstname"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.telephone}"/>
                </th>
                <td><input type="text" name="telephone"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.street}"/>
                </th>
                <td><input type="text" name="street"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.number}"/>
                </th>
                <td><input type="text" name="number"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.zip}"/>
                </th>
                <td><input type="text" name="zip"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.city}"/>
                </th>
                <td><input type="text" name="city"/></td>
            </tr>
            <tr>
                <th align="right">
                    <h:outputText value="#{labels.country}"/>
                </th>
                <td><input type="text" name="city"/></td>
            </tr>
            <tr>
                <th align="right">Role</th>
                <td><select name="role">
                    <option value="admin">Administrator</option>
                    <option value="player" selected>Player</option>
                </select></td>
            </tr>
            <tr>
                <th colspan=2><input type=submit value="Create User"></th>
            </tr>
        </table>
        <a href="../admin/userManagement.jsp">
            Terug naar het overzicht
        </a>
    </form>
</center>
</body>
</html>

</f:view>

