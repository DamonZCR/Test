package postgraduate.studyJava.multiThread.style4CreateThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/** 这个程序用来模拟实验同步阻塞队列，这个队列只能存储一个任务，只有这个任务被消费才可以再添加。
 * SynchronousQueue没有容量，是无缓冲等待队列，是一个不存储元素的阻塞队列，会直接将任务交给消费者，
 * 必须等队列中的添加元素被消费后才能继续添加新的元素。
 * 使用SynchronousQueue阻塞队列一般要求maximumPoolSizes为无界，避免线程拒绝执行操作。
 * 也就是它只能存储一个任务，只能等这一个任务被线程接受，才会添加到这个队列中新的任务。
 *
 * 以下程序中的二十任务会被一个接着一个被消费，然后被添加。
 */
public class A2_WuHuanChongQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        //生产者线程
        Thread t1 = new Thread(()->{
            for (int i = 0;i < 20;i++){
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
