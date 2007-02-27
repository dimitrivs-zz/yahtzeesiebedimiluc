package be.kdg.yahtzee.users;

import be.kdg.yahtzee.dao.RoleDaoImpl;
import be.kdg.yahtzee.dao.UserDaoImpl;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.UserManager;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:24:37
 * To change this template use File | Settings | File Templates.
 */
public class TestOnlineUsers extends TestCase {
    private UserManager userManager;
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        userManager = new UserManager();
        UserDaoImpl userDao = new UserDaoImpl();
        RoleDaoImpl roleDao = new RoleDaoImpl();

        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        configuration.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/yahtzeetest");
        configuration.setProperty(Environment.USER, "yahtzee");
        configuration.setProperty(Environment.PASS, "yahtzee");
        configuration.setProperty(Environment.DIALECT, HSQLDialect.class.getName());
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "create");
        configuration.addClass(User.class);
        configuration.addClass(Role.class);

        this.sessionFactory = configuration.buildSessionFactory();

        userDao.setSessionFactory(sessionFactory);
        roleDao.setSessionFactory(sessionFactory);

        this.session = SessionFactoryUtils.getSession(sessionFactory, true);
        TransactionSynchronizationManager.bindResource(sessionFactory,
                new SessionHolder(session));

        userManager.setUserDao(userDao);
        userManager.setRoleDao(roleDao);
    }

    @After
    protected void tearDown() throws Exception {
        userManager = null;
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.releaseSession(session, sessionFactory);
    }

    @Test
    public void testUserOnline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);
        user.setOnline(true);

        User onlineUser = userManager.getOnlineUsers().get(0);

        assertEquals("user <bla> moet <online> zijn", "bla", onlineUser.getUsername());
    }

    @Test
    public void testUserOffline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user1 = userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        User user2 = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);
        user1.setOnline(true);
        user2.setOnline(false);

        User onlineUser = userManager.getOnlineUsers().get(0);

        assertEquals("user <haha> moet <online> zijn", "haha", onlineUser.getUsername());
        assertTrue("Dit moet true teruggeven", onlineUser.isOnline());
    }
}
