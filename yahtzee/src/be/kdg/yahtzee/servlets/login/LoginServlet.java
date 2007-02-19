/*
Exeption handeling: OK
Logging: te kleine klasse om te loggen
Java 5: OK
Refacorting: OK
 */

package be.kdg.yahtzee.servlets.login;

import be.kdg.util.InputValidation;
import be.kdg.util.Security;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LoginServlet extends YahtzeeServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class);
    static final String FILENAME = "LoginServletLog.txt";

    @Override
    public void init() throws ServletException {
        SimpleLayout layout = new SimpleLayout();

        FileAppender appender = null;
        try {
            appender = new FileAppender(layout, FILENAME, false);
        } catch (Exception e) {
            // empty catch block!
        }

        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean loginOK = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!InputValidation.getInstance().isInputValid(username, password)) {
            forward("/faces/login/loginError.jsp", request, response);
        }
        password = Security.getInstance().encrypt(password);
        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);

        if (!user.getUsername().equals("username")) {
            loginOK = user.getPassword().equals(password) && !user.isBlocked();
        }

        if (loginOK) {
            user.setOnline(true);
            logger.info("User " + user.getUsername() + " logged in");
            makeUserBean(request, username, yahtzeeController);
            forwardUser(request, response, username, yahtzeeController);
        } else {
            forward("/faces/login/loginError.jsp", request, response);
        }
    }

    private void makeUserBean(HttpServletRequest request, String username, YahtzeeController yahtzeeController) {
        UserBean userBean = new UserBean(yahtzeeController, username);
        HttpSession session = request.getSession();
        session.setAttribute("userBean", userBean);
    }

    private void forwardUser(HttpServletRequest request, HttpServletResponse response, String username, YahtzeeController yahtzeeController) throws ServletException, IOException {
        if (yahtzeeController.isPlayer(username)) {
            logger.info("User " + username + " is een Player");
            Set<Object> games = new HashSet<Object>(yahtzeeController.getGames());
            HttpSession session = request.getSession();
            session.setAttribute("games", games);
            response.sendRedirect("/faces/player/gameRoom.jsp");
        } else if (yahtzeeController.isAdministrator(username)) {
            logger.info("User " + username + " is een Administrator");
            response.sendRedirect("/faces/admin/administrator.jsp");
        } else {
            forward("/faces/login/loginError.jsp", request, response);
        }
    }
}
