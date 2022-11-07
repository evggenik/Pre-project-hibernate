package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() { // без параметров? просто свое название таблицы?
//        String sqlCommand1 = "SELECT count(*) FROM information_schema.tables WHERE table_name = ? LIMIT 1";
        try (Connection connection = getConnect();
             Statement stm = connection.createStatement()) {
            String sqlCommand2 = """
                    create table if not exists users (`id` INT NOT NULL AUTO_INCREMENT,
                      `name` VARCHAR(45) NULL,
                      `lastname` VARCHAR(45) NULL,
                      `age` INT NULL,
                      PRIMARY KEY (`id`))""";
            stm.executeUpdate(sqlCommand2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = getConnect();
             Statement stm = connection.createStatement()) {
            String sqlCommand = "DROP TABLE if exists users";
            stm.executeUpdate(sqlCommand);
//            System.out.println("Table deleted in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlCommand = "insert into users (name, lastname, age) values (?, ?, ?)";
        try (Connection connection = getConnect();
             PreparedStatement prepStm = connection.prepareStatement(sqlCommand)) {
            prepStm.setString(1, name);
            prepStm.setString(2, lastName);
            prepStm.setByte(3, age);
            prepStm.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в базу");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlCommand = "delete from users where id=?";
        try (Connection connection = getConnect();
             PreparedStatement prepStm = connection.prepareStatement(sqlCommand)

        ) {
            prepStm.setLong(1, id);
            prepStm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<User> getAllUsers () {
            List<User> userList = new ArrayList<>();
            String sqlCommand = "select id, name, lastname, age from users";
            try (Connection connection = getConnect();
                 Statement stm = connection.createStatement();
                 ResultSet rs = stm.executeQuery(sqlCommand)
            ) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setLastName(rs.getString("lastname"));
                    user.setAge(rs.getByte("age"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return userList;
        }
        public void cleanUsersTable () {

            try (Connection connection = getConnect();
                 Statement stm = connection.createStatement()

            ) {
                String sqlCommand = "delete from users";
                stm.executeUpdate(sqlCommand);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


}
