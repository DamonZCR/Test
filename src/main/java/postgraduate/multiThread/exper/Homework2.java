package postgraduate.multiThread.exper;

/*例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 *这个程序因为票数同时可以被多个线程占有，所以很容易卖出相同的票数；
 *存在线程安全问题
 */
class SellTicket2 implements Runnable{
    private int num = 100;// 不需加static，不会产生300票的情况。
    public void run() {
        while(true) {
            if (num > 0){
                System.out.println(Thread.currentThread().getName() +
                        " 卖出了一张，票号为:" + num);
                num--;
            }
            else
                break;
        }
    }
}

public class Homework2 {
    public static void main(String[] args) {
        SellTicket2 st1 = new SellTicket2();

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st1);
        Thread t3 = new Thread(st1);
        t1.setName("窗口一");t1.start();
        t2.setName("窗口二");t2.start();
        t3.setName("窗口三");t3.start();
    }
}
