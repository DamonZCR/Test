package postgraduate.studyJava.multiThread.style4CreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class A5_GongJuLei {
    public static void main(String[] args) {
        pool4();
    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     */
    public static void pool1(){
        // 创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        // 会创建出10个线程分别执行任务
        for (int i = 0; i < 10; i++) {
            es.execute(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                }
            });
        }
        es.shutdown();
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     */
    public static void pool2(){
        // 创建线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 会创建出指定个数的线程分别执行任务
        for (int i = 0; i < 10; i++) {
            es.execute(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                }
            });
        }
        es.shutdown();
    }

    /**
     * 	创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    public static void pool3(){
        // 创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        // 会创建出指定个数的线程分别执行任务
        for (int i = 0; i < 10; i++) {
            es.execute(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                }
            });
        }
        es.shutdown();
    }
    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。
     * 它不在使用返回ExecutorService的子接口，使用使用一个改造过的ScheduledExecutorService,
     * 里面有两个重要的方法，schedule
     */
    public static void pool4(){
        // 创建线程池
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
        // 延时执行的线程池
        // 参数依次是：任务， 延迟时间 ，时间单位；
        // 可以使任务在指定的延时时间之后执行，只执行一次。
        /*es.schedule(new Runnable() {
            public void run() {
                System.out.println("i = " + 1);
            }
        }, 4, TimeUnit.SECONDS);*/

        // 周期性执行：在一个固定的时间范围内，周期的去执行
        // 参数依次是：任务， 延迟时间 ，间隔时间， 时间单位；
        // 可以使任务在指定的延时时间3秒之后执行,并且每隔4秒执行一次。
        es.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("i = " + 1);
            }
        }, 3, 4,TimeUnit.SECONDS);
    }
}
