/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

/**
 * Class representing a ScoreAspect in the yahtzee game.
 */
public class ScoreAspect {
    private String description;
    private int points;
    private boolean fixed;

    /**
     * Constructor for a ScoreAspect object.
     * Points will be set to zero.
     *
     * @param description Aspect of the yahtzee score (eg. yahtzee, chance,...).
     */
    public ScoreAspect(String description) {
        this.description = description;
        this.points = 0;
    }

    /**
     * Constructor for a ScoreAspect object.
     *
     * @param description Aspect of the yahtzee score (eg. yahtzee, chance,...).
     */
    public ScoreAspect(String description, int points) {
        this.description = description;
        this.points = points;
    }

    /**
     * Method for setting the description of the ScoreAspect.
     *
     * @return String representing the description of the ScoreAspect.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method for getting the points of the ScoreAspect.
     *
     * @return Integer value representing the points of the ScoreAspect.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Method for setting the points of the ScoreAspect.
     *
     * @param points Integer value representing the points of the ScoreAspect.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Method to check if the ScoreAspect is fixed or not.
     *
     * @return boolean value representing the fixing of the ScoreAspect.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isFixed() {
        return fixed;
    }

    /**
     * Method for fixing the ScoreAspect.
     *
     * @param fixed boolean value representing the fixing of the ScoreAspect.
     *              true to fixed
     */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
