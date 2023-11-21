public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        System.out.println(e1);
        Employee e2 = new Employee("Dr", "Steven", "Strange", "magician", "strange@gmail.com", "+380 98 673 23 43", 30);
        System.out.println(e2);

        System.out.println();
        
        Car car = new Car();
        car.start();
    }
}