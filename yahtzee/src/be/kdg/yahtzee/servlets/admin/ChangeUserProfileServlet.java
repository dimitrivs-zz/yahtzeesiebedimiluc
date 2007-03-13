/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserProfileServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("orgUser");
        String mail = request.getParameter("mail");
        String surname = request.getParameter("surname");
        String firstname = request.getParameter("firstname");
        String telephone = request.getParameter("telephone");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String zip = request.getParameter("zip");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String roleName = request.getParameter("role");

        Address address = new Address(street, number, zip, city, country);
        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);

        //Map<String, Role> roles = yahtzeeController.getRoles();
        Role role = null;


        java.lang.Object[] allRoles = yahtzeeController.getRolesList();

        for (int i = 0; i < allRoles.length; i++) {
            System.out.println(allRoles[i]);
            if (roleName.equals(((Role) allRoles[i]).getName())) {
                role = (Role) allRoles[i];
            }
        }

        if (yahtzeeController.isLastAdministrator() && roleName.equals("Player") && user.getRole().getName().equals("Administrator")) {
            request.setAttribute("message", "U kan de laatste administrator niet verwijderen...");
        } else {
            yahtzeeController.changeUser(user, surname, firstname, mail, telephone, address, role);

            request.setAttribute("message", "Het profiel werd succesvol gewijzigd");
        }

        forward("/faces/admin/changeUser.jsp", request, response);
    }
}
