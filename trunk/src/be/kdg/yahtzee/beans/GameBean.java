package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;

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
}
