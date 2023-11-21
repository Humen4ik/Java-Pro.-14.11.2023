import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //  Короткий опис
        // Створив абстрактний клас Animal, Dog та Cat його успадковують
        // Animal має 2 абстр методи - swim та run.
        // Для підрахунку створених собак/котів у їхні відповідні класи додав
        // статичну змінну count, яка при кожному разі виклику конструктора
        // інкрементує змінну на 1

        // Робота методів run та swim у класі Dog
        Animal dogJordan = new Dog("Джордан");
        dogJordan.run(200);
        dogJordan.run(1000);
        dogJordan.swim(5);
        dogJordan.swim(20);

        // Підрахунок створених собак
        Animal dog2 = new Dog("Собака1");
        Animal dog3 = new Dog("Собака2");
        Animal dog4 = new Dog("Собака3");
        System.out.println(Dog.getCountCreatedDogs());

        System.out.println();
        // Робота методів run та swim у класі Cat
        Animal catMuska = new Cat("Муська");
        catMuska.run(100);
        catMuska.run(300);
        catMuska.swim(300);

        // Підрахунок створених киць
        Animal cat2 = new Cat("Кицька1");
        Animal cat3 = new Cat("Кицька1");
        System.out.println(Cat.getCountCreatedCats());
    }
}