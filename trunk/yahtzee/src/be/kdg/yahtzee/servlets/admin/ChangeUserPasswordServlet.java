/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserPasswordServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orgUsername = request.getParameter("orgUser");
        String orgPass = request.getParameter("orgPass");
        String password = request.getParameter("pw");
        String password2 = request.getParameter("pw2");
        YahtzeeController yahtzeeController = findYahtzeeController();
        User orgUser = yahtzeeController.findUser(orgUsername);
        yahtzeeController.changePassWord(orgUser, orgPass, password, password2);

        request.setAttribute("message", "Het wachtwoord werd succesvol gewijzigd");
        forward("/faces/admin/changeUser.jsp", request, response);
    }
}
