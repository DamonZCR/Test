package postgraduate.studyJava.multiThread.style4CreateThread;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 * 面试题：创建多线程有几种方式？四种！
 */
class AThread implements Runnable{
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + "输出" + i);
        }
    }
}
class AsThread implements Callable{
    public Object call() throws Exception {
        for (int i = 51; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "输出" + i);
        }
        return "OK";
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService ex = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) ex;
        //设置线程池的属性,只有需要设置线程池属性才用上面这行。
        /*service1.setCorePoolSize(15);
        service1.setKeepAliveTime();*/

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        ex.execute(new AThread());//适合适用于Runnable
        ex.execute(new AThread());//适合适用于Runnable

        Future sb = ex.submit(new AsThread());//适用于Callable
        try {//获取返回值。
            System.out.println(sb.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //3.关闭连接池
        ex.shutdown();
    }
}
