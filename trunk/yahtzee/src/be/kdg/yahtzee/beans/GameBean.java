/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.remoteObjects.game.Game;

import java.rmi.RemoteException;

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
