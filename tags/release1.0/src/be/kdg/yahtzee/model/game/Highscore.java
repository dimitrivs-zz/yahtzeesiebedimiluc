/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.model.users.User;

/**
 * Class representing a Highscore object in the yahtzee game
 */
public class Highscore {
    private int highscoreId;
    private int score;
    private User user;

    public Highscore() {
    }

    /**
     * Constructor for a hoghscore object
     *
     * @param highscoreId Integer id of the highscore.
     * @param user        User object owning the highscore.
     * @param score       Score object representing the user's score.
     */
    public Highscore(int highscoreId, User user, int score) {
        this.highscoreId = highscoreId;
        this.user = user;
        this.score = score;
    }

    /**
     * Method for getting the id of a highscore.
     *
     * @return Integer value representing highscore id.
     */
    public int getHighscoreId() {
        return highscoreId;
    }

    /**
     * Method for setting the id of a highscore.
     *
     * @param highscoreId Integer value representing highscore id.
     */
    public void setHighscoreId(int highscoreId) {
        this.highscoreId = highscoreId;
    }

    /**
     * Method for getting the User of a highscore.
     *
     * @return User object representing owner of highscore.
     */
    public User getUser() {
        return user;
    }

    /**
     * Method for setting the User of a highscore.
     *
     * @param user User object representing owner of highscore.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Method for getting the Score value of a highscore.
     *
     * @return Integer value representing highscore.
     */
    public int getScore() {
        return score;
    }

    /**
     * Method for setting the Score value of a highscore.
     *
     * @param score Integer value representing highscore.
     */
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
