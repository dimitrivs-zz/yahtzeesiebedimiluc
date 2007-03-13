package be.kdg.yahtzee.servlets.game;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

public class FinishGameServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("game");

        YahtzeeController yahtzeeController = findYahtzeeController();

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());

        int score = yahtzeeController.getPlayerScore(user, gameName);
        Calendar cal = java.util.GregorianCalendar.getInstance();

        yahtzeeController.saveHighscore(user, score, cal);
        yahtzeeController.leaveGame(gameName, user);

        response.sendRedirect("/faces/player/gameFinish.jsp");
    }
}
