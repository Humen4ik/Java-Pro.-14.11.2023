package org.example.testcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.controller.OrderController;
import org.example.testcrud.converter.OrderConverter;
import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.model.Order;
import org.example.testcrud.repository.OrderRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;
    private final OrderConverter orderConverter;

    @Override
    public OrderDto getById(int id) {
        Order order = orderRepo.findById(id).orElseThrow();
        return orderConverter.fromModel(order);
    }

    @Override
    public List<OrderDto> getAll() {
        Iterable<Order> orders = orderRepo.findAll();
        List<OrderDto> dtos = orderConverter.fromModel(orders);
        return dtos;
    }

    @Override
    public void save(OrderDto orderDto) {
        Order order = orderConverter.toModel(orderDto);
        orderRepo.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepo.deleteById(id);
    }

    @Override
    public void update(int id, OrderDto orderDto) {
        Order oldOrder = orderRepo.findById(id).orElseThrow();
        Order newOrder = orderConverter.toModel(orderDto, oldOrder);
        System.out.println(newOrder);
        orderRepo.save(newOrder);
    }

    @Override
    public List<OrderDto> getOrdersPage(Pageable pageable) {
        Page<Order> orderPage = orderRepo.findAll(pageable);
        List<OrderDto> orderList = orderConverter.fromModel(orderPage.getContent());
        return orderList;
    }
}
