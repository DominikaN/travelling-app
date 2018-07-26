package store;

import com.travellingapp.travel.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PostgresDB implements DataStore {
    private final SessionFactory sessionFactory;

    public PostgresDB() {
        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(User.class);
            sessionFactory = config.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Long save(User userToSave) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Long userId = null;

        try {
            tx = session.beginTransaction();
            userId = (Long) session.save(userToSave);
            userToSave.setId(userId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
