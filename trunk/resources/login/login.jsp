<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

    <f:loadBundle basename="bundles.resources" var="labels"/>

    <html>
    <head>
        <link href="../css/formStyle.css" rel="stylesheet" type="text/css" />
        <!-- Client side authentication -->
        <script type="text/javascript">
            function validateFormOnSubmit(theForm) {
                var reason = "";

                reason += validateUsername(theForm.username);
                reason += validatePassword(theForm.password);

                if (reason != "") {
                    alert("Some fields need correction:\n" + reason);
                    return false;
                }

                return true;
            }

            function validateUsername(fld) {
                var error = "";
                var illegalChars = /^[0-9a-zA-Z]+$/;

                if (fld.value == "") {
                    fld.style.background = 'Red';
                    error = "You didn't enter a username.\n";
                } else if ((fld.value.length < 4)) {
                    fld.style.background = 'Red';
                    error = "The username is the wrong length.\n";
                } else if (!fld.value.match(illegalChars)) {
                    fld.style.background = 'Red';
                    error = "The username contains illegal characters.\n";
                } else {
                    fld.style.background = 'White';
                }
                return error;
            }
            function validatePassword(fld) {
                var error = "";
                var illegalChars = /^[0-9a-zA-Z]+$/;

                if (fld.value == "") {
                    fld.style.background = 'Red';
                    error = "You didn't enter a password.\n";
                } else if ((fld.value.length < 6)) {
                    error = "The password is the wrong length. \n";
                    fld.style.background = 'Red';
                } else if (!fld.value.match(illegalChars)) {
                    error = "The password contains illegal characters.\n";
                    fld.style.background = 'Red';
                }
                return error;
            }
        </script>

        <title><h:outputText value="#{labels.loginTitle}"/></title>
    </head>

    <body>
    <div id="login">
        <!--onsubmit="return validateFormOnSubmit(this)"-->
        <form name="login" autocomplete="OFF" action="/login/LoginServlet" method="post">
            <table>
                <tr>
                    <td colspan="2"><img src="../images/logo.png" class="logo" alt="Login"/></td>
                    <td><h1><h:outputText value="#{labels.login}"/></h1></td>
                </tr>
                <tr>
                    <td><h:outputText value="#{labels.userName}"/></td>
                    <td><input type="text" name="username" class="text"/></td>
                </tr>
                <tr>
                    <td><h:outputText value="#{labels.password}"/></td>
                    <td><input type="password" name="password" class="text"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="<h:outputText value="#{labels.login}"/>" class="btn"/></td>
                </tr>
                <tr>
                    <td colspan ="3" align="center"><h:outputText value="#{labels.loginMessage}"/> <a href="../register/register.jsp"><h:outputText value="#{labels.loginRegister}"/></a></td>
                </tr>
            </table>
        </form>
    </div>
    </body>
    </html>
</f:view>