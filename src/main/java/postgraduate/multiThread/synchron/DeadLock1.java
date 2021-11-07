package postgraduate.multiThread.synchron;

/**
 * 演示线程的死锁问题
 *
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 *
 * 2.说明：
 * 1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 2）我们使用同步时，要避免出现死锁。
 */
public class DeadLock1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        //使用继承Thread实现的同步控制
        new Thread(){
            public void run() {
                synchronized (sb){
                    sb.append("a");
                    sb2.append("1");

                    synchronized (sb2){
                        sb.append("b");
                        sb2.append("2");
                    }
                }
                System.out.println(sb);
                System.out.println(sb2);
            }
        }.start();
        //使用实现Runnable接口实现的同步控制
        new Thread(new Runnable() {
            public void run() {
                synchronized (sb2){
                    sb.append("c");
                    sb2.append("3");

                    synchronized (sb){
                        sb.append("d");
                        sb2.append("4");
                    }
                }
                System.out.println(sb);
                System.out.println(sb2);
            }
        }).start();
    }
}
