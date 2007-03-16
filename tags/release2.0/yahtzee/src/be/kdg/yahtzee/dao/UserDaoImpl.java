/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

/**
 * Implementation of the UserDao interface.
 * This class provides database connectivity for accessing user data.
 */
public class UserDaoImpl {
    private Session session;

    public UserDaoImpl() {
    }

    /**
     * Method for getting a user by an id.
     *
     * @param userId Id of the wanted user.
     * @return User object
     */
    public User getUser(int userId) {
        Session session;
        session = HibernateUtil.getSession();

        Query query = session.createQuery("from User where userId = :id");
        query.setInteger("id", userId);
        return (User) query.uniqueResult();
    }

    /**
     * Method for getting a List of all the users in the database.
     *
     * @return List containing all the users in the database.
     */
    public Collection getUsers() {
        Session session;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from User");

        Collection users = query.list();
        return users;
    }

    /**
     * Method for saving a user to the database.
     *
     * @param user User object to be saved in the database.
     */
    public void saveUser(User user) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
    }

    /**
     * Method or deleting a user from the database.
     *
     * @param user User object to be deleted from the database.
     */
    public void deleteUser(User user) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
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
        return super.createHibernateTemplate(sessionFactory);    //To change body of overridden methods use File | Settings | File Templates.
    } */
}
