package org.example.testcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Product;
import org.example.testcrud.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public Product getById(int id) {
        return productRepo.selectById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.selectAll();
    }

    @Override
    public void save(Product order) {
        productRepo.save(order);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id, product);
    }
}
