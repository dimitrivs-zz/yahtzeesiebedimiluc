package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 16-feb-2007
 * Time: 10:54:30
 * To change this template use File | Settings | File Templates.
 */
public class ChangeUserServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        YahtzeeController yahtzeeController = findYahtzeeController();

        UserBean userBean = new UserBean(yahtzeeController, username);
        HttpSession session = request.getSession();
        session.setAttribute("userchangeBean", userBean);

        forward("/faces/admin/changeUser.jsp", request, response);
    }
}
