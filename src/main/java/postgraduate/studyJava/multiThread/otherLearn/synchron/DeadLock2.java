package postgraduate.studyJava.multiThread.otherLearn.synchron;

/**
 * 死锁问题二------------重
 * 两个线程锁定了互相需要使用的对象导致死锁，最易出现的死锁问题。
 *
 * 进入A类中foo同步方法体中，此时的同步监视器是A类的对象，所以A类对象a被锁定，那么执行到方法b.last()处。
 * 由于同时调用了B类中的bar()方法，所以bar这个同步方法的同步监视器是B类的对象b.那么就会锁定b.并执行到
 * a.last()这一步。那么由于a对象在A中被锁定，b对象被B中锁定，并且它们都在等待对象释放，形成死锁。
 *
 */
class A{
    public synchronized void foo(B b){ // 同步控制方法。所以同步监视器为：A类的对象：a
        System.out.println("当前线程名：" + Thread.currentThread().getName()
                            + "   进入了A实例的foo方法中。");

        System.out.println("当前线程名：" + Thread.currentThread().getName()
                + "   企图调用B实例的last方法。");
        b.last();
    }

    public synchronized void last(){ // 谁调用，同步监视器就是谁。
        System.out.println("进入了A类的last 方法内部");
    }
}

class B{
    public synchronized void bar(A a){ // 同步控制方法。所以同步监视器为：B类的对象：b
        System.out.println("当前线程名：" + Thread.currentThread().getName()
                + "   进入了B实例的bar方法中。");

        System.out.println("当前线程名：" + Thread.currentThread().getName()
                + "   企图调用A实例的last方法。");
        a.last();
    }

    public synchronized void last(){ // 谁调用，同步监视器就是谁。
        System.out.println("进入了B类的last 方法内部");
    }
}
public class DeadLock2 implements Runnable{
    A a = new A();
    B b = new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        // 调用a 对象的foo方法
        a.foo(b);
        System.out.println("进入主线程之后");
    }
    public void run(){
        Thread.currentThread().setName("副线程");
        //调用b 对象的bar方法
        b.bar(a);
        System.out.println("进入副线程之后");
    }
    public static void main(String[] args) {
        DeadLock2 dl = new DeadLock2();
        new Thread(dl).start();
        dl.init();//只用主动调用才可以。
    }
}
