package postgraduate.studyJava.multiThread.otherLearn.synchron;

/**例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 *改用同步方法实现。
 * 同步方法必须设置为静态的，此时同步监视器为： 继承类名.class
 */
class SellTicket1_synFunc extends Thread{
    private static int num = 100;// 需要加static,不加static程序结果就是300张票
    public void run() {
        while(true) {
            // Sell方法为同步方法。
            Sell();
        }
    }
    //必须设定为静态，因为静态时该方法就唯一在内存区。此时同步监视器为：Window4.class。
    private static synchronized void Sell(){
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖出了一张，票号为:" + num);
            num--;
        }else
            System.exit(0);
    }
    public SellTicket1_synFunc(String name){
        super(name);
    }
}

public class Homework1_synFunc {
    public static void main(String[] args) {
        SellTicket1_synFunc st1 = new SellTicket1_synFunc("窗口一");
        // 定义线程名使用st1.setName("") 也可以；
        SellTicket1_synFunc st2 = new SellTicket1_synFunc("窗口二");
        SellTicket1_synFunc st3 = new SellTicket1_synFunc("窗口三");
        st1.start();
        st2.start();
        st3.start();
    }
}
