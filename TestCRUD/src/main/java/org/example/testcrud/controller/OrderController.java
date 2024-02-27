package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Order;
import org.example.testcrud.dto.Product;
import org.example.testcrud.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable("orderId") Integer id) {
        return orderService.getById(id);
    }

    @PostMapping()
    public void createNewOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Integer id) {
        orderService.delete(id);
    }

    @PutMapping("/{orderId}")
    public void update(@PathVariable("orderId") Integer id, @RequestBody Order order) {
        orderService.update(id, order);
    }

}
