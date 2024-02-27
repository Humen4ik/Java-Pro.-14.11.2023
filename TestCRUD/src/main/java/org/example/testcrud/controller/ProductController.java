package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.controller.response.ApiResponse;
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
    public ApiResponse<List<Product>> getAllProducts() {
        ApiResponse<List<Product>> apiResponse = new ApiResponse<>();
        List<Product> products = productService.getAll();
        if(!products.isEmpty()) {
            apiResponse.setBody(products);
            apiResponse.setStatus(true);
        } else {
            apiResponse.getMessages().add("Some error!");
        }
        return apiResponse;
    }

    @GetMapping("/{productId}")
    public ApiResponse<Product> getProductById(@PathVariable("productId") Integer id) {
        ApiResponse<Product> apiResponse = new ApiResponse<>();
        Product product = productService.getById(id);
        if(product != null) {
            apiResponse.setBody(product);
            apiResponse.setStatus(true);
        } else {
            apiResponse.getMessages().add("Some error!");
        }
        return apiResponse;
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