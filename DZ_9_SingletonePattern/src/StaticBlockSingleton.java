public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;
    String str = "Default value";

    private StaticBlockSingleton() {
    }

    static {
        instance = new StaticBlockSingleton();
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "StaticBlockSingleton{" +
                "str='" + str + '\'' +
                '}';
    }
}
