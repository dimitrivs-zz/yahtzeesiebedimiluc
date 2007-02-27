/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Implementation of the UserDao interface.
 * This class provides database connectivity for accessing user data.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public UserDaoImpl() {
    }

    /**
     * Method for getting a user by an id.
     *
     * @param userId Id of the wanted user.
     * @return User object
     */
    public User getUser(int userId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (User) hibernateTemplate.get(User.class, userId);
    }

    /**
     * Method for getting a List of all the users in the database.
     *
     * @return List containing all the users in the database.
     */
    public List<User> getUsers() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from User");
    }

    /**
     * Method for saving a user to the database.
     *
     * @param user User object to be saved in the database.
     */
    public void saveUser(User user) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(user);
    }

    /**
     * Method or deleting a user from the database.
     *
     * @param user User object to be deleted from the database.
     */
    public void deleteUser(User user) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(user);
    }

    /**
     * Method for creating a HibernateTemplate for accessing a database in a session.
     *
     * @param sessionFactory SessionFactory object containing database session.
     * @return HibernateTemplate object
     */
    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
