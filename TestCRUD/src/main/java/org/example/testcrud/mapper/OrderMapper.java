package org.example.testcrud.mapper;

import org.example.testcrud.dto.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    private static OrderMapper instance = null;

    private OrderMapper() {}

    public static OrderMapper getInstance() {
        if (instance == null)
            instance = new OrderMapper();
        return instance;
    }

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getInt("id"))
                .date(rs.getDate("date").toLocalDate())
                .cost(rs.getDouble("cost"))
                .productList(null)
                .build();
    }
}
