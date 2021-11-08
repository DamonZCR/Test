package postgraduate.studyJava.multiThread.synchron;

/**例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 使用同步锁synchronized 锁定，加上同步锁。这个对象也称为同步监视器
 *在继承Thread类创建多线程的方式中，慎用this充当同步监视器（一般不能用），考虑使用当前类（下一行的方法）充当同步监视器。
 * 如果不想声明这个静态的obj也可以，使用：此继承类名.class为同步监视器。
 */
class SellTicket1_synchron extends Thread{
    private static int num = 100;// 需要加static,不加static程序结果就是300张票
    // 加上一个共享的类对象，让线程竞争这个锁对象,必须为静态。同步监视器
    static Object obj = new Object();
    public void run() {
        while(true) {
            synchronized (obj) {// 锁开始的地方。使用SellTicket1_synchron.class代替obj也可以。
                if (num > 0) {
                    System.out.println(getName() + " 卖出了一张，票号为:" + num);
                    num--;
                } else
                    break;
            }
        }
    }
    public SellTicket1_synchron(String name){
        super(name);
    }
}

public class Homework1_synchron {
    public static void main(String[] args) {
        SellTicket1_synchron st1 = new SellTicket1_synchron("窗口一");
        // 定义线程名使用st1.setName("") 也可以；
        SellTicket1_synchron st2 = new SellTicket1_synchron("窗口二");
        SellTicket1_synchron st3 = new SellTicket1_synchron("窗口三");
        st1.start();
        st2.start();
        st3.start();
    }
}
