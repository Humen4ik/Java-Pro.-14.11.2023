package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.controller.response.ApiResponse;
import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ApiResponse<List<ProductDto>> getAllProducts() {
        ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<>();
        List<ProductDto> products = productService.getAll();
        if(!products.isEmpty()) {
            apiResponse.setBody(products);
            apiResponse.setStatus(true);
        } else {
            apiResponse.getMessages().add("Some error!");
        }
        return apiResponse;
    }

    @GetMapping("/{productId}")
    public ApiResponse<ProductDto> getProductById(@PathVariable("productId") Integer id) {
        ApiResponse<ProductDto> apiResponse = new ApiResponse<>();
        ProductDto product = productService.getById(id);
        if(product != null) {
            apiResponse.setBody(product);
            apiResponse.setStatus(true);
        } else {
            apiResponse.getMessages().add("Some error!");
        }
        return apiResponse;
    }

    @PostMapping()
    public void saveNewProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
    @PostMapping("/batch")
    public void saveNewProducts(@RequestBody List<ProductDto> dtos) {
        productService.saveAll(dtos);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable("productId") Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{productId}")
    public void updateById(@PathVariable("productId") Integer id, @RequestBody ProductDto product) {
        productService.update(id, product);
    }

    @GetMapping("/pagination")
    public List<ProductDto> productPage(@RequestParam(defaultValue = "0") int pageNo,
                                        @RequestParam(defaultValue = "2") int itemsNo,
                                        @RequestParam(defaultValue = "id") String sortBy,
                                        @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, itemsNo, sort);
        List<ProductDto> list = productService.getProductsInPage(pageable);
        return list;
    }

}