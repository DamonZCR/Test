package postgraduate.studyJava.multiThread.ThreadComm;

/**
 * 同一个ThreadLocal变量在父线程中被设置值后，在子线程中是获取不到的。
 * （threadLocals中为当前调用线程对应的本地变量，所以与父或者子二者自然是不能共享的）
 * 但是父线程的InheritableThreadLocals却可以被子线程复制，也就是，当父线程生成一个子线程时，
 * 父线程就会把自己的InheritableThreadLocals复制一份给子线程的InheritableThreadLocals，
 * 如果父线程的InheritableThreadLocals发生了修改，子线程的InheritableThreadLocals不受影响；
 */
public class TestThreaLocal {
    //(1)创建ThreadLocal变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static  InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //在main线程中添加main线程的本地变量
        threadLocal.set("ThreadLocal父线程类中添加的值value");
        inheritableThreadLocal.set("inheritableThreadLocal父线程类中添加的值value");

        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("子线程中的本地变量值:"+threadLocal.get());
                    System.out.println("子线程获取线程中的本地变量值:"+inheritableThreadLocal.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        int i = 5;
        while(i > 0){
            inheritableThreadLocal.set(String.valueOf(i));
            System.out.println("yunxing");
            i--;
            Thread.sleep(1000);
        }
        //输出main线程中的本地变量值
        System.out.println("父线程获取线程中的本地变量值:"+threadLocal.get());
        System.out.println("父线程获取线程中的本地变量值:"+inheritableThreadLocal.get());
    }

}
