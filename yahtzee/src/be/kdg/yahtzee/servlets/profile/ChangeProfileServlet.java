/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.profile;

import be.kdg.util.InputValidation;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeProfileServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String mail = request.getParameter("mail");
        String surname = request.getParameter("surname");
        String firstname = request.getParameter("firstname");
        String telephone = request.getParameter("telephone");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String zip = request.getParameter("zip");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        InputValidation inputValidation = InputValidation.getInstance();
        if (!inputValidation.isInputValid(username, mail, surname, firstname, telephone, street, number, zip, city, country) && inputValidation.isNumberValid(street, number)) {
            request.setAttribute("message", "De invoer is niet volgens het verwachte patroon");
        } else {
            Address address = new Address(street, number, zip, city, country);
            YahtzeeController yahtzeeController = findYahtzeeController();
            User orgUser = yahtzeeController.findUser(username);
            Role role = orgUser.getRole();
            yahtzeeController.changeUser(orgUser, surname, firstname, mail, telephone, address, role);
            request.setAttribute("message", "De gebruiker '" + username + "' werd succesvol gewijzigd.");
        }

        forward("/faces/profile/changeProfile.jsp", request, response);
    }
}
