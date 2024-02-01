package org.example.dz_13_servlets_tomcatdemo;

import org.example.dz_13_servlets_tomcatdemo.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHandler {
    private static final Connection con;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(Car car) {
        String query = "INSERT INTO registered_cars (model, power, year, price) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, car.getModel());
            ps.setDouble(2, car.getPower());
            ps.setInt(3, car.getYear());
            ps.setDouble(4, car.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
