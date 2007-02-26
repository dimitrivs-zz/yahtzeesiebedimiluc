/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.Role;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Interface for database access for the roles.
 */
public interface RoleDao {

    /**
     * Method for getting a role by an id.
     *
     * @param roleId Id of the wanted role.
     * @return Role object
     */
    public Role getRole(int roleId);

    /**
     * Method for getting a List of all the roles in the database.
     *
     * @return List containing all the roles in the database.
     */
    public List getRoles();

    /**
     * Method for saving a role to the database.
     *
     * @param role Role object to be saved in the database.
     */
    public void saveRole(Role role);

    /**
     * Method or deleting a role from the database.
     *
     * @param role Role object to be deleted from the database.
     */
    public void deleteRole(Role role);

    /**
     * Method for creating a HibernateTemplate for accessing a database in a session.
     *
     * @param sessionFactory SessionFactory object containing database session.
     * @return HibernateTemplate object
     */
    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory);

}
