/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.game.Highscore;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowHighscoresServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Highscore> highscores = new ArrayList<Highscore>();

        String filter = request.getParameter("filter");

        YahtzeeController yahtzeeController = findYahtzeeController();

        if (filter.equals("top10")) {
            highscores = new ArrayList(Arrays.asList(yahtzeeController.getTop10Highscores()));
        }
        if (filter.equals("allScores")) {
            highscores = new ArrayList(Arrays.asList(yahtzeeController.getHighscores()));
        }

        HttpSession session = request.getSession();
        session.setAttribute("highscores", highscores);

        response.sendRedirect("/faces/admin/showHighscores.jsp");
    }
}
