package postgraduate.studyJava.faceObject.loadClassStudy;
/**
 * 演示类的加载过程，代码执行的顺序。
 * 给出了程序在执行时，子类与父类的加载顺序，已经类中初始化代码块、实例代码块
 * 的执行顺序还有构造方法的执行顺序。
 */

class Base{
    public static int s;
    private int a;
    static {//1、加载类时执行
        System.out.println("基类静态代码块, s: " + s);
        s = 1;
    }
    {//2、对象创建的过程时执行
        System.out.println("基类实例代码块, a: " + a);
        a = 1;
    }
    public Base(){//2、对象创建的过程时执行
        System.out.println("基类构造方法, a: " + a);
        a = 2;
    }
    protected void step(){
        System.out.println("base s: " + s +", a: "+a);
    }
    public void action(){
        System.out.println("start"); step();
        System.out.println("end");
    }
}

class Child extends Base {
    public static int s;
    private int a;
    static {//1、加载类时执行
        System.out.println("子类静态代码块, s: " + s);
        s = 10;
    }
    {//2、对象创建的过程时执行
        System.out.println("子类示例代码块, a: " + a);
        a = 10;
    }
    public Child(){//2、对象创建的过程时执行
        System.out.println("子类构造方法, a: "+a);
        a = 20;
    }
    protected void step(){
        System.out.println("child s: " + s + ", a: " + a);
    }
}
public class LoadObject_1 {
    public static void main(String[] args) {
        System.out.println("---- new Child()");
        Child c = new Child();
        System.out.println("\n---- c.action()");
        c.action();
        Base b = c;
        System.out.println("\n---- b.action()");
        b.action();
        System.out.println("\n---- b.s: " + b.s);
        System.out.println("\n---- c.s: " + c.s);
    }
}
