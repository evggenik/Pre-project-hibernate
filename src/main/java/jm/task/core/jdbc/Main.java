package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 20);
        userService.saveUser("Николай", "Петров", (byte) 21);
        userService.saveUser("Григорий", "Зырянов", (byte) 19);
        userService.saveUser("Григорий", "Зырянов", (byte) 18);
//        userService.removeUserById(11);
        System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
