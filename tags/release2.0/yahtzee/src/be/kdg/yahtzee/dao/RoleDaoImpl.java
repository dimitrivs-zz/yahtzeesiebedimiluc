/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation of the RoleDao interface.
 * This class provides database connectivity for accessing role data.
 */
public class RoleDaoImpl {


    public RoleDaoImpl() {
    }

    /**
     * Method for getting a role by an id.
     *
     * @param roleId Id of the wanted role.
     * @return Role object
     */
    public Role getRole(int roleId) {
        Session session;
        session = HibernateUtil.getSession();

        Query query = session.createQuery("from Role where roleId = :id");
        query.setInteger("id", roleId);
        return (Role) query.uniqueResult();
    }

    /**
     * Method for getting a List of all the roles in the database.
     *
     * @return List containing all the roles in the database.
     */
    public List<Role> getRoles() {
        Session session;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Role");

        List<Role> roles = query.list();
        return roles;
    }

    /**
     * Method for saving a role to the database.
     *
     * @param role Role object to be saved in the database.
     */
    public void saveRole(Role role) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
    }

    /**
     * Method or deleting a highscore from the database.
     *
     * @param role Role object to be deleted from the database.
     */
    public void deleteRole(Role role) {
        Session session;
        session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(role);
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
