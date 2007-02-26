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

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {
    //private HibernateTemplate hibernateTemplate;

    public RoleDaoImpl() {
        //this.hibernateTemplate = getHibernateTemplate();
    }

    public Role getRole(int roleId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (Role) hibernateTemplate.get(Role.class, roleId);
    }

    public void saveRole(Role role) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(role);
    }

    public void deleteRole(Role role) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(role);
    }

    public List<Role> getRoles() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Role");
    }

    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);    //To change body of overridden methods use File | Settings | File Templates.
    }


}
