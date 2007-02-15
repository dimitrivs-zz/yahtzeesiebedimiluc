package be.kdg.yahtzee.model.game;

public class ScoreAspect {
    private String description;
    private int points;
    private boolean fixed;

    public ScoreAspect(String description) {
        this.description = description;
    }

    public ScoreAspect(String description, int points) {
        this.description = description;
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
