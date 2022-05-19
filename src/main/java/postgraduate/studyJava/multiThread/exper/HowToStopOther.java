package postgraduate.studyJava.multiThread.exper;

/** 测试一个线程可不可以暂停另一个线程
 * 通过测试是可以的；
 * 设置一个信号量如control，然后再设置一个对应的挂起命令suspend;
 * 当需要将这个线程挂起时就设置为true，启动就设置为false；
 * 将control设置为锁，只有获得锁的线程可以运行，所以，工作线程每一次打印都要访问是否获得了锁；
 * 如果获得了锁就输出，如果suspend标记为true就将线程阻塞，因为使用的是syschronized锁，所以
 * 如果获得锁的线程阻塞wait就会释放锁，而sleep就不会释放锁；
 */
public abstract class HowToStopOther extends Thread{
    private boolean suspend = false;
    private String control = ""; // 只是需要一个对象而已，这个对象没有实际意义

    public void setSuspend(boolean suspend) {
        if (!suspend) {// 如果为false说明要唤醒等待的对象；
            synchronized (control) {
                control.notifyAll();// notifyAll() 方法用于唤醒在该对象上等待的所有线程。
            }
        }
        this.suspend = suspend;
    }

    public boolean isSuspend() {
        return this.suspend;
    }

    public void run() {

        while (true) {
            synchronized (control) { // 获得锁就尝试访问是否需要阻塞；
                if (suspend) {
                    try {
                        control.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.runPersonelLogic();// 执行此方法
        }
    }

    protected abstract void runPersonelLogic();//此为抽象方法，可以再实例化时实现；

    public static void main(String[] args) throws Exception {

        HowToStopOther myThread = new HowToStopOther() {
            protected void runPersonelLogic(){
                // Thread.sleep(3000);
                System.out.println("myThead is running");
            }
        };
        myThread.start();
        Thread.sleep(3000);
        myThread.setSuspend(true); // 当设置为true时，将此线程设为阻塞状态；
        System.out.println("myThread has stopped");
        Thread.sleep(8000);
        myThread.setSuspend(false);// 当设置为false时，线程将一直运行；
    }
}
