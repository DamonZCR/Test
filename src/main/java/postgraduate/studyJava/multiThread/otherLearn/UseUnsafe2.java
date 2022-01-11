package postgraduate.studyJava.multiThread.otherLearn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**Unsafe是sun.misc.Unsafe包下的一个类
 * 使用Unsafe获取一个对象中的数组属性。
 *
 */
public class UseUnsafe2 {
    private static Unsafe nosafe;//先声明一个Unsafe的对象。
    private String[] s = {"1", "2", "3", "4"};

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            nosafe = (Unsafe) field.get(null);//获取Unsafe对象。
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UseUnsafe2 useUnsafe = new UseUnsafe2();
        // 数组中存储的对象的对象头的大小
        int ns = nosafe.arrayIndexScale(String[].class);
        // 数组中第一个元素的起始位置
        int base = nosafe.arrayBaseOffset(String[].class);
        // 获取从base头开始的第三个元素。
        System.out.println(nosafe.getObject(useUnsafe.s, base + 2 * ns));
    }
}
