package postgraduate.studyJava.multiThread.otherLearn.synchron;

/*例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 * 使用同步锁synchronized 锁定，加上同步锁。这个对象也称为同步监视器
 * 对于Runnable接口的线程，同步监视器可以使用this关键字代替。
 */
class SellTicket2_synchron implements Runnable{
    private int num = 100;// 不需加static，不会产生300票的情况。
    // 同步监视器，也可以不用它，用this代替。
    Object obj = new Object();
    public void run() {
        while(true) {
            synchronized(this) {// 用obj的对象可以，用this也可以。
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            " 卖出了一张，票号为:" + num);
                    num--;
                } else
                    break;
            }
        }
    }
}

public class Homework2_synchron {
    public static void main(String[] args) {
        SellTicket2_synchron st1 = new SellTicket2_synchron();

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st1);
        Thread t3 = new Thread(st1);
        t1.setName("窗口一");t1.start();
        t2.setName("窗口二");t2.start();
        t3.setName("窗口三");t3.start();
    }
}
