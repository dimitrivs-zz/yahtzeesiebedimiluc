<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view locale="#{language}">

<f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head>
    <link href="../css/formStyle.css" rel="stylesheet" type="text/css"/>
    <title>
        <h:outputText value="#{labels.profileTitle}"/>
    </title>
    <script type='text/javascript' src='changeProfile.js'></script>
    <script type="text/javascript"></script>
</head>

<body>
<div id="register">
<!--onsubmit="return checkPassForm()"-->
<form id="changePassword" name="changePassword"
      action="/profile/ConfirmChangePasswordServlet?orgUser=${userBean.username}" method="post">
    <table>
        <tr>
            <td colspan="2"><img src="../images/logo.png" class="logo" alt="Profile"/></td>
            <td><h1>
                <h:outputText value="#{labels.profile}"/>
            </h1></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.profileOldPw}"/>
            </td>
            <td><input type="password" name="orgPass" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.profileNewPw}"/>
            </td>
            <td><input type="password" name="pw" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.profileRePw}"/>
            </td>
            <td><input type="password" name="pw2" class="text"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Change password"></td>
        </tr>
    </table>
</form>
<!--onsubmit="return checkProfileForm()"-->
<form id="changeProfile" name="changeProfile" action="/profile/ConfirmChangeProfileServlet?user=${userBean.username}"
      method="post">
    <table>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.mail}"/>
            </td>
            <td><input type="text" name="mail" class="text" value="${userBean.email}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.surname}"/>
            </td>
            <td><input type="text" name="surname" value="${userBean.surname}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.firstname}"/>
            </td>
            <td><input type="text" name="firstname" value="${userBean.firstname}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.telephone}"/>
            </td>
            <td><input type="text" name="telephone" value="${userBean.telephone}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.street}"/>
                +
                <h:outputText value="#{labels.number}"/>
            </td>
            <td>
                <input type="text" class="text" name="street" size="12" value="${userBean.street}"/>&nbsp;
                <input type="text" name="number" class="text" size="1" value="${userBean.number}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.zip}"/>
            </td>
            <td><input type="text" name="zip" value="${userBean.zip}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.city}"/>
            </td>
            <td><input type="text" name="city" value="${userBean.city}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.country}"/>
            </td>
            <td><input type="text" name="city" value="${userBean.country}" class="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <h:outputText value="#{labels.language}"/>
            </td>
            <td><select name="taal">
                <option>Nederlands</option>
                <option>Fran&ccedil;ais</option>
                <option>English</option>
                <option>Deutsch</option>
                <option>Espa&ntilde;ol</option>
            </select>
            </td>
        </tr>
        <td><input type="submit" value="Change profile"></td>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <td colspan="3" align="center" height="40px"><a href="/faces/player/gameRoom.jsp">
            <h:outputText value="#{labels.gameroomButton}"/>
        </a></td>
        <tr>
            <td colspan="3" align="center">${message}</td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
</f:view>