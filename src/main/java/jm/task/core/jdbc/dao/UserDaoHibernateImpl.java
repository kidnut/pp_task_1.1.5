package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                    "  id BIGINT(200) NOT NULL AUTO_INCREMENT,\n" +
                    "  name VARCHAR(45) NOT NULL,\n" +
                    "  lastName VARCHAR(45) NOT NULL,\n" +
                    "  age TINYINT(3) NOT NULL,\n" +
                    "  PRIMARY KEY (id))";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS users";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().getCurrentSession();
        List<User> users = new ArrayList<>();
        try {
            session.beginTransaction();
            users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
        System.out.println(users);
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }
}
