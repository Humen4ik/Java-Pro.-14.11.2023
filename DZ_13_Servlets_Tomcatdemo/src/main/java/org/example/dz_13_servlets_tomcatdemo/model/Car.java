package org.example.dz_13_servlets_tomcatdemo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Car implements Serializable {
    private String model;
    private double power;
    private int year;
    private double price;

    public Car() {
        model = "Unknown";
        power = 0.0;
        year = 0;
        price = 0.0;
    }
}
