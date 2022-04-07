package postgraduate.studyJava.testArray;

import com.alibaba.fastjson.JSON;
import postgraduate.studyJava.testJSON.Student;

import java.util.Arrays;

/**Java 拷贝数组方法 Arrays.copyOf() 是地址传递还是值传递?
 *
 */
public class ArraysCopyOfTest {
    public static void main(String[] args) {
        // 测试一
        // 测试copyOf()后，两个数组的地址是否相等；
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println("b数组地址：" + a);
        System.out.println(Arrays.toString(a));

        int[] b = Arrays.copyOf(a, a.length);
        System.out.println("a 数组地址：" + b);
        System.out.println(Arrays.toString(a));

        // 改变a中的值，观察b中是否发生变化；
        a[1] = 99;
        System.out.println("改变a中的第a[1]位置的元素为99，观察b[1]是否变化：" + b[1]);

        System.out.println();

        // 测试二
        // 真的是值拷贝嘛？
        Student[] c = new Student[]{new Student("张三", 20), new Student("王二", 18)};
        System.out.println("c数组地址：" + c);
        System.out.println(Arrays.toString(c));

        Student[] d = Arrays.copyOf(c, c.length);
        System.out.println("d 数组地址：" + d);
        System.out.println(Arrays.toString(d));

        // 改变a中的值，观察b中是否发生变化；
        c[1].setAge(99);
        System.out.println("改变c中的第c[1]位置的对象属性为99，观察b[1]是否变化：" + d[1].getAge());
    }
}
