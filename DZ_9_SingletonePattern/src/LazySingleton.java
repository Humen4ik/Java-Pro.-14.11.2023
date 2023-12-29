public class LazySingleton {
    private static LazySingleton instance;
    private String str;
    private LazySingleton(String str) {
        this.str = str;
    }

    public static LazySingleton getInstance(String str) {
        if (instance == null)
            instance = new LazySingleton(str);
        return instance;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "str='" + str + '\'' +
                '}';
    }
}
