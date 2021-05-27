package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Userz (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), lastName VARCHAR(30), age INT(2))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Util util;
        try {
            util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("DROP TABLE Userz");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static final String INSERT = "INSERT INTO Userz VALUES (id,?,?,?)";

    public void saveUser(String name, String lastName, byte age) {
        Util util;
        PreparedStatement preparedStatement;
        try {
            util = new Util();
            Statement statement = util.getConnection().createStatement();
            preparedStatement = statement.getConnection().prepareStatement(INSERT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static final String DELETE = "DELETE FROM Userz WHERE (id = ?)";

    public void removeUserById(long id) {
        Util util;
        PreparedStatement preparedStatement;
        try {
            util = new Util();
            Statement statement = util.getConnection().createStatement();
            preparedStatement = statement.getConnection().prepareStatement(DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static final String GET_ALL = "SELECT * FROM Userz";

    public List<User> getAllUsers() {
        Util util;
        PreparedStatement preparedStatement;
        List<User> list = new LinkedList<>();
        User user = new User();
        try {
            util = new Util();
            Statement statement = util.getConnection().createStatement();
            preparedStatement = statement.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        Util util;
        try {
            util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM Userz");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
