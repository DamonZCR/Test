package postgraduate.studyJava.faceObject.loadClassStudy.testClassLoader;

/**
 * 获取加载一个类的加载器是哪一个？
 * 类ClassLoader是一个抽象类，Application ClassLoader和Extension ClassLoader的具体实现类分别是：
 * 			sun.misc.Launcher$AppClassLoader
 * 			sun.misc.Launcher$ExtClassLoader
 * 			Bootstrap ClassLoader不是由Java实现的，没有对应的类。
 * 每个Class对象都有一个方法， 可以获取实际加载它的ClassLoader，方法是: .
 * 	public ClassLoader getClassLoader()
 * ClassLoader有一个方法， 可以获取它的父ClassLoader:
 * 	public final ClassLoader getParent()
 * 如果ClassLoader是Bootstrap ClassLoader，返回值为null。
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        while(cl != null) {
            System.out.println(cl.getClass().getName());
            cl = cl.getParent();
        }
        System.out.println(String.class.getClassLoader());
    }
}
