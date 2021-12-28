package postgraduate.studyJava.multiThread.otherLearn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**Unsafe是sun.misc.Unsafe包下的一个类
 * 它可以调用系统底层的原语执行原子操作，如原子AtomicInteger等都是使用它
 * 实现了CAS操作。
 * unsafe类对于我们自定义类是无法调用new创建对象的，只有通过反射获取。因为它
 * 要求调用的它的主类（如UseUnsafe类）必须是空的。即使用boot的类加载器才可以，
 * 所以需要想办法使用反射绕过这个限制。
 *
 * 这里模拟的是：两个线程对UseUnsage类中的一个整数进行累加，使用UnSafe保证数据
 * 完整性。因为unsafe使用的是系统原语进行数据的操作，所以需要获取数据存放的位置（
 * 即偏移量），然后根据原值（预期值），更新后的值，来进行更新数据。
 *
 * 这个程序在运行的时候仍会打印出重复值。为何？是因为，假如线程1运行时修改值为3成功
 * 返回a为true，但是在打算取值输出的时候中断了，线程二开始修改，成功修改值为4，此时
 * 返回b为true，此时线程二正常输出为4，此时线程一活了过来，进行了一次取值，取到的就是
 * 4进行输出。
 *
 */
public class UseUnsafe {
    private static sun.misc.Unsafe nosafe;//先声明一个Unsafe的对象。
    private static long I_OFFSET;//偏移量
    private int i = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            nosafe = (Unsafe) field.get(null);//获取Unsafe对象。
            I_OFFSET = nosafe.objectFieldOffset(UseUnsafe.class.getDeclaredField("i"));//获取到偏移量
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UseUnsafe useUnsafe = new UseUnsafe();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true){
                    boolean a = nosafe.compareAndSwapInt(useUnsafe, I_OFFSET, useUnsafe.i, useUnsafe.i + 1);

                    if (a)
                        System.out.println("值被线程一更新:" + nosafe.getIntVolatile(useUnsafe, I_OFFSET));
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true){
                    boolean b = nosafe.compareAndSwapInt(useUnsafe, I_OFFSET, useUnsafe.i, useUnsafe.i + 1);

                    if (b)
                        System.out.println("值被线程二更新:" + nosafe.getIntVolatile(useUnsafe, I_OFFSET));
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
