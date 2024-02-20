package org.example.testcrud.service;

import org.example.testcrud.dto.Order;

import java.util.List;

public interface OrderService {
    Order getById(int id);
    List<Order> getAll();
    void save(Order order);
    void delete(int id);
}
