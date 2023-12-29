public class SynchronizedSingleton {
    private static volatile SynchronizedSingleton instance;
    private String str;

    private SynchronizedSingleton(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "SynchronizedSingleton{" +
                "str='" + str + '\'' +
                '}';
    }

    public static SynchronizedSingleton getInstance(String str) {
        if (instance != null) {
            return instance;
        }
        synchronized(SynchronizedSingleton.class) {
            if (instance == null) {
                instance = new SynchronizedSingleton(str);
            }
            return instance;
        }


    }
}
