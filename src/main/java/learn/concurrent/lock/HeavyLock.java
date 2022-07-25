package learn.concurrent.lock;

/**
 * 锁效果展示
 */
public class HeavyLock {

    public static void main(String[] args) throws InterruptedException{
        A a = new A();

        long star = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                a.increase();
            }
        });
        t1.start();

        for (int i = 0; i < 10000000; i++) {
            a.increase();
        }
        t1.join();

        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - star));
        System.out.println(a.getNum());
    }
}
