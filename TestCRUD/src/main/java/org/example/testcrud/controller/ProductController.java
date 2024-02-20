package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Product;
import org.example.testcrud.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Integer id) {
        return productService.getById(id);
    }

    @PostMapping()
    public void createNewEmployee(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable("productId") Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{productId}")
    public void updateById(@PathVariable("productId") Integer id, @RequestBody Product product) {
        productService.update(id, product);
    }

}
