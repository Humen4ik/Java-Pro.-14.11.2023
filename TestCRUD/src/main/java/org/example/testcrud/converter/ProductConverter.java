package org.example.testcrud.converter;

import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public ProductDto fromModel(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public List<ProductDto> fromModel(Iterable<Product> productList) {
        List<ProductDto> dtos = new ArrayList<>();
        for(Product product : productList) {
            dtos.add(ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .cost(product.getCost())
                    .build());
        }
        return dtos;
    }

    public Product toModel(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCost(productDto.getCost());
        return product;
    }

    public Product toModel(ProductDto newDto, Product oldModel) {
        oldModel.setName(newDto.getName());
        oldModel.setCost(newDto.getCost());
        return oldModel;
    }

    public List<Product> toModel(List<ProductDto> dtos) {
        List<Product> list = new ArrayList<>();
        for (ProductDto dto : dtos) {
            Product product = new Product();
            product.setId(dto.getId());
            product.setName(dto.getName());
            product.setCost(dto.getCost());
            list.add(product);
        }
        return list;
    }
}
