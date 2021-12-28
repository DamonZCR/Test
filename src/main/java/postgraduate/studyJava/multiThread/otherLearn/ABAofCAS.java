package postgraduate.studyJava.multiThread.otherLearn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/** 测试CAS中出现的ABA问题
 * 原本的没有考虑会存在ABA问题的（AtomicInteger等类），会出现ABA问题。
 * 如下面线程intT1和intT２，当线程intT1对原子类AtomicInteger对象操作后，并且在第二次操作回原值后，
 * 线程二intT２并没有去察觉，只是知道原来的这个值没有发生变化，怎么才能才能让线程二知道这个值是变化后的值呢？
 * 使用AtomicStampedReference类，它带有版本标记功能。
 * 线程三refT1和线程四refT２进行了实验，当线程refT1把值更改后，有改了回来，就需要自己去更新版本号，如果版本号
 * 不对，说明线程refT２拿到的是已经改变后的值了。
 *
 * 注意：compareAndSet（）方法都是需要指定期待的预期原来的旧值，在提供想要更改为的新值。这也就是CAS中的预期原值（A）和新值(B)。内存位置（V）
 *  即如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值 。否则，处理器不做任何操作。
 */
public class ABAofCAS {
    private static AtomicInteger atomicInt = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);

    public static void main(String[] args) throws InterruptedException {

        Thread intT1 = new Thread(new Runnable() {
            public void run() {
                boolean a = atomicInt.compareAndSet(100, 101);
                boolean b = atomicInt.compareAndSet(101, 100);
                System.out.println("intT1中第一次操作结果:" + a);
                System.out.println("intT1中第二次操作结果:" + b);
            }
        });

        Thread intT2 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                boolean c3 = atomicInt.compareAndSet(100, 101);
                System.out.println("intT2中第一次操作结果:" + c3 + ", 操作后的值为:" + atomicInt.get()); // true

                boolean c4 = atomicInt.compareAndSet(100, 101);
                System.out.println("intT2中第二次操作结果:" + c4 + ", 操作后的值为:" + atomicInt.get()); // false,与预期值不同，不执行操作。
            }
        });

        intT1.start();
        intT2.start();
        intT1.join();
        intT2.join();

        Thread refT1 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                atomicStampedRef.compareAndSet(100, 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                atomicStampedRef.compareAndSet(101, 100, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            }
        });

        Thread refT2 = new Thread(new Runnable() {
            public void run() {
                int stamp = atomicStampedRef.getStamp();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
                boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp, stamp + 1);
                System.out.println("refT2中第一次操作结果:" + c3); // false
            }
        });

        refT1.start();
        refT2.start();
    }
}
