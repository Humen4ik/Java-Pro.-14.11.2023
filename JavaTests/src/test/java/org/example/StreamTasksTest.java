package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamTasksTest {

    StreamTasks streamTasks;
    List<Product> productList;
    @Before
    public void init() {
        streamTasks = new StreamTasks();
        productList = new ArrayList<>();
        productList.add(new Product("Clothing", 250.0, true, LocalDate.of(2024, 1, 5)));
        productList.add(new Product("Book", 499.99, false, LocalDate.of(2024, 1, 8)));
        productList.add(new Product("Clothing", 89.5, true, LocalDate.of(2023, 1, 12)));
        productList.add(new Product("Book", 39.95, false, LocalDate.of(2024, 1, 15)));
        productList.add(new Product("Book", 199.0, true, LocalDate.of(2022, 1, 18)));
        productList.add(new Product("Book", 799.5, false, LocalDate.of(2024, 1, 20)));
        productList.add(new Product("Clothing", 120.0, true, LocalDate.of(2023, 1, 22)));
        productList.add(new Product("Toys", 29.99, false, LocalDate.of(2024, 1, 25)));
        productList.add(new Product("Book", 300.0, true, LocalDate.of(2024, 1, 28)));
        productList.add(new Product("Book", 899.0, false, LocalDate.of(2024, 1, 30)));
        productList.add(new Product("Book", 75.0, true, LocalDate.of(2022, 2, 2)));
        productList.add(new Product("Toys", 49.95, false, LocalDate.of(2024, 2, 5)));
        productList.add(new Product("Book", 220.0, true, LocalDate.of(2023, 2, 8)));
        productList.add(new Product("Electronics", 599.0, false, LocalDate.of(2024, 2, 10)));
        productList.add(new Product("Book", 99.99, true, LocalDate.of(2024, 2, 12)));
    }

    @Test
    public void testTask1_2() {
        List<Product> filteredList = streamTasks.task1_2(productList);
        List<Product> expectedList = List.of(
                new Product("Book", 499.99, false, LocalDate.of(2024, 1, 8)),
                new Product("Book", 799.5, false, LocalDate.of(2024, 1, 20)),
                new Product("Book", 300.0, true, LocalDate.of(2024, 1, 28)),
                new Product("Book", 899.0, false, LocalDate.of(2024, 1, 30))
        );

        Assert.assertEquals(expectedList, filteredList);
    }

    @Test
    public void testTask2_2() {
        List<Product> filteredList = streamTasks.task2_2(productList);
        List<Product> expectedList = List.of(
                new Product("Book", 179.1, true, LocalDate.of(2022, 1, 18)),
                new Product("Book", 270.0, true, LocalDate.of(2024, 1, 28)),
                new Product("Book", 67.5, true, LocalDate.of(2022, 2, 2)),
                new Product("Book", 198, true, LocalDate.of(2023, 2, 8)),
                new Product("Book", 89.991, true, LocalDate.of(2024, 2, 12))
        );

        Assert.assertEquals(expectedList, filteredList);
    }

//    public void testTask3_2_3() {
//    }
//
//    public void testTask4_2() {
//    }
//
//    public void testTask5_2() {
//    }
//
//    public void testTask6_2() {
//    }
}