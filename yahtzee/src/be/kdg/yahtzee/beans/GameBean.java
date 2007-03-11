/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.game.Game;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean class for getting and passing game information between
 * servlets and jsp-pages.
 */
public class GameBean {
    private YahtzeeController yahtzeeController;
    private String gameName;

    public GameBean() {
    }

    /**
     * Constructor for the Game bean.
     *
     * @param yahtzeeController Main controller.
     * @param gameName          Name of the Game for which the bean needs to be created.
     */
    public GameBean(YahtzeeController yahtzeeController, String gameName) {
        this.yahtzeeController = yahtzeeController;
        this.gameName = gameName;
    }

    /**
     * Method for getting the users joined in the game.
     *
     * @return Set containing the Users in the Game.
     */
    public Set getUsersOfGame() throws RemoteException {
        Game game = yahtzeeController.getGame(gameName);
        Set usersGame = new HashSet();
        for (int i = 0; i < game.getUsers().length; i++) {
            usersGame.add(game.getUsers()[i]);
        }
        return usersGame;
    }

    /**
     * Method for getting the name of the Game.
     *
     * @return String containing the Game name.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Method for getting the scores of the Game.
     *
     * @return Map containing the Scores of the game.
     */
    public int getNumberOfPlayers() throws RemoteException {
        Game game = yahtzeeController.getGame(gameName);
        return game.getNumberOfPlayers();
    }
}
