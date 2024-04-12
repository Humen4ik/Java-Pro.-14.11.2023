package org.example.testcrud.mappers;

import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);
    List<OrderDto> toOrderDtoList(Iterable<Order> orderList);
    List<Order> toOrderList(List<OrderDto> orderDtoList);
    void orderDtoToOrder(OrderDto orderDto, @MappingTarget Order order);

}
