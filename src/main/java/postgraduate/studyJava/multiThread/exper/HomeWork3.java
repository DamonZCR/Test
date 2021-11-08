package postgraduate.studyJava.multiThread.exper;
/**
 * 银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 *
 */
class AddMoney implements Runnable {
    private int money = 0;
    private int a = 3, b = 3;

    public void run() {
        while (true)
            synchronized (this) {
                if (Thread.currentThread().getName() == "A") {
                    if (a > 0) {
                        money += 1000;
                        a--;
                        System.out.println("储户A存入 1000元！");
                    }else
                        break;
                } else {
                    if (b > 0) {
                        money += 1000;
                        b--;
                        System.out.println("储户B存入 1000元！");
                    }else
                        break;
                }
            }
    }
}
public class HomeWork3 {
    public static void main(String[] args) {
        AddMoney am = new AddMoney();

        Thread t1 = new Thread(am);
        Thread t2 = new Thread(am);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}


