package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
//        User user = new User("Dmytro", "Humeniuk", 20);
//        userDAO.insert(user);
//        List<User> users = userDAO.selectAll();
//        User newUser = new User("Test", "Test", 18);
//        userDAO.updateById(1, newUser);
        userDAO.deleteById(1);
//        User user = userDAO.selectById(2).orElse(new User());
//        System.out.println(user);
    }
}