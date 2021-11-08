package postgraduate.studyJava.multiThread.style3CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 * 实现输出100以内的偶数，并且 返回 他们的和。
 *
 * 创建多个线程
 */
//1.创建一个实现Callable的实现类
class NumThread2 implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    public Object call() throws Exception {
        int num = 0,res = 0;
        while(num <=100){
            if (num % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+" 线程  "+num);
                res += num;
            }
            num++;
        }
        return res;
    }
}

public class ThreadTest3_2 {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread2 nt = new NumThread2();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask ft = new FutureTask(nt);
        FutureTask ft2 = new FutureTask(nt);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        Thread t = new Thread(ft);
        Thread t2 = new Thread(ft2);
        t.setName("我是线程1");
        t2.setName("我是线程2");
        t.start();
        t2.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            System.out.println("线程1总和为：" + ft.get());
            System.out.println("线程2总和为：" + ft2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
