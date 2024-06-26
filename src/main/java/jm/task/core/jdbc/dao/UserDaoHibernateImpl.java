package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pre_project.users (\n" +
            "  id BIGINT(200) NOT NULL AUTO_INCREMENT,\n" +
            "  name VARCHAR(45) NOT NULL,\n" +
            "  lastName VARCHAR(45) NOT NULL,\n" +
            "  age TINYINT(3) NOT NULL,\n" +
            "  PRIMARY KEY (id))";
    private final String DROP_TABLE = "DROP TABLE IF EXISTS pre_project.users";
    private final String INSERT_USERS = "INSERT INTO pre_project.users (name, lastName, age) VALUES (?, ?, ?)";
    private final String SELECT_ALL = "SELECT * FROM pre_project.users";
    private final String DELETE = "DELETE FROM pre_project.users WHERE id = ? IS NULL OR id = ''";
    private final String CLEAN = "TRUNCATE TABLE pre_project.users";

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
