package be.kdg.yahtzee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil instance = null;
    private static SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Session session = sessionfactory.openSession();

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    protected HibernateUtil() {
    }

    public static Session getSession() {
        return session;
    }
}
