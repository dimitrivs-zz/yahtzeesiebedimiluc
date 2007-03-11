/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.game;

import be.kdg.yahtzee.beans.GameBean;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewGameServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("gameName");
        String maxPlayer = request.getParameter("maxPlayer");

        YahtzeeController yahtzeeController = findYahtzeeController();

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());

        boolean check = false;

        if (!yahtzeeController.createGame(gameName, Integer.valueOf(maxPlayer), user)) {
            request.setAttribute("error", "Spel bestaat al of u zit al in een andere spel.<br /><a href='/faces/player/gameRoom.jsp'> terug naar game room</a>");
            check = true;
        }

        //Set<Object> games = new HashSet<Object>(yahtzeeController.getGames());

        //session.setAttribute("games", games);
        if (!check) {
            GameBean gameBean = new GameBean(yahtzeeController, gameName);
            session.setAttribute("gameBean", gameBean);
            response.sendRedirect("/faces/player/game.jsp");
        } else {
            forward("/faces/player/startNewGame.jsp", request, response);
        }
    }
}
