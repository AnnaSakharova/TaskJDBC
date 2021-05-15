package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Arnold", "Schwarzenegger", (byte) 64);
        userService.saveUser("Brus", "Willis", (byte) 30);
        userService.saveUser("Galina", "Blanka", (byte) 23);
        userService.saveUser("Pamela", "Anderson", (byte) 47);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
