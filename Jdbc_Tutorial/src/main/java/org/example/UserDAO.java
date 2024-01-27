package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User>{
    private static final String insertQuery = "INSERT INTO users(firstName, lastName, age) VALUES(?, ?, ?);";
    private static final String selectAllQuery = "SELECT * FROM users;";
    private static final String selectByIdQuery = "SELECT * FROM users WHERE id = ?;";
    private static final String updateQuery = "UPDATE users SET " +
            "firstName = ?, " +
            "lastname = ?," +
            "age = ? " +
            "WHERE id = ?;";
    private final static String deleteById = "DELETE FROM users WHERE id = ?;";

    Connection con = getconnection();

    private Connection getconnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(User user) {
        try(PreparedStatement ps = con.prepareStatement(insertQuery)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> selectById(int id) {
        try (PreparedStatement ps = con.prepareStatement(selectByIdQuery)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getInt("age"));
                return Optional.of(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(selectAllQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                users.add(new User(id, firstName, lastName, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public int updateById(int id, User user) {
        try(PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getAge());
            ps.setInt(4, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(int id) {
        try(PreparedStatement ps = con.prepareStatement(deleteById)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
