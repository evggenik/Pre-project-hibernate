package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        Util util = new Util();
//        Util.getConnection();
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 22);
        userService.saveUser("Петр", "Петров", (byte) 33);
        userService.saveUser("Василий", "Сидоров", (byte) 11);
        userService.saveUser("John", "Smith", (byte) 99);
        System.out.println(userService.getAllUsers());
//        userService.removeUserById(1);
        userService.cleanUsersTable();
//        System.out.println(userService.getAllUsers());
        userService.dropUsersTable();

    }
}
