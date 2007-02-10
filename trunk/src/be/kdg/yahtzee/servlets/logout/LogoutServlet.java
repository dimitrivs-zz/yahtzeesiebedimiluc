package be.kdg.yahtzee.servlets.logout;

import be.kdg.yahtzee.servlets.YahtzeeServlet;
import be.kdg.yahtzee.beans.OnlineUsersBean;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.YahtzeeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 19-dec-2006
 * Time: 19:12:34
 * To change this template use File | Settings | File Templates.
 */
public class LogoutServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        YahtzeeController yahtzeeController = findYahtzeeController();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());
        OnlineUsersBean onlineUsersBean = findOnlineUsersBean();
        onlineUsersBean.removeUser(user);

        session.removeAttribute("games");
        session.removeAttribute("userBean");
        session.invalidate();

        System.out.println("User logged out");
        response.sendRedirect("/login/login.html");
    }
}
