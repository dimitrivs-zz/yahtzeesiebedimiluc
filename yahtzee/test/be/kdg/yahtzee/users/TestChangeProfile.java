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
 * Date: 18-feb-2007
 * Time: 18:33:30
 * To change this template use File | Settings | File Templates.
 */
public class TestChangeProfile extends TestCase {
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
        configuration.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/yahtzee");
        configuration.setProperty(Environment.USER, "yahtzee");
        configuration.setProperty(Environment.PASS, "yahtzee");
        configuration.setProperty(Environment.DIALECT, HSQLDialect.class.getName());
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
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
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.releaseSession(session, sessionFactory);
    }

    @Test
    public void testChangeProfile() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);
        User user1 = userManager.changeUser(user, "admin", "istrator", "admin@admin.com", "O498/24.36.43", address);

        assertEquals("Het resultaat moet <admin@admin.com> zijn", "admin@admin.com", user1.getPerson().getEmail());
    }
}
