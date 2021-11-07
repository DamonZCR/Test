package postgraduate.multiThread.synchron;

/*例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 *
 */
class SellTicket2_synFunc implements Runnable{
    private int num = 100;// 不需加static，不会产生300票的情况。
    // 同步监视器，也可以不用它，用this代替。
    Object obj = new Object();
    public void run() {
        while(true) {
            Sell();
        }
    }
    // 不需要将同步方法设置为静态，应为多个线程同为一个类创建。
    private synchronized void Sell(){
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() +
                    " 卖出了一张，票号为:" + num);
            num--;
        } else
            System.exit(0);
    }
}


public class Homework2_synFunc {
    public static void main(String[] args) {
        SellTicket2_synFunc st1 = new SellTicket2_synFunc();

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st1);
        Thread t3 = new Thread(st1);
        t1.setName("窗口一");t1.start();
        t2.setName("窗口二");t2.start();
        t3.setName("窗口三");t3.start();
    }
}
