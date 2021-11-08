package postgraduate.studyJava.multiThread.style1CreateThread;

// 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数

class MyThread1 extends Thread{
    //遍历100以内的偶数
    @Override
    public void run() {
        int i = 0;
        while(i < 100){
            if (i % 2 == 0)
                System.out.println(i + "   " + Thread.currentThread().getName());
            i++;
        }
    }
}

class MyThread2 extends Thread{
    // 遍历100以内的奇数
    @Override
    public void run() {
        int i = 0;
        while(i < 100){
            if (i % 2 != 0)
                System.out.println(i + "   " + Thread.currentThread().getName());
            i++;
        }
    }
}

public class ThreadTest1_Demo {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        mt1.start();
        mt2.start();
    }
}
