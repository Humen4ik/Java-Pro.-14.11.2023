package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTasks {
    public List<Product> task1_2(List<Product> productList) {
        return productList.stream()
                .filter(product -> (product.getType().equals("Book") && product.getPrice() >= 250))
                .collect(Collectors.toList());
    }

    public List<Product> task2_2(List<Product> productList) {
        return productList.stream()
                .filter(product -> (product.getType().equals("Book") && product.isHasDiscount()))
                .map(product -> {
                    product.setPrice(90 * product.getPrice() / 100);
                    return product;
                }).collect(Collectors.toList());
    }

    public Product task3_2_3(List<Product> list) {
        return list.stream()
                .filter(product -> product.getType().equals("Book"))
                .min((book1, book2) -> (int) (book1.getPrice() - book2.getPrice()))
                .orElseThrow(() -> new RuntimeException("Product Book was not found!"));
    }

    public List<Product> task4_2(List<Product> list) {
        return list.stream()
                .sorted(Comparator.comparing(Product::getDateOfAdding).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public Double task5_2(List<Product> list) {
        return list.stream()
                .filter(product -> (product.getType().equals("Book") &&
                        product.getPrice() <= 75 &&
                        product.getDateOfAdding().getYear() == 2024))
                .mapToDouble(Product::getPrice)
                .reduce(0, Double::sum);
    }

    public Map<String, List<Product>> task6_2(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}