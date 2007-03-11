/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.game.Highscore;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation of the HighScoreDao interface.
 * This class provides database connectivity for accessing highscore data.
 */
public class HighscoreDaoImpl {

    public HighscoreDaoImpl() {
    }

    /**
     * Getter for a Highscore by highscoreId.
     *
     * @param highscoreId Integer id of wanted highscore.
     * @return Highscore object containing wanted highscore.
     */
    public Highscore getHighscore(int highscoreId) {
        Session session;
        session = HibernateUtil.getSession();

        Query query = session.createQuery("from Highscore where highscoreId = :id");
        query.setInteger("id", highscoreId);
        return (Highscore) query.uniqueResult();
    }

    /**
     * Method for getting a List of all the highscores in the database.
     *
     * @return List containing all the highscores in the database.
     */
    public List<Highscore> getHighscores() {
        Session session;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Highscore");

        List<Highscore> highscores = query.list();
        return highscores;
    }

    /**
     * Method for getting a sorted List of all the highscores in the database.
     *
     * @return Sorted List containing all the highscores in the database.
     */
    public List<Highscore> getSortedHighscores() {
        Session session;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Highscore");

        List<Highscore> roles = query.list();
        return roles;
    }

    /**
     * Method for saving a highscore to the database.
     *
     * @param highscore Highscore object to be saved in the database.
     */
    public void saveHighscore(Highscore highscore) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(highscore);
        tx.commit();
    }

    /**
     * Method or deleting a highscore from the database.
     *
     * @param highscore Highscore object to be deleted from the database.
     */
    public void deleteHighscore(Highscore highscore) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(highscore);
        tx.commit();
    }

    /**
     * Method for creating a HibernateTemplate for accessing a database in a session.
     *
     * @param sessionFactory SessionFactory object containing database session.
     * @return HibernateTemplate object
     */
    /*
    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);
    }*/
}
