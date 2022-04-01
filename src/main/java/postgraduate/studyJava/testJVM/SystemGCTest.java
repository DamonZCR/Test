package postgraduate.studyJava.testJVM;

/**
 * 测试System.gc()方法会不会立刻调用finalize()方法，通过注释掉System.runFinalization();
 * 方法可以看到，当执行System.gc()方法时，finalize()并不是马上执行的；
 *
 * 把System.runFinalization();不注释掉发现，它总会调用finalize()方法；
 */
public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        //与Runtime.getRuntime().gc();的作用一样。
        System.gc();//提醒jvm的垃圾回收器执行gc,但是不确定是否马上执行gc

        System.runFinalization();//强制调用使用引用的对象的finalize()方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了finalize()");
    }
}
