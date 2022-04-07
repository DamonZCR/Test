package postgraduate.studyJava.testArray;

import java.util.Arrays;

/** 测试将数组传递给方法，是只拷贝还是 地址传递；
 * 测试发现：地址传递。
 * 在方法中改变了此数组的值，主函数中的数组就会发生变化，并且通过输出地址可以发现，
 * 两个数组的地址相同；
 */
public class DiZhiChuanDi {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println("主函数中，数组地址：" + a);
        xiuGai(a);
        System.out.println(Arrays.toString(a));
    }

    private static void xiuGai(int[] a) {
        System.out.println("调用函数中，收到的数组地址：" + a);
        for (int i = 0; i < a.length; i++) {
            a[i] = 9;
        }
    }
}
