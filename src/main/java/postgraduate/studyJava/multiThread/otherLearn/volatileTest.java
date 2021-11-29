package postgraduate.studyJava.multiThread.otherLearn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**测试关键字volatile的作用。
 *  需要重点说明的一点是，尽管volatile关键字可以保证内存可见性和有序性，但不能保证原子性。
 *  也就是说，对volatile修饰的变量进行的操作，不保证多线程安全。请看以下的例子：
 *  静态变量num被volatile所修饰，并且同时开启1000个线程对其进行累加的操作，按道理来说，其结果应该为1000，但实际的情况是，每次运行结果可能都是一个小于1000的数字（也有结果为1000的时候，但出现几率很小），并且不固定。那么这是为什么呢？原因是因为“num++;”这行代码并不是原子操作，尽管它被volatile所修饰了也依然如此。++操作的执行过程如下面所示：
 *
 *     首先获取变量i的值
 *     将该变量的值+1
 *     将该变量的值写回到对应的主内存中
 *
 * 虽然每次获取num值的时候，也就是执行上述第一步的时候，都拿到的是主内存的最新变量值，
 * 但是在进行第二步num+1的时候，可能其他线程在此期间已经对num做了修改，这时候就会
 * 触发MESI协议的失效动作，将该线程内部的值作废。那么该次+1的动作就会失效了，也就是少加了一次1。
 * 比如说：线程A在执行第一步的时候读取到此时num的值为3，然后在执行第二步之前，其他多个线程已经
 * 对该值进行了修改，使得num值变为了4。而线程A此时的num值就会失效，重新从主内存中读取最新值。
 * 也就是两个线程做了两次+1的动作，但实际的结果最后只加了一次1。所以这也就是最后的执行结果为什么大
 * 概率会是一个小于1000的值的原因。所以如果要解决上面代码的多线程安全问题，可以采取加锁
 * synchronized的方式.也可以使用JUC包下的原子类AtomicInteger.
 */
public class volatileTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(1000);
    private volatile static int   num = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                try {
                    num++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(num);
    }
}

