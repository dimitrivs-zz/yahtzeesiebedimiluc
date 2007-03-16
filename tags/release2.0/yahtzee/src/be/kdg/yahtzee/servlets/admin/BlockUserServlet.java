/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets.admin;

import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockUserServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String blocked = request.getParameter("blocked");

        YahtzeeController yahtzeeController = findYahtzeeController();

        if (yahtzeeController.isLastAdministrator() && yahtzeeController.isAdministrator(username)) {
            request.setAttribute("message", "U kan de laatste administrator niet blokkeren...");
        } else {
            if (blocked.equals("true")) {
                yahtzeeController.blockUser(username);
            } else {
                yahtzeeController.unblockUser(username);
            }
        }
        forward("/admin/ShowUsersServlet", request, response);
    }
}
