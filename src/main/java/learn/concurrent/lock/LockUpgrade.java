package learn.concurrent.lock;

import learn.Person;
import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级分析
 */
public class LockUpgrade {

    public static void main(String[] args) throws InterruptedException{
        Person personTemp = new Person();
        System.out.println("无状态锁(001):" + ClassLayout.parseInstance(personTemp).toPrintable());

        /* jvm 默认延时4秒自动开启偏向锁，可通过 -XX:BiasedLockingStartupDelay=0 取消延时
           如果不要偏向锁，可通过 -XX:-UseBiased！Locking=false 来设置*/
        Thread.sleep(5000);
        Person person = new Person();
        System.out.println("启用偏向锁(101):" + ClassLayout.parseInstance(person).toPrintable());

        for (int i = 0; i < 2; i++) {
            synchronized (person) {
                System.out.println("偏向锁(101)(带线程id):" + ClassLayout.parseInstance(person).toPrintable());
            }
            System.out.println("偏向锁释放(101)(带线程id):" + ClassLayout.parseInstance(person).toPrintable());
        }

        new Thread(()-> {
            synchronized (person) {
                System.out.println("轻量级锁(00):" + ClassLayout.parseInstance(person).toPrintable());
                try {
                    System.out.println("睡眠3秒");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("轻量->重量(10)" + ClassLayout.parseInstance(person).toPrintable());
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()-> {
            synchronized (person) {
                System.out.println("重量级锁(10):" + ClassLayout.parseInstance(person).toPrintable());
            }
        }).start();
    }
}
