package org.example.testcrud.converter;

import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {
    public OrderDto fromModel(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getCost())
                .build();
    }

    public List<OrderDto> fromModel(Iterable<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(
                    OrderDto.builder()
                            .id(order.getId())
                            .date(order.getDate())
                            .cost(order.getCost())
                            .build()
            );
        }
        return orderDtos;
    }

    public Order toModel(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .cost(orderDto.getCost())
                .date(orderDto.getDate())
                .build();
    }

    public Order toModel(OrderDto orderDto, Order oldOrder) {
        oldOrder.setDate(orderDto.getDate());
        oldOrder.setCost(orderDto.getCost());
        return oldOrder;
    }
}
