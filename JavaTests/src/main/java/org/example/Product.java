package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String type;
    private double price;
    private boolean hasDiscount;
    LocalDate dateOfAdding;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }


    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public LocalDate getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(LocalDate dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public Product() {
        type = "Unknown";
        price = 0.0;
        hasDiscount = false;
        dateOfAdding = LocalDate.now();
    }

    public Product(String type, double price, boolean hasDiscount, LocalDate ldt) {
        this.type = type;
        this.price = price;
        this.hasDiscount = hasDiscount;
        dateOfAdding = ldt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + String.format("%.2f", price) +
                ", hasDiscount=" + hasDiscount +
                ", dateOfAdding=" + dateOfAdding +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && hasDiscount == product.hasDiscount && Objects.equals(type, product.type) && Objects.equals(dateOfAdding, product.dateOfAdding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, hasDiscount, dateOfAdding);
    }
}
