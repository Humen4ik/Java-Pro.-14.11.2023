package org.example.testcrud.controller.order.data;

import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.dto.ProductDto;
import org.example.testcrud.mappers.OrderMapper;
import org.example.testcrud.model.Order;
import org.example.testcrud.model.Product;
import org.example.testcrud.repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class OrderApiTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    void shouldGetOrderById() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setProducts(List.of(
                new Product("Milk", 15.50),
                new Product("Apple", 23.30),
                new Product("Orange", 12.70)
        ));
        orderRepo.save(order);
        String url = "http://localhost:" + port + "/orders/" + order.getId();
        OrderDto orderDto = testRestTemplate.getForObject(url, OrderDto.class);

        assertEquals(order.getId(), orderDto.getId());
    }

    // цей тест не працює, бо mapstruct змінює id при оновленні, і все валиться
    @Test
    void shouldUpdateOrderById() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setProducts(List.of(
                new Product("Milk", 15.50),
                new Product("Apple", 23.30),
                new Product("Orange", 12.70)
        ));
        orderRepo.save(order);

        OrderDto orderDto = OrderDto.builder()
                .date(LocalDate.of(2003, 9, 17))
                .products(List.of(
                        ProductDto.builder().name("Mineral water").cost(10.0).build(),
                        ProductDto.builder().name("Tomato").cost(10.0).build(),
                        ProductDto.builder().name("Chocolate").cost(10.0).build()))
                .build();

        String url = "http://localhost:" + port + "/orders/" + order.getId();
        testRestTemplate.put(url, orderDto);

        Order newOrder = orderRepo.findById(order.getId()).orElseThrow();

        System.out.println(order);
        System.out.println(newOrder);
        assertEquals(order.getId(), newOrder.getId());
        assertEquals(LocalDate.of(2003, 9, 17), newOrder.getDate());
        assertEquals(order.getCost(), newOrder.getCost());
        assertEquals(order.getProducts(), newOrder.getProducts());
    }

    @Test
    void shouldDeleteOrderById() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setProducts(List.of(
                new Product("Milk", 15.50),
                new Product("Apple", 23.30),
                new Product("Orange", 12.70)
        ));
        orderRepo.save(order);

        String url = "http://localhost:" + port + "/orders/" + order.getId();
        testRestTemplate.delete(url);

        List<Order> orders = orderRepo.findAll();
        assertEquals(0, orders.size());
    }


}
