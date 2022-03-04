package postgraduate.studyJava.multiThread.style4CreateThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/** 这个程序用来模拟实验无界阻塞队列，也就是这个队列是可以无限制的存储任务。
 * LinkedBlockingQueue是一个无界缓存等待队列。当前执行的线程数量达到corePoolSize的数量时，
 * 剩余的所有元素会在阻塞队列里等待。（所以在使用此阻塞队列时maximumPoolSizes就相当于无效了），
 * 每个线程完全独立于其他线程。生产者和消费者使用独立的锁来控制数据的同步，即在高并发的情况下可以并行操作队列中的数据。
 *
 * 以下程序中的二十任务会被瞬间加入到队列中，然后再一个接着一个被消费。
 */
public class A3_WuJieHuanChongQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        //生产者线程
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 20; i++){
                try {
                    System.out.println("装入数据:" + i);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //消费者线程
        Thread t2 = new Thread(()->{
            while (true){
                try {
                    System.out.println("2秒后取数据");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
