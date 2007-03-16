<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userchangeBean" class="be.kdg.yahtzee.beans.UserBean" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>

<body>
<div id="container">
<div id="profile">

<form name="changePassword" action="/admin/ChangeUserPasswordServlet?orgUser=${userchangeBean.username}" method="post">
    <table>
        <tr>
            <td><img src="../images/logo.png" class="logo" alt="Yahtzee"/></td>
            <td><h1>
                <h:outputText value="#{labels.profile}"/>
            </h1></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.userName}"/>
            </td>
            <td>${userchangeBean.username}</td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.profileNewPw}"/>
            </td>
            <td><input type="password" name="pw" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.profileRePw}"/>
            </td>
            <td><input type="password" name="pw2" class="text"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<h:outputText value="#{labels.profilePw}"/>" class="btn"></td>
        </tr>
    </table>
</form>

<form name="changeProfile" action="/admin/ChangeUserProfileServlet?orgUser=${userchangeBean.username}" method="post">
    <table>
        <tr>
            <td>
                <h:outputText value="#{labels.mail}"/>
            </td>
            <td><input type="text" name="mail" class="text" value="${userchangeBean.email}"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.surname}"/>
            </td>
            <td><input type="text" name="surname" value="${userchangeBean.surname}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.firstname}"/>
            </td>
            <td><input type="text" name="firstname" value="${userchangeBean.firstname}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.telephone}"/>
            </td>
            <td><input type="text" name="telephone" value="${userchangeBean.telephone}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.street}"/>
                +
                <h:outputText value="#{labels.number}"/>
            </td>
            <td>
                <input type="text" class="text" name="street" size="12" value="${userchangeBean.street}"/>&nbsp;
                <input type="text" name="number" class="text" size="1" value="${userchangeBean.number}"/>
            </td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.zip}"/>
            </td>
            <td><input type="text" name="zip" value="${userchangeBean.zip}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.city}"/>
            </td>
            <td><input type="text" name="city" value="${userchangeBean.city}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.country}"/>
            </td>
            <td><input type="text" name="country" value="${userchangeBean.country}" class="text"/></td>
        </tr>
        <tr>
            <td>
                <h:outputText value="#{labels.createRole}"/>
            </td>
            <td><select name="role">
                <% String admin = "Beheerder"; %>
                <% String player = "Speler"; %>
                <c:if test="${userchangeBean.role == 'Administrator'}">
                    <option value="Administrator" selected><%= admin %>
                    </option>
                    <option value="Player"><%= player %>
                    </option>
                </c:if>
                <c:if test="${userchangeBean.role == 'Player'}">
                    <option value="Administrator"><%= admin %>
                    </option>
                    <option value="Player" selected><%= player %>
                    </option>
                </c:if>
            </select></td>
        </tr>
        <tr>
            <td>
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
        <td><input type="submit" value="<h:outputText value="#{labels.profileTitle}"/>" class="btn"></td>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <td colspan="2" align="center" height="40px"><a href="/faces/admin/ShowUsersServlet" class="back">
            <h:outputText value="#{labels.userBack}"/>
        </a></td>
        <tr>
            <td colspan="2" align="center">${message}</td>
        </tr>
    </table>
</form>
</div>
</div>
</body>
</html>
</f:view>