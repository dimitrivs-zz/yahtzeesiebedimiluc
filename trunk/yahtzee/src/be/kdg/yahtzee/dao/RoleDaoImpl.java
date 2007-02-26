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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Implementation of the RoleDao interface.
 * This class provides database connectivity for accessing role data.
 */
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

    public RoleDaoImpl() {
    }

    /**
     * Method for getting a role by an id.
     *
     * @param roleId Id of the wanted role.
     * @return Role object
     */
    public Role getRole(int roleId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (Role) hibernateTemplate.get(Role.class, roleId);
    }

    /**
     * Method for getting a List of all the roles in the database.
     *
     * @return List containing all the roles in the database.
     */
    public List<Role> getRoles() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Role");
    }

    /**
     * Method for saving a role to the database.
     *
     * @param role Role object to be saved in the database.
     */
    public void saveRole(Role role) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(role);
    }

    /**
     * Method or deleting a highscore from the database.
     *
     * @param role Role object to be deleted from the database.
     */
    public void deleteRole(Role role) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(role);
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
