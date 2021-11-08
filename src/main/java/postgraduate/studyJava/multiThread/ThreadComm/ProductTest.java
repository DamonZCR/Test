package postgraduate.studyJava.multiThread.ThreadComm;

/**
 * 生产者(Productor)将产品交给店员(Clerk)， 而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20)，如果生产者试图生产更多的产品，店员会叫
 * 生产者停一下，如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。这里可能出现两个问题:
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。消费者比生产者快时，消费者会取相同的数据。
 */
class Clerk{
    private int num;
    public Clerk(){
        this.num = 20;
    }

    public synchronized void bugThing() {
        if(num > 0){
            num--;
            System.out.println(Thread.currentThread().getName() + "消费了一件,还剩："+num);
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addThing() {
        if(num == 0){
            System.out.println(Thread.currentThread().getName() + " 生产了 20 件！");
            num = 20;
        }
        notifyAll();
    }
}
class Productor implements Runnable{
    Clerk clerk;
    public Productor(Clerk cl){
        this.clerk = cl;
    }
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addThing();
        }
    }

}
class Customer implements Runnable{
    Clerk clerk;
    public Customer(Clerk cl){
        this.clerk = cl;
    }
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.bugThing();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk cl = new Clerk();
        Customer cu = new Customer(cl);
        Productor pr = new Productor(cl);

        Thread t1 = new Thread(cu);
        Thread t2 = new Thread(cu);
        Thread t3 = new Thread(pr);
        t1.setName("AA");
        t2.setName("BB");
        t3.setName("CC");
        t1.start();
        t2.start();
        t3.start();
    }
}
