package be.kdg.yahtzee.servlets.game;

import be.kdg.yahtzee.beans.GameBean;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JoinGameServlet extends YahtzeeServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("join");

        YahtzeeController yahtzeeController = findYahtzeeController();

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());

        if (!yahtzeeController.joinGame(gameName, user)) {
            request.setAttribute("error", "Er ging iets fout");
        }
        /*
        Set<Game> games =  new HashSet<Game>(yahtzeeController.getGames());
        session.setAttribute("games", games);
          */
        GameBean gameBean = new GameBean(yahtzeeController, gameName);
        session.setAttribute("gameBean", gameBean);

        forward("/player/game.jsp", request, response);
    }
}
