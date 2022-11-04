package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.dropUsersTable();
//        userService.saveUser("Иван", "Иванов", (byte) 20);
//        userService.saveUser("Николай", "Петров", (byte) 21);
        userService.removeUserById(2);
    }
}
