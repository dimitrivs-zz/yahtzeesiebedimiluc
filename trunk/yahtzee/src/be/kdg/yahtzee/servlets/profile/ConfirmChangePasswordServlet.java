package be.kdg.yahtzee.servlets.profile;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 13-feb-2007
 * Time: 12:49:44
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmChangePasswordServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        String orgUsername = servletRequest.getParameter("orgUser");
        String orgPass = servletRequest.getParameter("orgPass");
        String password = servletRequest.getParameter("pw");
        String password2 = servletRequest.getParameter("pw2");
        YahtzeeController yahtzeeController = findYahtzeeController();
        User orgUser = yahtzeeController.findUser(orgUsername);
        yahtzeeController.changePassWord(orgUser, orgPass, password, password2);
        HttpSession session = servletRequest.getSession();
        session.setAttribute("message", "Het wachtwoord werd succesvol gewijzigd");
        servletResponse.sendRedirect("/faces/profile/changeProfile.jsp");
    }
}
