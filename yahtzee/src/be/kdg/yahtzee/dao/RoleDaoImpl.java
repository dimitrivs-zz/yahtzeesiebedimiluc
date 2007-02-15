package be.kdg.yahtzee.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

import be.kdg.yahtzee.model.users.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

    public Role getRole(int roleId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (Role)hibernateTemplate.get(Role.class, roleId);
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


}
