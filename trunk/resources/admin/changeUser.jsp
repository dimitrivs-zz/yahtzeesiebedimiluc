<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Change User</title></head>
<body>
<form autocomplete="OFF" name="createUser" action="/register/ChangePasswordServlet" method="post">
    <table>
        <tr>
            <td>New Password</td>
            <td><input type="password" name="newPass"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="confirmPass"></td>
        </tr>
        <tr>
            <th colspan=2><input type=submit value="Confirm"></th>
        </tr>
    </table>
</form>
</body>
</html>