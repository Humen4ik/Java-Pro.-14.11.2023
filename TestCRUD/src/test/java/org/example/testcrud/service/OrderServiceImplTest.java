package org.example.testcrud.service;

import org.example.testcrud.dto.OrderDto;
import org.example.testcrud.mappers.OrderMapper;
import org.example.testcrud.model.Order;
import org.example.testcrud.repository.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles(value = "test")
class OrderServiceImplTest {

    private static final int ORDER_ID = 25;

    @InjectMocks
    private OrderServiceImpl testInstance;

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private Order order;

    @Mock
    private List<Order> orders;

    private OrderDto orderDto;

    @BeforeEach
    public void init() {
        orderDto = OrderDto.builder()
                .id(25)
                .cost(100.0)
                .date(LocalDate.now())
                .build();
    }

    @Test
    void shouldReturnOrderById() {
        when(orderRepo.findById(anyInt())).thenReturn(Optional.of(order));
        when(orderMapper.orderToOrderDto(order)).thenReturn(orderDto);

        OrderDto testDto = testInstance.getById(ORDER_ID);

        verify(orderRepo).findById(ORDER_ID);
        verify(orderMapper).orderToOrderDto(order);
        assertNotNull(testDto);
        assertEquals(ORDER_ID, testDto.getId());
    }

    @Test
    void shouldReturnListOfOrders() {
        OrderDto orderDto1 = OrderDto.builder().id(15).date(LocalDate.of(2023, 12, 8)).cost(200.0).build();
        OrderDto orderDto2 = OrderDto.builder().id(16).date(LocalDate.of(2024, 8, 24)).cost(150.0).build();
        OrderDto orderDto3 = OrderDto.builder().id(17).date(LocalDate.of(2022, 3, 15)).cost(300.0).build();
        List<OrderDto> dataList = Arrays.asList(orderDto1, orderDto2, orderDto3);
        when(orderRepo.findAll()).thenReturn(orders);
        when(orderMapper.toOrderDtoList(orders)).thenReturn(dataList);

        List<OrderDto> resultList = testInstance.getAll();

        verify(orderRepo).findAll();
        verify(orderMapper).toOrderDtoList(orders);
        assertNotNull(resultList);
        assertEquals(3, resultList.size());
    }

    @Test
    void save() {
        OrderDto orderDto = OrderDto.builder().id(ORDER_ID).date(LocalDate.of(2023, 12, 8)).cost(200.0).build();
        when(orderMapper.orderDtoToOrder(orderDto)).thenReturn(order);

        testInstance.save(orderDto);

        verify(orderMapper).orderDtoToOrder(orderDto);
        verify(orderRepo).save(order);
    }

    @Test
    void delete() {
        testInstance.delete(ORDER_ID);

        verify(orderRepo).deleteById(ORDER_ID);
    }

    @Test
    void update() {
        LocalDate date = LocalDate.of(2023, 12, 8);
        double cost = 200.0;
        OrderDto orderDto = OrderDto.builder().id(ORDER_ID).date(date).cost(cost).build();
        Order updatedOrder = new Order();
        updatedOrder.setId(ORDER_ID);
        updatedOrder.setDate(date);
        updatedOrder.setCost(cost);
        when(orderRepo.findById(anyInt())).thenReturn(Optional.of(order));

        testInstance.update(ORDER_ID, orderDto);

        verify(orderRepo).findById(ORDER_ID);
        verify(orderMapper).orderDtoToOrder(orderDto, order);
    }

}