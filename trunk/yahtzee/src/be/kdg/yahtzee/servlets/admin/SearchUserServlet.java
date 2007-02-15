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
        String username = request.getParameter("searchUser");

        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);
        List<User> allUsers = new ArrayList<User>();
        if (user != null) {
            allUsers.add(user);
        }

        HttpSession session = request.getSession();
        session.setAttribute("allUsers", allUsers);

        forward("/admin/showUserFound.jsp", request, response);
    }

}
