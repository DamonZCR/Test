package postgraduate.studyJava.moShi;
//懒汉式单例类.在第一次调用的时候实例化自己
public class DanLi_LanHan {
}
// 线程不安全的懒汉式单例模式；
class Singleton1{
    private Singleton1(){}
    private static Singleton1 singel = null;
    //静态工厂方法
    public static Singleton1 getInstance(){
        if (singel == null){
            singel = new Singleton1();
        }
        return singel;
    }
}

//双重检查锁实现 线程安全的
class Singleton2{
    private Singleton2(){}
    private static Singleton2 single = null;

    //双重检查锁
    public static Singleton2 getInstance(){
        if (single == null){
            synchronized (Singleton2.class){
                if (single == null){
                    single = new Singleton2();
                }
            }
        }
        return single;
    }
}

//推荐：  静态内部类实现 线程安全的
class Singleton3{
    private static class LazyHolder{
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    private Singleton3(){}
    public static final Singleton3 getInstance(){
        return LazyHolder.INSTANCE;
    }
}
/**
 * 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
 * 即当SingleTon第一次被加载时，并不需要去加载LazyHolder，只有当getInstance()方法第一次被调用时，
 * 才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载LazyHolder类，这种方法不仅能确保
 * 线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化.
 */




