package org.example.testcrud.mapper;

import org.example.testcrud.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    private static ProductMapper instance = null;

    private ProductMapper() {}

    public static ProductMapper getInstance() {
        if (instance == null)
            instance = new ProductMapper();
        return instance;
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .cost(rs.getDouble("cost"))
                .build();
    }
}
