import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
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

//        List<Product> booksList = task1_2(productList);
//        System.out.println(booksList);

//        List<Product> booksWithDiscount = task2_2(productList);
//        System.out.println(booksWithDiscount);

//        Product lowestPriceBook = task3_2_3(productList);
//        System.out.println(lowestPriceBook);

//        List<Product> last3Added = task4_2(productList);
//        System.out.println(last3Added);

//        Double sumProductOfCurrentYear = task5_2(productList);
//        System.out.println(sumProductOfCurrentYear);

//        task6_2(productList).forEach((key, val) -> System.out.printf("%s - %s%n", key, val));
    }

    public static List<Product> task1_2(List<Product> productList) {
        return productList.stream()
                .filter(product -> (product.getType().equals("Book") && product.getPrice() >= 250))
                .collect(Collectors.toList());
    }

    public static List<Product> task2_2(List<Product> productList) {
         return productList.stream()
                .filter(product -> (product.getType().equals("Book") && product.isHasDiscount()))
                .map(product -> {
                    product.setPrice(90 * product.getPrice() / 100);
                    return product;
                }).collect(Collectors.toList());
    }

    public static Product task3_2_3(List<Product> list) {
        return list.stream()
                .filter(product -> product.getType().equals("Book"))
                .min((book1, book2) -> (int) (book1.getPrice() - book2.getPrice()))
                .orElseThrow(() -> new RuntimeException("Product Book was not found!"));
    }

    public static List<Product> task4_2(List<Product> list) {
        return list.stream()
                .sorted(Comparator.comparing(Product::getDateOfAdding).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static Double task5_2(List<Product> list) {
        return list.stream()
                .filter(product -> (product.getType().equals("Book") &&
                                    product.getPrice() <= 75 &&
                                    product.getDateOfAdding().getYear() == 2024))
                .mapToDouble(Product::getPrice)
                .reduce(0, Double::sum);
    }

    public static Map<String, List<Product>> task6_2(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}