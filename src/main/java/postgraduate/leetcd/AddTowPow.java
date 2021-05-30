package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 平方数之和ID633
 * 给定一个非负整数c，你要判断是否存在两个整数a和b,使得a^2 + b^2 = c
 * 示例1:
 * 输入:c=5
 * 输出: true
 * 解释: 1*1 + 2*2 =5
 * 示例2:
 * 输入:c=3
 * 输出: false
 * 解法：对这个数c 进行开方得到x ,如果这个数是平方数可以直接返回true，
 * 否则，将x 取平方，然后求出这个数c 和x 平方的差值的开方end，然后判断end的平方
 * 与x的平方相加是否等于 这个数c 。循环判断x = x -1的每一 x 值。
 */
public class AddTowPow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(Solution(n));
    }
    private static boolean Solution(int c) {
        int x = (int) Math.floor(Math.sqrt(c));
        if (x * x == c)
            return true;

        for (int i = x; i >= 0; i--){
            long i2 = i * i;
            int end = (int)Math.sqrt(c - i2);
            if (end * end + i2 == c)
                return true;
        }
        return false;
    }
}
