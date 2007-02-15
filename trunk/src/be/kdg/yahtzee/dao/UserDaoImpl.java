package be.kdg.yahtzee.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

import be.kdg.yahtzee.model.users.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public User getUser(int userId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (User)hibernateTemplate.get(User.class, userId);
    }

    public void saveUser(User user) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(user);
    }

    public void deleteUser(User user) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(user);
    }

    public List<User> getUsers() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from User");
    }


}
