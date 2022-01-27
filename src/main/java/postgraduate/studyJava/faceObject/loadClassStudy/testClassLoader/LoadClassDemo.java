package postgraduate.studyJava.faceObject.loadClassStudy.testClassLoader;

/**
 * 需要说明的是，由于委派机制，Class的getClassLoader方法返回的不一定是调用load-Class的
 * ClassLoader，比如，上面代码中，java.util.ArrayList实际由BootStrap ClassLoader加载，
 * 所以返回值就是null。
 */
public class LoadClassDemo {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
            Class<?> cls = cl.loadClass("java.util.ArrayList");
            ClassLoader actualLoader = cls.getClassLoader();
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
