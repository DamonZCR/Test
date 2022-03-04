package postgraduate.studyJava.multiThread.style4CreateThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** 这个程序用来模拟实验有界缓存等待队列，也就是这个队列是可以无限制的存储任务。
 * ArrayBlockingQueue是一个有界缓存等待队列，底层是使用数组实现的；
 *  可以指定缓存队列的大小，当正在执行的线程数等于corePoolSize时，多余的元素缓存在
 *  ArrayBlockingQueue队列中等待有空闲的线程时继续执行，当ArrayBlockingQueue已满时，
 *  加入ArrayBlockingQueue失败，会开启新的线程去执行，当线程数已经达到最大的maximumPoolSizes时，
 *  再有新的元素尝试加入ArrayBlockingQueue时会报错。
 *
 *  可以设置队列的大小为4，首先一次添加4个任务到队列中，然后消费一个添加到队列中一个。
 */
public class A4_YouJieHuanChongQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
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
