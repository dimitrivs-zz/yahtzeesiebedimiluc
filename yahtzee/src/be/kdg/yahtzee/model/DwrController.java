package be.kdg.yahtzee.model;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.game.Game;
import be.kdg.yahtzee.model.remoteObjects.users.User;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 11-mrt-2007
 * Time: 9:05:32
 * To change this template use File | Settings | File Templates.
 */
public class DwrController {
    be.kdg.yahtzee.model.remoteObjects.YahtzeeController yahtzeeController;

    public DwrController() {
        YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
        try {
            yahtzeeController = serviceLocator.getyahtzee();
        } catch (javax.xml.rpc.ServiceException e) {

        }
    }

    public Set<Game> getGames() throws RemoteException {
        Set<Game> allGamesList = new HashSet<Game>();

        java.lang.Object[] allGames = yahtzeeController.getGames();

        System.out.println("Groote games DWR: " + allGames.length);

        for (int i = 0; i < allGames.length; i++) {
            allGamesList.add((Game) allGames[i]);
            System.out.println("Game : " + ((Game) allGames[i]).getGameName() + " added");
        }

        System.out.println("Groote games DWR SET: " + allGamesList.size());

        return allGamesList;
    }

    public List<User> getOnlineUsers() throws RemoteException {
        List<User> allUsersList = new ArrayList<User>();

        java.lang.Object[] allUsers = yahtzeeController.getOnlineUsers();

        System.out.println("Groote online users DWR: " + allUsers.length);

        for (int i = 0; i < allUsers.length; i++) {
            allUsersList.add((User) allUsers[i]);
        }
        return allUsersList;
    }

    public List getGlobalMessages() throws RemoteException {
        List allGlobalMessagesList = new ArrayList();
        java.lang.Object[] allGlobalMessages = yahtzeeController.getGlobalMessages();

        for (int i = 0; i < allGlobalMessages.length; i++) {
            allGlobalMessagesList.add((String) allGlobalMessages[i]);
        }
        return allGlobalMessagesList;
    }
}
