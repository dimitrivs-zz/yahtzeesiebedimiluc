/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.game.Game;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowGamesServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YahtzeeController yahtzeeController = findYahtzeeController();

        List<Game> allGamesList = new ArrayList<Game>();

        java.lang.Object[] allGames = yahtzeeController.getGames();

        for (int i = 0; i < allGames.length; i++) {
            allGamesList.add((Game) allGames[i]);
        }

        HttpSession session = request.getSession();
        session.setAttribute("allGames", allGamesList);

        response.sendRedirect("/faces/admin/gameManagement.jsp");
    }

}
