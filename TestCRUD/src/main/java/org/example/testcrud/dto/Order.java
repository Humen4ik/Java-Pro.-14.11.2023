package org.example.testcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order {

    private static int orderIdCounter = 0;

    private int id;
    private LocalDate date;
    private double cost;
    private List<Product> productList;

    {
        id = orderIdCounter++;
        productList = new ArrayList<>();
    }

    public Order() {
        date = LocalDate.now();
        cost = 0.0;
    }

    public Order(LocalDate date, List<Product> products) {
        this.date = date;
        this.cost = products.stream().mapToDouble(Product::getCost).sum();
        productList.addAll(products);
    }
}
