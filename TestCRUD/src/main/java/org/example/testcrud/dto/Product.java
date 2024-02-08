package org.example.testcrud.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Product {
    private static int idCounter = 0;
    private int id;
    private String name;
    private double cost;

    {
        id = idCounter++;
    }

    public Product() {
        name = "Unknown";
        cost = 0.0;
    }

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
