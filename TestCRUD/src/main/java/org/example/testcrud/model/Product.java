package org.example.testcrud.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
