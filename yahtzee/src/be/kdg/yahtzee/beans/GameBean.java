package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.game.Game;

import java.util.Set;

public class GameBean {
    private YahtzeeController yahtzeeController;
    private String gameName;

    public GameBean() {
    }

    public GameBean(YahtzeeController yahtzeeController, String gameName) {
        this.yahtzeeController = yahtzeeController;
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Set getUsersOfGame() {
        Game game = yahtzeeController.getGame(gameName);
        return game.getUsers();
    }
}
