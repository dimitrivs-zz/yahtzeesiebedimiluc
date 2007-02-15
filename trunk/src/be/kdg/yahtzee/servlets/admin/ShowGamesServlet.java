package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.game.Game;
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

        List<Game> allGames = new ArrayList<Game>(yahtzeeController.getGames());
        HttpSession session = request.getSession();
        session.setAttribute("allGames", allGames);

        forward("/admin/showAllGames.jsp", request, response);
    }

}
