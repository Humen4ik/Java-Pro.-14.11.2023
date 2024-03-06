package org.example.testcrud.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@ToString
@Table("orders")
public class Order {
    @Id
    private int id;
    private LocalDate date;
    private double cost;
//    @MappedCollection(idColumn = "orders")
//    private List<Product> productList;
}
