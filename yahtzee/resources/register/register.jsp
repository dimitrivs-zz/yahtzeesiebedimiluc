<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

<f:loadBundle basename="bundles.resources" var="labels"/>

<html>
<head>
    <link href="../css/formStyle.css" rel="stylesheet" type="text/css" />
    <title>
        <h:outputText value="#{labels.registerTitle}"/>
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
<div id="container">
    <div id="register">
        <form autocomplete="OFF" name="createUser" action="/register/CreatePlayerServlet" method="post"
              onsubmit="return checkForm()">
            <table>
                <tr>
                    <td colspan="2"><img src="../images/logo.png" class="logo" alt="Register"/></td>
                    <td><h1><h:outputText value="#{labels.register}"/></h1></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.userName}"/></td>
                    <td><input type="text" name="username" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.password}"/></td>
                    <td><input type="password" name="pw" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.repeatPassword}"/></td>
                    <td><input type="password" name="pw2" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.mail}"/></td>
                    <td><input type="text" name="mail" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.surname}"/></td>
                    <td><input type="text" name="surname" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.firstname}"/></td>
                    <td><input type="text" name="firstname" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.telephone}"/></td>
                    <td><input type="text" name="telephone" class="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.street}"/> + <h:outputText value="#{labels.number}"/></td>
                    <td>
                        <input type="text" class="text" name="street" size="12"/>&nbsp;
                        <input type="text" name="number" class="text" size="1"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.zip}"/></td>
                    <td><input type="text" class="text" name="zip"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.city}"/></td>
                    <td><input type="text" class="text" name="city"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.country}"/></td>
                    <td><input type="text" class="text" name="city"/></td>
                </tr>
                <tr>
                    <td colspan="2"><h:outputText value="#{labels.language}"/></td>
                    <td><select name="taal">
                        <option>Nederlands</option>
                        <option>Fran&ccedil;ais</option>
                        <option>English</option>
                        <option>Deutsch</option>
                        <option>Espa&ntilde;ol</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td height="40px"><input type="submit" value="<h:outputText value="#{labels.registerButton}"/>" class="btn"></td>
                </tr>
                <tr>
                    <td colspan="3" align="center" height="35px"><a href="../login/login.jsp" class="back"><h:outputText value="#{labels.inlogButton}"/></a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

</f:view>