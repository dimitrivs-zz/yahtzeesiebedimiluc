/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 14-feb-2007
 * Time: 12:56:28
 * To change this template use File | Settings | File Templates.
 */
public class RemoveGameServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamename = request.getParameter("gamename");

        YahtzeeController yahtzeeController = findYahtzeeController();
        yahtzeeController.removeGame(gamename);

        forward("/admin/ShowGamesServlet", request, response);
    }
}
