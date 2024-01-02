public class EagerSingleton {
    private EagerSingleton eagerSingleton;
    String str = "Default value";

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return new EagerSingleton();
    }

    @Override
    public String toString() {
        return "EagerSingleton{" +
                "str='" + str + '\'' +
                '}';
    }
}
