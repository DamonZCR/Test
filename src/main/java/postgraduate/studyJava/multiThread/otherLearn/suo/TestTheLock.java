package postgraduate.studyJava.multiThread.otherLearn.suo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  测试Lock类的锁，它是一个接口，ReentrantLock类是它的具体实现类；
 * 使用结束后，需要在finally中释放锁；
 *
 *  执行情况：线程名t1获得了锁
 *       线程名t1释放了锁
 *       线程名t2获得了锁
 *       线程名t2释放了锁
 */
public class TestTheLock {
    private Lock lock = new ReentrantLock();
    //需要参与同步的方法
    private void method(Thread thread){
        lock.lock();
        try {
            System.out.println("线程名"+thread.getName() + "获得了锁");
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("线程名"+thread.getName() + "释放了锁");
            lock.unlock();//使用try-catch,最后再finally中释放锁；
        }
    }

    public static void main(String[] args) {
        TestTheLock lockTest = new TestTheLock();

        //线程1
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");
        //线程2
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

