package be.kdg.yahtzee.servlets.game;

import be.kdg.yahtzee.servlets.YahtzeeServlet;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.beans.GameBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class NewGameServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("gameName");
        String maxPlayer = request.getParameter("maxPlayer");

        YahtzeeController yahtzeeController = findYahtzeeController();

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());

        boolean check = false;

        if (!yahtzeeController.createGame(gameName, Integer.valueOf(maxPlayer), user)){
            request.setAttribute("error", "Spel bestaat al of u zit al in een andere spel <a href='../player/gameRoom.jsp'> terug naar game room</a>");
            check = true;
        }

        Set<Object> games =  new HashSet<Object>(yahtzeeController.getGames());

        session.setAttribute("games", games);
        if (!check){
            GameBean gameBean = new GameBean(yahtzeeController, gameName);
            session.setAttribute("gameBean", gameBean);
            response.sendRedirect("/player/game.jsp");
        } else{
            forward("/player/startNewGame.jsp", request, response);            
        }
    }
}
