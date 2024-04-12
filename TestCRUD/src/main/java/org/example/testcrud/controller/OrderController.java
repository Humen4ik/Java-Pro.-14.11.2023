package org.example.testcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderById(@PathVariable("orderId") Integer id) {
        return orderService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("orderId") Integer id) {
        orderService.delete(id);
    }

    @PutMapping("/{orderId}")
    public void update(@PathVariable("orderId") Integer id, @RequestBody OrderDto orderDto) {
        orderService.update(id, orderDto);
    }

    @GetMapping("/pagination")
    public List<OrderDto> ordersPage(@RequestParam(defaultValue = "0") int pageNo,
                                     @RequestParam(defaultValue = "2") int itemsNo,
                                     @RequestParam(defaultValue = "id") String sortBy,
                                     @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, itemsNo, sort);
        List<OrderDto> orderList = orderService.getOrdersPage(pageable);
        return orderList;
    }

}
