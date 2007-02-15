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
        //Ik weet ni of da ge het weet, maar al de parameters da hierna komen zijn null
        //Ge geeft die ni mee in den url � :)
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
        User changedUser = yahtzeeController.changePlayer(orgUser, username, surname, firstname, mail, telephone, address);
        HttpSession session = request.getSession();
        session.setAttribute("user", changedUser);
        session.setAttribute("message", "De gebruiker '" + username + "' werd succesvol gewijzigd.");
        response.sendRedirect("/faces/profile/changeProfile.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}