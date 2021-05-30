package postgraduate.leetcd.lanqiao;

import java.util.Scanner;

/**
 * 如下是方法一，从左上角到右下角找规律。
 * 方法二，通过：
 * 5 - 1 = 4
 * 13 - 5 = 8
 * 25 - 13 = 12
 * …
 * 即差的差值是等差数列(4, 8, 12 ,16 …)，所以可以推断出第二十行。
 */
public class Java11D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for (int i = 1; i <= n + n - 1; i++) {
            sum += i;
        }
        System.out.println(sum - (n - 1));
    }
}
