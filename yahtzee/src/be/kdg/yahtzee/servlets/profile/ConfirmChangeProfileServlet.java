package be.kdg.yahtzee.servlets.profile;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConfirmChangeProfileServlet extends YahtzeeServlet {
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
        Address address = new Address(street, number, zip, city, country);
        YahtzeeController yahtzeeController = findYahtzeeController();
        User orgUser = yahtzeeController.findUser(username);
        User changedUser = yahtzeeController.changeUser(orgUser, surname, firstname, mail, telephone, address, orgUser.getRole());
        HttpSession session = request.getSession();
        session.setAttribute("user", changedUser);
        session.setAttribute("message", "De gebruiker '" + username + "' werd succesvol gewijzigd.");
        response.sendRedirect("/faces/profile/changeProfile.jsp");
    }
}
