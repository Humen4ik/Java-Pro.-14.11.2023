package org.example.testcrud.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;
    private LocalDate date;
    private double cost;
    private List<ProductDto> products;
}
