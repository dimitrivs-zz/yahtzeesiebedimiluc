package be.kdg.yahtzee.servlets.logout;

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

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 19-dec-2006
 * Time: 19:12:34
 * To change this template use File | Settings | File Templates.
 */
public class LogoutServlet extends YahtzeeServlet {
    private static Logger logger = Logger.getLogger(LogoutServlet.class);
    static final String FILENAME = "LogoutServletLog.txt";

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        YahtzeeController yahtzeeController = findYahtzeeController();
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        User user = yahtzeeController.findUser(userBean.getUsername());
        user.setOnline(false);

        logger.info("User " + user.getUsername() + " logged out");

        session.removeAttribute("games");
        session.removeAttribute("userBean");
        session.removeAttribute("gameBean");
        session.invalidate();

        response.sendRedirect("/faces/login/login.jsp");
    }
}
