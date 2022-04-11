package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Java的输入测试。

public class inputTest {
    public static void main(String[] args) throws IOException { // 需要加上异常处理
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取控制台输入的一行，以空格分割成一个一个的String字符。
        String[] lens = br.readLine().split(" ");
        // 将String字符数组转为 int 类型数组。
        int[] num = new int[lens.length];
        for (int i = 0;i<lens.length;i++) {
            num[i] = Integer.parseInt(lens[i]);
        }
        // 读取单行的 数字。
        int m = Integer.parseInt(br.readLine());

        // 遍历
        for (int a : num) {
            System.out.print(a+" ");
        }
        System.out.println(m);
    }
}
