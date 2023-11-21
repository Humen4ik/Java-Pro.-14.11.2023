public class Dog extends Animal{
    private static int countCreatedDogs = 0;
    Dog(String name) {
        super(name);
        countCreatedDogs++;
    }

    @Override
    public void run(int obstacle) {
        if (obstacle <= 500)
            System.out.println(name + " пробіг(ла) " + obstacle + " метрів!");
        else
            System.out.println("На жаль, дана дистанція для собаки на ім'я " + name + " завелика :(");
    }

    @Override
    public void swim(int obstacle) {
        if (obstacle <= 10)
            System.out.println(name + " проплив(ла) " + obstacle + " метрів!");
        else
            System.out.println("На жаль, дана дистанція для собаки на ім'я " + name + " завелика :(");
    }

    public static int getCountCreatedDogs() {
        return countCreatedDogs;
    }
}
