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

import java.util.List;

public interface UserDao {

    public User getUser(int userId);

    public void saveUser(User user);

    public void deleteUser(User user);

    public List getUsers();

    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory);
}
