/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Person;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeUserServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);

        UserBean userBean = new UserBean(yahtzeeController, user.getUserId(), user.getUsername(), user.getPassword(), (Role) user.getRole(), (Person) user.getPerson());
        HttpSession session = request.getSession();
        session.setAttribute("userchangeBean", userBean);

        response.sendRedirect("/faces/admin/changeUser.jsp");
    }
}
