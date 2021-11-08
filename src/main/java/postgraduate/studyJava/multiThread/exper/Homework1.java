package postgraduate.studyJava.multiThread.exper;

/*例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式

 *这个程序因为票数同时可以被多个线程占有，所以很容易卖出相同的票数；
 *存在线程安全问题
 */
class SellTicket extends Thread{
    private static int num = 100;// 需要加static,不加static程序结果就是300张票
    public void run() {
        while(true) {
            if (num > 0) {
                System.out.println(getName() + " 卖出了一张，票号为:" + num);
                num--;
            } else
                break;
        }
    }
    public SellTicket(String name){
        super(name);
    }
}
public class Homework1 {
    public static void main(String[] args) {
        SellTicket st1 = new SellTicket("窗口一");
        // 定义线程名使用st1.setName("") 也可以；
        SellTicket st2 = new SellTicket("窗口二");
        SellTicket st3 = new SellTicket("窗口三");
        st1.start();
        st2.start();
        st3.start();
    }
}
