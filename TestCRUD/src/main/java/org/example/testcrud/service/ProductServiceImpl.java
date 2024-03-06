package org.example.testcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.converter.ProductConverter;
import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.model.Product;
import org.example.testcrud.repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ProductConverter productConverter;
    @Override
    public ProductDto getById(int id) {
        Product product = productRepo.findById(id).orElseThrow();
        return productConverter.fromModel(product);
    }

    @Override
    public List<ProductDto> getAll() {
        Iterable<Product> productList = productRepo.findAll();
        return productConverter.fromModel(productList);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = productConverter.toModel(productDto);
        productRepo.save(product);
    }

    @Override
    public void saveAll(List<ProductDto> productDtos) {
        List<Product> products = productConverter.toModel(productDtos);
        productRepo.saveAll(products);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public void update(int id, ProductDto productDto) {
        Product product = productRepo.findById(id).orElseThrow();
        Product newProduct = productConverter.toModel(productDto, product);
        productRepo.save(newProduct);
    }

    @Override
    public List<ProductDto> getProductsInPage(Pageable pageable) {
        Page<Product> productPage = productRepo.findAll(pageable);
        List<Product> productList = productPage.getContent();
        return productConverter.fromModel(productList);
    }
}
