package be.kdg.yahtzee.servlets.profile;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 20-feb-2007
 * Time: 15:11:22
 * To change this template use File | Settings | File Templates.
 */
public class ShowProfileServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user");

        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(userName);

        request.setAttribute("userName", user.getUsername());
        request.setAttribute("firstName", user.getFirstname());
        request.setAttribute("surName", user.getSurname());

        forward("/profile/profile.jsp", request, response);
    }
}
