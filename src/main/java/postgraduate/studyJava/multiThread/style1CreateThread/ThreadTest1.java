package postgraduate.studyJava.multiThread.style1CreateThread;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 *
 * 例子：遍历100以内的所有的偶数
 *
 * Thread.currentThread().getName()可以获取当前执行线程的名字；
 */
class MyThread extends Thread{
    /*继承Thread 类，然后实现run 方法；
    @Override
    public void run() {
    }*/

    @Override
    public void run() {
        int i = 0;
        while(i <= 100){
            if (i % 2 == 0)
                System.out.println(i + "  " + Thread.currentThread().getName());
            i++;
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()
        mt.start();
        mt2.start();
        System.out.println("Hello World !   " + Thread.currentThread().getName());
    }
}
