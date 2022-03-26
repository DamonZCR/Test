package postgraduate.studyJava.multiThread.style3CreateThread;

import java.util.concurrent.*;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 * 实现输出100以内的偶数，并且 返回 他们的和。
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 */
//1.创建一个实现Callable的实现类
class  NumThread implements Callable{
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
public class ThreadTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* 以下是使用FutureTask来接收返回，
            另下一个是直接使用Future来接收；

        //3.创建Callable接口实现类的对象
        NumThread nt = new NumThread();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask ft = new FutureTask(nt);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        Thread t = new Thread(ft);
        t.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            System.out.println("总和为：" + ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });

        System.out.println("future.get() = " + future.get());
        executorService.shutdownNow();
    }
}
