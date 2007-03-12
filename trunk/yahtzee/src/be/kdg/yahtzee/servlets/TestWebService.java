/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.servlets;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.chat.Chat;
import be.kdg.yahtzee.model.remoteObjects.game.Die;
import be.kdg.yahtzee.model.remoteObjects.game.Game;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.Person;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
        /*
        Boolean isplayer = myService.isPlayer("qsdfqsdfdsqf");
        HttpSession session = servletRequest.getSession();
        myService.createPlayer("siebe", "siebe", "siebe", "siebe", "siebe", "siebe", null);
        System.out.println("user aanmaken " + myService.findUser("siebe"));
        session.setAttribute("isplayer", isplayer.toString());
        session.setAttribute("player", myService.findUser("bla"));

        java.lang.Object[] users = myService.getUsers();
        List usersss = Arrays.asList(users);
        session.setAttribute("users", users);
        */
        HttpSession session = servletRequest.getSession();

        List<Game> allGamesList = new ArrayList<Game>();
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        Person person = new Person(address, "eamil", "qsdf", "qsdf", "qsdf");
        User user1 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser");
        myService.createGame("testGame", 3, user1);
        //myService.playGameRound()

        java.lang.Object[] allGames = myService.getGames();

        for (int i = 0; i < allGames.length; i++) {
            Game game = (Game) allGames[i];
            System.out.println(game.getGameName());
            System.out.println(game.getMaxPlayer());
            System.out.println(game.getNumberOfPlayers());
            System.out.println(game.getScore().getCarre());
            System.out.println(game.getScorePossibilities()[0]);
            System.out.println(game.getScores().get("iets"));
            System.out.println(game.getState());
            System.out.println(game.getUsers()[0]);
            System.out.println(((User) game.getActivePlayer()).getUsername());
            System.out.println(((Chat) game.getChat()).getMessages()[0]);
            System.out.println(((User) game.getCreator()).getUsername());
            System.out.println(((Die) game.getDiceList()[i]).getValue());
            System.out.println(((Die) game.getDie()[i]).getValue());


            allGamesList.add(game);
        }

        servletResponse.sendRedirect("/result.jsp");
    }
}
