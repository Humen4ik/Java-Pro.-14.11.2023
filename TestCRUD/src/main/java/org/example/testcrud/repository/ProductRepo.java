package org.example.testcrud.repository;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.mapper.ProductMapper;
import org.example.testcrud.dto.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepo implements repo<Product>{
    private final String SELECT_ALL = "SELECT * FROM products";
    private final String SELECT_BY_ID = "SELECT * FROM products WHERE id = ";
    private final String SAVE = "INSERT INTO products(id, name, cost) VALUES (?, ?, ?)";
    private final String DELETE_BY_ID = "DELETE FROM products WHERE id = ";
    private final String UPDATE_BY_ID = "UPDATE products SET ";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List selectAll() {
        return jdbcTemplate.query(SELECT_ALL, ProductMapper.getInstance());
    }

    @Override
    public Product selectById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID + id, ProductMapper.getInstance());
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(SAVE, product.getId(), product.getName(), product.getCost());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_BY_ID + id);
    }

    @Override
    public void update(int id, Product product) {
        StringBuilder sqlBuilder = new StringBuilder(UPDATE_BY_ID);
        List<Object> args = new ArrayList<>();

        if (product.getName() != null) {
            sqlBuilder.append("name = ?, ");
            args.add(product.getName());
        }
        if (product.getCost() != 0.0) {
            sqlBuilder.append("cost = ?, ");
            args.add(product.getCost());
        }

        if (args.isEmpty()) {
            return;
        }

        sqlBuilder.replace(sqlBuilder.length() - 2, sqlBuilder.length(), " WHERE id = ?");
        args.add(id);

        String sql = sqlBuilder.toString();
        jdbcTemplate.update(sql, args.toArray());
    }
}
