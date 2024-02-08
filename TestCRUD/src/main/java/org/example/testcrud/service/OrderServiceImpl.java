package org.example.testcrud.service;

import org.example.testcrud.dto.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final List<Order> orderList = new ArrayList<>();
    @Override
    public Order getById(int id) {
        return orderList.stream()
                .filter(order -> order.getId() == id)
                .findFirst().get();
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(Order order, int id) {
        Order oldOrder = orderList.get(id - 1);
        oldOrder.setCost(order.getCost());
        oldOrder.setDate(order.getDate());
        oldOrder.setProductList(order.getProductList());
    }

    @Override
    public void delete(int id) {
        orderList.remove(id - 1);
    }
}
