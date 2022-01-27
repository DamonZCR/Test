package postgraduate.studyJava.faceObject.loadClassStudy.testClassLoader;

/**ClassLoader的loadClass方法与Class的forName方法
 * 在反射一章，我们介绍过Class的两个静态方法forName:
 * 	public static Class<?> forName(String className)
 * 	public static Class<?> forName(String name, boolean initialize, ClassLoader loader)
 * 第一个方法使用系统类加载器加载，第二个方法指定ClassLoader,参数initialize表示加载后是否执行类的
 * 初始化代码(如static语句块)，没有指定默认为true。
 * ClassLoader的loadClass方法与Class的forName方法都可以加载类，它们有什么不同呢?
 * 基本是一样的，不过，ClassLoader的loadClass不会执行类的初始化代码，看个例子:
 */
public class CLInitDemo {
    public static class Hello {
        static {
            System.out.println("hello");
        }
    };
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = CLInitDemo.class.getName() + "$Hello";
        try {
            //Class<?> cls = cl.loadClass(className);//使用loadClass()
            Class<?> cls = Class.forName(className);//使用forName()方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
