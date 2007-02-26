/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.model.users.User;

/**
 * Created by IntelliJ IDEA.
 * User: Luc
 * Date: 21-feb-2007
 * Time: 14:21:21
 * To change this template use File | Settings | File Templates.
 */
public class Highscore {
    private int highscoreId;
    private int score;
    private User user;

    public Highscore() {
    }

    public Highscore(int highscoreId, User user, int score) {
        this.highscoreId = highscoreId;
        this.user = user;
        this.score = score;
    }

    public int getHighscoreId() {
        return highscoreId;
    }

    public void setHighscoreId(int highscoreId) {
        this.highscoreId = highscoreId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Highscore highscore = (Highscore) o;

        if (score != highscore.score) return false;

        return true;
    }

    public int hashCode() {
        return score;
    }
}
