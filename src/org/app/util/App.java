package org.app.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    private static App instance;

    private static Session session;

    private App() {

        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public Transaction getTransaction() {
        return session.beginTransaction();
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
        HibernateUtil.shutdown();
    }
}
