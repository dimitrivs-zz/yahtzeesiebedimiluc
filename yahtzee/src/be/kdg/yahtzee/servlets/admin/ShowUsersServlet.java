/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowUsersServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YahtzeeController yahtzeeController = findYahtzeeController();

        List<User> allUsersList = new ArrayList<User>();

        java.lang.Object[] allUsers = yahtzeeController.getUsers();

        for (int i = 0; i < allUsers.length; i++) {
            System.out.println(allUsers[i]);
            allUsersList.add((User) allUsers[i]);
        }

        HttpSession session = request.getSession();
        session.setAttribute("allUsers", allUsersList);

        response.sendRedirect("/faces/admin/userManagement.jsp");
    }
}
