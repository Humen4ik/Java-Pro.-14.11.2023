public abstract class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    public abstract void run(int obstacle);
    public abstract void swim(int obstacle);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
