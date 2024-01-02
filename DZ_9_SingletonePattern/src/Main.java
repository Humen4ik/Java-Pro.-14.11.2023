public class Main {
    public static void main(String[] args) {
        // TODO: Eager initialization singleton
//        EagerSingleton es1 = EagerSingleton.getInstance();
//        System.out.println(es1);

        // TODO: Lazy initialization singleton
//        LazySingleton lz1 = LazySingleton.getInstance("factory1");
//        System.out.println(lz1);
//        LazySingleton lz2 = LazySingleton.getInstance("factory2");
//        System.out.println(lz2);

        // TODO: Static block initialization
//        StaticBlockSingleton sbs = StaticBlockSingleton.getInstance();
//        System.out.println(sbs);

        // TODO: Synchronized singleton
        new Thread(() -> {
            SynchronizedSingleton sf = SynchronizedSingleton.getInstance("hello");
            System.out.println(sf);
        }).start();

        new Thread(() -> {
            SynchronizedSingleton sf = SynchronizedSingleton.getInstance("world");
            System.out.println(sf);
        }).start();

        new Thread(() -> {
            SynchronizedSingleton sf = SynchronizedSingleton.getInstance("!");
            System.out.println(sf);
        }).start();
    }
}