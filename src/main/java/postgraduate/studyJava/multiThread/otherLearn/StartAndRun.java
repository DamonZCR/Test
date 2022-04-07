package postgraduate.studyJava.multiThread.otherLearn;

import java.util.concurrent.locks.Lock;

/**线程中，start()放和run()方法的区别：
 * run只是Thread里面的一个普通方法，start是启动线程的方法。
 * start()方法让一个线程进入就绪队列等待分配 cpu， 分到 cpu 后才调用实现的run()方法。
 * start()方法不能重复调用， 如果重复调用会抛出异常。
 * 而 run 方法是业务逻辑实现的地方， 本质上和任意一个类的任意一个成员方法并没有任何区别，可以重复执行，也可以被单独调用。
 *
 *
 * 1.start()方法来启动线程，无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；
 * jvm通过调用Thread类的start()方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。
 * 然后通过此Thread类调用方法run()来完成其运行操作的， 这里方法run()称为线程体，它包含了要执行的这个线程的内容，
 * run方法运行结束， 此线程终止。然后其他线程再抢cpu的控制权接着执行，这是真正实现了多线程。
 *
 * 2.run()方法当作普通方法的方式调用。程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码；
 * 程序中只有主线程---这一个线程，其程序执行路径还是只有一条。这并非多线程，还只是单线程。
 */
public class StartAndRun {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();//输出：pangping
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pang");
    }
    /**
     * start()是开启另一个线程去执行，所以输出时是不按照代码顺序的；
     * run()是程序内部的自己的方法，所以它会按照代码的顺序执行；
     */
}
