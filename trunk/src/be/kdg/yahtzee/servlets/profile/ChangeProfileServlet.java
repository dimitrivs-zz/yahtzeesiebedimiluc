package be.kdg.yahtzee.servlets.profile;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 13-feb-2007
 * Time: 12:49:44
 * To change this template use File | Settings | File Templates.
 */
public class ChangeProfileServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        response.sendRedirect("/faces/profile/changeProfile.jsp");
    }


    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        doPost(servletRequest, servletResponse);
    }
}
