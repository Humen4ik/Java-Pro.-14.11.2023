package org.example.testcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Order;
import org.example.testcrud.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;

    @Override
    public Order getById(int id) {
        return orderRepo.selectById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepo.selectAll();
    }

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepo.delete(id);
    }

    @Override
    public void update(int id, Order order) {
        orderRepo.update(id, order);
    }

}
