package org.example.testcrud.service;

import org.example.testcrud.dto.ProductDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto getById(int id);
    List<ProductDto> getAll();
    void save(ProductDto order);
    void saveAll(List<ProductDto> products);
    void delete(int id);
    void update(int id, ProductDto product);
    List<ProductDto> getProductsInPage(Pageable pageable);
}
