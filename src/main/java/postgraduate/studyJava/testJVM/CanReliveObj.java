package postgraduate.studyJava.testJVM;

/**
 * 测试Object类中finalize()方法，即对象的finalization机制。
 *重写了finalize()方法，如果不重写，（注释掉）。会发现对象会在第一次gc时直接死掉；
 * 重写了finalize()方法，发现finalize()方法只会执行一次；
 */
public class CanReliveObj {
    public static CanReliveObj obj;//类变量，属于 GC Root

    //此方法只能被调用一次
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize()方法");
        obj = this;//当前待回收的对象在finalize()方法中与引用链上的一个对象obj建立了联系
    }

    public static void main(String[] args) {
        try {
            obj = new CanReliveObj();
            // 对象第一次成功拯救自己
            obj = null;//使这个对象的引用为空；
            System.gc();//调用垃圾回收器，会执行一次finalize();
            System.out.println("第1次 gc");
            // 因为Finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
            System.out.println("第2次 gc");
            // 下面这段代码与上面的完全相同，但是这次自救却失败了
            obj = null;// 再次使这个对象的没有任何引用；
            System.gc();//不会再执行finzale()方法；
            // 因为Finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
