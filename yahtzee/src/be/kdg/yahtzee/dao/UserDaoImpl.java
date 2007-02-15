package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    //private HibernateTemplate hibernateTemplate;

    public UserDaoImpl() {
        //this.hibernateTemplate = getHibernateTemplate();
    }

    public User getUser(int userId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (User) hibernateTemplate.get(User.class, userId);
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

    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
