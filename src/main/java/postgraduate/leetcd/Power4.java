package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 给定一个整数,写一个函数来判断它是否是4的幂次方。如果是,返回true;否则,返回false.
 * 整数n是4的幂次方需满足:存在整数x使得n == 4^x
 * 示例1 :
 * 输入:n=16
 * 输出: true
 */
public class Power4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    /**
     * 是4 的幂，一定是大于0，是2 的 幂，并且总长度是基数个。
     * @param n
     * @return
     */
    private static boolean solve(int n){
        return n > 0 && (n & (n - 1)) == 0 && (Integer.toBinaryString(n).length() - 1) % 2 == 0;
    }
}
