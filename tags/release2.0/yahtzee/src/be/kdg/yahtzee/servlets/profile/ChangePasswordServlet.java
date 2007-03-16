/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.profile;

import be.kdg.util.InputValidation;
import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 13-feb-2007
 * Time: 12:49:44
 * To change this template use File | Settings | File Templates.
 */
public class ChangePasswordServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orgUsername = request.getParameter("orgUser");
        String orgPass = request.getParameter("orgPass");
        String password = request.getParameter("pw");
        String password2 = request.getParameter("pw2");

        if (!InputValidation.getInstance().isInputValid(orgUsername, orgPass, password, password2)) {
            request.setAttribute("message", "De invoer is niet volgens het verwachte patroon");
        } else {
            YahtzeeController yahtzeeController = findYahtzeeController();
            User orgUser = yahtzeeController.findUser(orgUsername);
            if (!yahtzeeController.changePassWord(orgUser, orgPass, password, password2)) {
                request.setAttribute("message", "Het passwoord was niet correct");
            } else {
                request.setAttribute("message", "Het wachtwoord werd succesvol gewijzigd");
            }
        }

        forward("/faces/profile/changeProfile.jsp", request, response);
    }
}
