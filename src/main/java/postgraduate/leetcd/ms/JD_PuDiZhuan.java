package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 20220429-京东-第一题
 * 题目描述:
 * Alice需要用n块相同的大小为1*k的方形地砖铺满一块大小为n*k的地板。她数学不是很好，
 * 所以希望你帮她计算有多少种不同的铺法。
 * 如下图，使用5块大小为1*3的方形地砖铺满一块大小为5*3的地板总共有四种铺去。
 *
 * 输入描述
 * 输入仅包含一行，这行仅包含两个数n(1<=n<=10000),k(1<=k<=1000)，代表题目中的参数。
 * 输出描述
 * 输出所求的答案。因为答案可能很大，你只需要输出答案除以998244353所得的余数。
 * 样例输入：
 * 5 3
 * 样例输出：
 * 4
 */
public class JD_PuDiZhuan {
    public static void main(String[] args) throws IOException {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n + 1];

        for (int i = 1; i < k; i++) {
            arr[i] = 1;
        }
        arr[k] = 2;
        for (int i = k + 1; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - k];
        }
        System.out.println(arr[n]);
    }
}
