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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Implementation of the HighScoreDao interface.
 * This class provides database connectivity for accessing highscore data.
 */
public class HighscoreDaoImpl extends HibernateDaoSupport implements HighscoreDao {

    public HighscoreDaoImpl() {
    }

    /**
     * Getter for a Highscore by highscoreId.
     *
     * @param highscoreId Integer id of wanted highscore.
     * @return Highscore object containing wanted highscore.
     */
    public Highscore getHighscore(int highscoreId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (Highscore) hibernateTemplate.get(Highscore.class, highscoreId);
    }

    /**
     * Method for getting a List of all the highscores in the database.
     *
     * @return List containing all the highscores in the database.
     */
    public List<Highscore> getHighscores() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Highscore");
    }

    /**
     * Method for getting a sorted List of all the highscores in the database.
     *
     * @return Sorted List containing all the highscores in the database.
     */
    public List<Highscore> getSortedHighscores() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Highscore order by score desc");
    }

    /**
     * Method for saving a highscore to the database.
     *
     * @param highscore Highscore object to be saved in the database.
     */
    public void saveHighscore(Highscore highscore) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(highscore);
    }

    /**
     * Method or deleting a highscore from the database.
     *
     * @param highscore Highscore object to be deleted from the database.
     */
    public void deleteHighscore(Highscore highscore) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(highscore);
    }

    /**
     * Method for creating a HibernateTemplate for accessing a database in a session.
     *
     * @param sessionFactory SessionFactory object containing database session.
     * @return HibernateTemplate object
     */
    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);
    }
}
