package postgraduate.studyJava.multiThread.ThreadComm;

/**
 * thread.join()/thread.join(long millis)，当前线程里调用其它线程t的join方法，当前线程进入WAITING/TIMED_WAITING状态，
 * 当前线程不会释放已经持有的对象锁。线程t执行完毕或者millis时间到，当前线程一般情况下进入RUNNABLE状态，
 * 也有可能进入BLOCKED状态（因为join是基于wait实现的）。
 */
public class JoinFunc {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程A的状态: " + mainThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                threadA.join();
                System.out.println("线程B的状态: " + mainThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
    }
}
