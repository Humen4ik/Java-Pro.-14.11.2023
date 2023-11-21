public class Cat extends Animal {
    private static int countCreatedCats = 0;
    Cat(String name) {
        super(name);
        countCreatedCats++;
    }

    @Override
    public void run(int obstacle) {
        if (obstacle <= 200)
            System.out.println(name + " пробіг(ла) " + obstacle + " метрів!");
        else
            System.out.println("На жаль, дана дистанція для кицьки на ім'я " + name + " завелика :(");
    }

    @Override
    public void swim(int obstacle) {
        System.out.println("Коти не вміють плавати :(");
    }

    public static int getCountCreatedCats() {
        return countCreatedCats;
    }
}
