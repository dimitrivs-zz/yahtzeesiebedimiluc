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

public class ShowUsersServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YahtzeeController yahtzeeController = findYahtzeeController();

        List<User> allUsers = new ArrayList<User>(yahtzeeController.getUsers());
        HttpSession session = request.getSession();
        session.setAttribute("allUsers", allUsers);

        forward("/admin/showAllUsers.jsp", request, response);
    }
}
