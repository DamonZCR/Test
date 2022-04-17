package postgraduate.leetcd.ms;

import java.util.Scanner;

/*
*携程-20220414-第四题
 * 请参考XC_BeiJiuZhengChu
 * 游游拿到了个数字串,她想取一个该数字串的子序列 (子序列在原串中可以不连续） ,使得该子序列是9的倍数。子序列可以包含前导零。
 * 游游想知道,一共能取多少个合法的子序列?答案请对10^9+7取模。我们定义,若两个子序列在原串中的位置不同,则认为它们不同。
 *
 * 输入描述:
 * 一个长度不超过200000的，仅由'0'~'9'十种字符组成的字符串。
 * 输出描述:
 * 于序列是9的倍数的数量。答案请对10^9+7取模。
 * 示例1
 * 输入:
 * 1188
 * 输出：
 * 5
 * 说明
 * 共可以取4个不同的"18"子序列,和一个"1188"子序列,都是9的倍数。
 * 实例2：
 * 输入：
 * 0123
 * 输出：
 * 1
 *
 * 解释：
 *      对于质因子为2或者5的k,不满足；
*/
public class XC_BeiJiuZhengChu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double mod = 1e9 + 7;//结果取余
        while (in.hasNext()) {// 循环输入
            String str = in.nextLine();
            int[][] dp = new int[str.length()][9];//因为数组从0开始，而i代表是有多少数，所以最后一个数数组代表的是str.length
            for (int i = 1; i <= str.length(); i++) {
                int m = (str.charAt(i - 1) - '0') % 9;//数字对9取模
                for (int j = 0; j < 9; j++) {
                    dp[i][j] = (int) ((dp[i - 1][j] + dp[i - 1][(j - m + 9) % 9]) % mod);//+9表示结果是非负的
                }
                dp[i][m] = (int) ((dp[i][m] + 1) % mod);//当前数字符合取模则自增
            }

            System.out.println(dp[str.length()][0]);
        }
        in.close();
    }
}