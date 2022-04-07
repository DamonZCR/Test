package postgraduate.studyJava.multiThread.otherLearn.suo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 测试tryLock()方法
 * 注意返回类型是boolean，如果获取锁的时候锁被占用就返回false，否则返回true;
 */
public class TestTheTryLockFunc {
    private Lock lock = new ReentrantLock();

    //需要参与同步的方法
    private void method(Thread thread){
        if(lock.tryLock()){
            try {
                System.out.println("线程名"+thread.getName() + "获得了锁");
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("线程名"+thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else
            System.out.println("我是"+Thread.currentThread().getName()+"有人占着锁，我就不要啦");
    }

    public static void main(String[] args) {
        TestTheTryLockFunc lockTest = new TestTheTryLockFunc();
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


