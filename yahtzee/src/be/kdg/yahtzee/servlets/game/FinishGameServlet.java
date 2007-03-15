/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */


package be.kdg.yahtzee.servlets.game;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class FinishGameServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("game");

        YahtzeeController yahtzeeController = findYahtzeeController();

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());

        int score = yahtzeeController.getPlayerScore(user, gameName);
        Calendar cal = java.util.GregorianCalendar.getInstance();

        //save highscores
        yahtzeeController.saveHighscore(user, score, cal);

        //scores to session for game summary
        Map scores = yahtzeeController.getScores(gameName);
        session.setAttribute("scores", scores);

        // remove player from game
        yahtzeeController.leaveGame(gameName, user);

        response.sendRedirect("/faces/player/gameFinish2.jsp");
    }
}
