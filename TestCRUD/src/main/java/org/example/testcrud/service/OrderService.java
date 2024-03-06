package org.example.testcrud.service;

import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.model.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    OrderDto getById(int id);
    List<OrderDto> getAll();
    void save(OrderDto order);
    void delete(int id);
    void update(int id, OrderDto order);
    List<OrderDto> getOrdersPage(Pageable pageable);
}
