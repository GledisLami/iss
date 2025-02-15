package org.sda.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sda.entities.IssDataDao;
import org.sda.entities.IssPeopleDao;
import org.sda.entities.IssSpeedDao;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

            LogManager.getLogManager().reset(); // Reset default logging
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE); // Show only SEVERE messages

            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(IssSpeedDao.class)
                    .addAnnotatedClass(IssDataDao.class)
                    .addAnnotatedClass(IssPeopleDao.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void save(Object object){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(object);

        tx.commit();

        session.close();
    }
}
