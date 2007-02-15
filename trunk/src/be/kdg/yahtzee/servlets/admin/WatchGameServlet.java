package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 14-feb-2007
 * Time: 13:00:33
 * To change this template use File | Settings | File Templates.
 */
public class WatchGameServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //NOG TE MAKEN

        forward("/admin/gameManagement.jsp", request, response);
    }
}
