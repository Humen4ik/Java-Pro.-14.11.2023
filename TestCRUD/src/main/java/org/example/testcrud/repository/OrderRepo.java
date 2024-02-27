package org.example.testcrud.repository;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Order;
import org.example.testcrud.mapper.OrderMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepo implements repo<Order> {
    private final String SELECT_BY_ID = "SELECT * FROM orders WHERE id = ";
    private final String SELECT_ALL = "SELECT * FROM orders";
    private final String SAVE = "INSERT INTO orders(id, date, cost) VALUES (?, ?, ?)";
    private final String DELETE = "DELETE FROM orders WHERE id = ";
    private final String UPDATE = "UPDATE orders SET ";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, OrderMapper.getInstance());
    }

    @Override
    public Order selectById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID + id, OrderMapper.getInstance());
    }

    @Override
    public void save(Order order) {
        jdbcTemplate.update(SAVE, order.getId(),order.getDate(), order.getCost());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE + id);
    }

    @Override
    public void update(int id, Order order) {
        StringBuilder sqlBuilder = new StringBuilder(UPDATE);
        List<Object> args = new ArrayList<>();

        if (order.getDate() != null) {
            sqlBuilder.append("date = ?, ");
            args.add(order.getDate());
        }

        if (order.getCost() != 0.0) {
            sqlBuilder.append("cost = ?, ");
            args.add(order.getCost());
        }

        if (args.isEmpty())
            return;

        sqlBuilder.replace(sqlBuilder.length() - 2, sqlBuilder.length(), " WHERE id = ?");
        jdbcTemplate.update(sqlBuilder.toString(), args.toArray());
    }
}
