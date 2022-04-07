package postgraduate.studyJava.multiThread.otherLearn.synchron;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock实现的同步控制，使用Runnable实验
 * 如果使用继承Thread，这时的ReentrantLock对象就需要加上static了。
 */
class ReentrantThread implements Runnable{
    private int num = 100;
    private ReentrantLock rtl = new ReentrantLock();
    public void run() {
        while(true){
            rtl.lock();
            try{
                if (num > 0){
                    System.out.println("窗口：" + Thread.currentThread().getName()
                            + "卖出一张票，还剩：" + num);
                    num--;
                }else
                    break;
            }finally {
                rtl.unlock();
            }
        }
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantThread rt = new ReentrantThread();

        Thread t1 = new Thread(rt);
        Thread t2 = new Thread(rt);
        Thread t3 = new Thread(rt);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
