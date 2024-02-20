package org.example.testcrud.service;

import org.example.testcrud.dto.Product;
import java.util.List;

public interface ProductService {
    Product getById(int id);
    List<Product> getAll();
    void save(Product order);
    void delete(int id);
    void update(int id, Product product);
}
