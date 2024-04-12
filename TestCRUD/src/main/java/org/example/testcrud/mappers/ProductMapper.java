package org.example.testcrud.mappers;

import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
    List<ProductDto> toProductDtoList(Iterable<Product> productList);
    List<Product> toProductList(List<ProductDto> productDtoList);
    void productDtoToProduct(ProductDto productDto, @MappingTarget Product product);
}
