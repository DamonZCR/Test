package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *小明很喜欢数对，又很喜欢GCD(最大公约数)。所以他想尽办法创造了一种全新的最大公约数：
 * 给出若干个数对(ai,bi)，如果一个最大的质数x可以整除每一个数对中的至少一个数字并且
 * 这个数字大于1，那么x就称为这些数对的N-GCD。现在小明给了你一些数对，希望你可以算出它们的N-GCD。
 *
 * 输入描述
 * 第一行一个数字n，表示数对的个数。
 * 接下来n行，每行两个数字，用一个空格分隔，表示一个数对。
 * 满足1<=n <=150000,1<=ai,bi<=2 * 10^9。
 * 输出描述
 * 一个数字，这些数对的N-GCD；若N-GCD不存在，那么输出-1。
 * 样例输入
 * 3
 * 2 2
 * 3 6
 * 7 8
 * 样例输出
 * 2
 */
public class WY_NGCD {
    public static void main(String[] args) {
        System.out.println(solve());

    }

    public static int solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        int max = 0;
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            max = Math.max(max, Math.max(a[i][0], a[i][1]));
        }
        // 找到所有的质数；
        int j = 0;
        for (int i = max; i > 1; i--) {
            for (j = 2; j < i; j++) {
                if (i % j == 0)
                    break;
            }
            if (j == i)
                list.add(i);
        }
        int len = list.size();
        int zhi = 0;
        int k = 0;
        for (int i = len - 1; i >= 0; i--) {
            zhi = list.get(i);
            for (k = 0; k < n; k++) {
                if (a[k][0] % zhi != 0 && a[k][1] % zhi != 0)
                    break;
            }
            if (k == n)
                return zhi;
        }
        return -1;
    }
}