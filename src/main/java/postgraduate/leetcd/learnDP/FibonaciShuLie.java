package postgraduate.leetcd.learnDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 */
public class FibonaciShuLie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //int res = fib(n);
        int res2 = fib2(n);
        //System.out.println(res);
        System.out.println(res2);
    }

    private static int fib(int n) {
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    private static int fib2(int n){
        BigInteger a = new BigInteger(String.valueOf(0));
        BigInteger b = new BigInteger(String.valueOf(1));
        BigInteger c = new BigInteger(String.valueOf(0));
        for (int i = 0;i < n;i++){
            c = a.add(b);
            b = a;
            a = c;
            System.out.println(c);
        }
        System.out.println(c);
        return Integer.parseInt(c.mod(new BigInteger(String.valueOf(1000000007))).toString());
    }
}
