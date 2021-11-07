package postgraduate.multiThread.style1CreateThread;

// 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
// 升级版中使用创建匿名子类的方式实现。
public class ThreadTest1_DemoPlus {
    public static void main(String[] args) {
        // 因为创建的线程类用一次就不再使用，所以可以使用简单的使用创建。
        // 使用Java的创建Thread类的匿名子类的方式。
        new Thread(){
            public void run() {
                int i = 0;
                while(i < 100){
                    if (i % 2 == 0)
                        System.out.println(i + "   " + Thread.currentThread().getName());
                    i++;
                }
            }
        }.start();

        new Thread(){
            public void run() {
                int i = 0;
                while(i < 100){
                    if (i % 2 != 0)
                        System.out.println(i + "   " + Thread.currentThread().getName());
                    i++;
                }
            }
        }.start();
    }
}
