package postgraduate.leetcd.ms;

import java.util.Scanner;

/**模数求和
 * 现给定n个整数，并定义一个非负整数m，且令f(m) = (m%a1)+(m%a2)+...+(m%an)。
 * 此处的X % Y的结果为X除以Y的余数。
 * 现请你找出一个m，求出f(m)的最大值。
 * 输入描述
 * 输入包含两行，第一行为一正整数n，(1<n<=3000) 第二行为n个整数a1,a2,...,an ，其中(2<=ai<=10^5)
 * 输出描述
 * 输出仅包含一行，输出f(m)的最大值
 */
public class WY_MoShuZhiHe {
    public static void main(String[] args) {
        System.out.println(solve());

    }
    public static int solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        int res = 0;
        for (int i = 0;i < n;i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }

        for (int i = 0; i <= sum; i++) {
            int fm = 0;
            for (int j = 0; j < n; j++) {
                fm += i % a[j];
            }
            res = Math.max(res, fm);
        }
        return res;
    }
}
