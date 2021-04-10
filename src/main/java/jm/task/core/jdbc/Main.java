package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        User ivan = new User();
        ivan.setName("Ivan");
        ivan.setLastName("Ivanov");
        ivan.setAge((byte) 30);

        User petr = new User();
        petr.setName("Petr");
        petr.setLastName("Petrov");
        petr.setAge((byte) 31);

        User dmitriy = new User();
        dmitriy.setName("Dmitriy");
        dmitriy.setLastName("Dmitriev");
        dmitriy.setAge((byte) 32);

        User nikolay = new User();
        nikolay.setName("Nikolay");
        nikolay.setLastName("Nikolaev");
        nikolay.setAge((byte) 33);

        userService.saveUser(ivan.getName(), ivan.getLastName(), ivan.getAge());
        userService.saveUser(petr.getName(), petr.getLastName(), petr.getAge());
        userService.saveUser(dmitriy.getName(), dmitriy.getLastName(), dmitriy.getAge());
        userService.saveUser(nikolay.getName(), nikolay.getLastName(), nikolay.getAge());

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
