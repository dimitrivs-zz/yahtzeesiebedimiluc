package be.kdg.yahtzee.servlets.bundles;

import be.kdg.yahtzee.servlets.YahtzeeServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class LanguageServlet extends YahtzeeServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String language = request.getParameter("lang");

        HttpSession session = request.getSession();
        session.setAttribute("language", language);

        response.sendRedirect("/login/login.html");
    }
}
