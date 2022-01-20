package postgraduate.studyJava.faceObject.loadClassStudy;
/**
 * loadClass()方法加载类的时候会执行被加载类的初始话代码，而使用Class的
 * forName方法加载类的时候就不会执行类的初始化代码。
 */
public class LoadClassTest {
    public static class Hello{
        static {
            System.out.println("Hello");
        }
    }
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = LoadClassTest.class.getName() + "$Hello";
        try{
            //Class<?> cls = cl.loadClass(className);//不执行被加载类的初始代码
            Class<?> cls = Class.forName(className);//执行
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
