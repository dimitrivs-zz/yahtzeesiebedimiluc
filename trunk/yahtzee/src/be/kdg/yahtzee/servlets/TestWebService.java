/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 19-dec-2006
 * Time: 19:12:34
 * To change this template use File | Settings | File Templates.
 */
public class TestWebService extends YahtzeeServlet {

    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
        be.kdg.yahtzee.model.remoteObjects.YahtzeeController myService = null;
        try {
            myService = serviceLocator.getyahtzee();
        } catch (javax.xml.rpc.ServiceException e) {

        }
        //System.out.println("answer = " + sum);
        Boolean isplayer = myService.isPlayer("qsdfqsdfdsqf");
        HttpSession session = servletRequest.getSession();
        myService.createPlayer("siebe", "siebe", "siebe", "siebe", "siebe", "siebe", null);
        System.out.println("user aanmaken " + myService.findUser("siebe"));
        session.setAttribute("isplayer", isplayer.toString());
        session.setAttribute("player", myService.findUser("bla"));

        java.lang.Object[] users = myService.getUsers();
        List usersss = Arrays.asList(users);
        session.setAttribute("users", users);

        servletResponse.sendRedirect("/result.jsp");
    }
}
