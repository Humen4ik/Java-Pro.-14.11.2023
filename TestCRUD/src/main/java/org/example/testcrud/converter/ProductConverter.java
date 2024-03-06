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
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .cost(productDto.getCost())
                .build();
    }

    public Product toModel(ProductDto newDto, Product oldModel) {
        oldModel.setName(newDto.getName());
        oldModel.setCost(newDto.getCost());
        return oldModel;
    }

    public List<Product> toModel(List<ProductDto> dtos) {
        List<Product> list = new ArrayList<>();
        for (ProductDto dto : dtos)
            list.add(
                    Product.builder()
                            .id(dto.getId())
                            .cost(dto.getCost())
                            .name(dto.getName())
                            .build()
            );
        return list;
    }
}
