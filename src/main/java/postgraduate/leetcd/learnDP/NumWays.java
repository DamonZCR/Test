package postgraduate.leetcd.learnDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**剑指 Offer 10- II. 青蛙跳台阶问题
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：0 <= n <= 100
 */
public class NumWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res2 = findNumWays(n);
        System.out.println(res2);
    }

    /**
     * 执行结果：
     * 通过
     * 添加备注
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了5.12% 的用户
     * 通过测试用例：51 / 51
     * 思想：
     * 通过建立表格可以发现，比如说第三级有几种方法，就是1、如果走一步的话，就是上到第二级的所有方法总数，因为走一步从第二级
     * 到第三级就是这么多方法，2、如果走两步只能是从第一级走上来，那么就是第一级的所有方法总数，所有第三级的所有可能结果就是。这俩相加。
     * @param n
     * @return
     */
    private static int findNumWays(int n) {
        if (n == 0)
            return 1;
        int[][] dp = new int[2][n + 1];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 1;
        dp[1][1] = 0;
        int i = 2;

        while (i < n + 1){
            dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1000000007;
            dp[1][i] = (dp[0][i - 2] + dp[1][i - 2]) % 1000000007;
            i++;
        }
        return (dp[0][n] + dp[1][n]) % 1000000007;
    }

}
