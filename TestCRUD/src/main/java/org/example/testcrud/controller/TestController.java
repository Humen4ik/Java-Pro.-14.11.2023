package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.Order;
import org.example.testcrud.dto.Product;
import org.example.testcrud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final OrderService orderService;

    @GetMapping()
    public List<Order> testService() {
        orderService.save(new Order());
        orderService.save(new Order(LocalDate.of(2024, 2, 5),
                List.of(
                        new Product("milk", 5.50),
                        new Product("Banana", 7.30)
                )));
        orderService.save(new Order());
        orderService.save(new Order(LocalDate.of(2023, 12, 31),
                List.of(
                        new Product("Chocolate", 3.75),
                        new Product("Bread", 2.50),
                        new Product("Eggs", 4.20)
                )));

        orderService.delete(1);

        return orderService.getAll();
    }

}
