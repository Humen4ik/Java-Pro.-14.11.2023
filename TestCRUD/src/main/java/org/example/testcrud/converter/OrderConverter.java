package org.example.testcrud.converter;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.model.Order;
import org.example.testcrud.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final ProductConverter productConverter;
    public OrderDto fromModel(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getProducts().stream().mapToDouble(Product::getCost).sum())
                .products(productConverter.fromModel(order.getProducts()))
                .build();
    }

    public List<OrderDto> fromModel(Iterable<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            // List of Products to List of ProductDtos
            List<ProductDto> productDtos = productConverter.fromModel(order.getProducts());
            orderDtos.add(
                    OrderDto.builder()
                            .id(order.getId())
                            .date(order.getDate())
                            .cost(productDtos.stream().mapToDouble(ProductDto::getCost).sum())
                            .products(productDtos)
                            .build()
            );
        }
        return orderDtos;
    }

    public Order toModel(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCost(orderDto.getCost());
        order.setDate(orderDto.getDate());
        // Converting ProductDto to Product model
        List<Product> products = productConverter.toModel(orderDto.getProducts());
        order.setProducts(products);
        return order;
    }

    public Order toModel(OrderDto orderDto, Order oldOrder) {
        oldOrder.setDate(orderDto.getDate());
        oldOrder.setCost(orderDto.getCost());
        // Converting ProductDto to Product model
        List<Product> products = productConverter.toModel(orderDto.getProducts());
        oldOrder.setProducts(products);
        return oldOrder;
    }
}
