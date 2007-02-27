/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.game.Highscore;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Interface for database access for the highscores of the users.
 */
public interface HighscoreDao {

    /**
     * Method for getting a highscore by an id.
     *
     * @param highscoreId Id of the wanted highscore.
     * @return Highscore object
     */
    public Highscore getHighscore(int highscoreId);

    /**
     * Method for getting a List of all the highscores in the database.
     *
     * @return List containing all the highscores in the database.
     */
    public List getHighscores();

    /**
     * Method for getting a sorted List of all the highscores in the database.
     *
     * @return Sorted List containing all the highscores in the database.
     */
    public List<Highscore> getSortedHighscores();

    /**
     * Method for saving a highscore to the database.
     *
     * @param highscore Highscore object to be saved in the database.
     */
    public void saveHighscore(Highscore highscore);

    /**
     * Method or deleting a highscore from the database.
     *
     * @param highscore Highscore object to be deleted from the database.
     */
    public void deleteHighscore(Highscore highscore);

    /**
     * Method for creating a HibernateTemplate for accessing a database in a session.
     *
     * @param sessionFactory SessionFactory object containing database session.
     * @return HibernateTemplate object
     */
    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory);
}
