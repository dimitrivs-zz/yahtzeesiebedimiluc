/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateUserServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pw");
        String password2 = request.getParameter("pw2");
        String mail = request.getParameter("mail");
        String surname = request.getParameter("surname");
        String firstname = request.getParameter("firstname");
        String telephone = request.getParameter("telephone");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String zip = request.getParameter("zip");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String role = request.getParameter("role");

        if (username == null || password == null || password2 == null || mail == null) {
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, "Parameters not found in request");
            return;
        }
        Address address = new Address(street, number, zip, city, country);
        YahtzeeController yahtzeeController = findYahtzeeController();

        if (role.equals("admin")) {
            yahtzeeController.createAdministrator(username, password, surname, firstname, mail, telephone, address);
        } else {
            yahtzeeController.createPlayer(username, password, surname, firstname, mail, telephone, address);
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", "De gebruiker '" + username + "' werd succesvol aangemaakt.");
        response.sendRedirect("/admin/createUserConfirm.jsp");
    }
}
