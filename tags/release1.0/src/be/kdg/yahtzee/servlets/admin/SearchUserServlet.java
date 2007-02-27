/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchUserServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("searchUser");

        YahtzeeController yahtzeeController = findYahtzeeController();

        List<User> allUsers = new ArrayList<User>(yahtzeeController.findUsersByKeyword(keyword));

        HttpSession session = request.getSession();
        session.setAttribute("allUsers", allUsers);

        forward("/faces/admin/showUserFound.jsp", request, response);
    }

}
