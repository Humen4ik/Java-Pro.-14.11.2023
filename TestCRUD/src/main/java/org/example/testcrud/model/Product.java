package org.example.testcrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table("products")
public class Product {
    @Id
    private int id;
    private String name;
    private double cost;
}
