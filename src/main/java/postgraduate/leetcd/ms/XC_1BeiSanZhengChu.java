package postgraduate.leetcd.ms;

import java.util.Scanner;

/**在携程-20220414-第四题中，是使用能被9整除的子序列有多少个？
 * 其实就是能被3整除的子序列有多少个的改版；
 *
 * 给定一个数字串，问有多少的子串可以被3整除。
 * 游游拿到了个数字串,她想取一个该数字串的子序列 (子序列在原串中可以不连续） ,使得该子序列是3的倍数。子序列可以包含前导零。
 * 游游想知道,一共能取多少个合法的子序列?答案请对10^9+7取模。我们定义,若两个子序列在原串中的位置不同,则认为它们不同。
 *
 * 输入描述:
 * 一个长度不超过200000的，仅由'0'~'9'十种字符组成的字符串。
 * 输出描述:
 * 于序列是3的倍数的数量。答案请对10^9+7取模。
 * 示例1
 * 输入:
 * 132
 * 输出：
 * 3
 * 说明
 * 共可以取3，12，132,都是3的倍数。
 * 解释：
 *      对于质因子为2或者5的k,不满足；
 */
public class XC_1BeiSanZhengChu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solve1(str);
        solve2(str);
    }

    /**
     * 方法一：
     * 根据最简单的思路进行推理得到的动态规划；
     * @param str
     */
    private static void solve1(String str){
        int dp [] = new int [3];
        for(int i = 0 ; i < str.length() ; i++) {
            int temp = str.charAt(i)-'0';
            if(temp % 3 == 0) {
                dp[0] = (int) ((dp[0]*2 +1)%(1e9+7));
                dp[1] =  (int) ((dp[1]*2)%(1e9+7));
                dp[2] =  (int) ((dp[2]*2)%(1e9+7));
            }
            else if(temp % 3 == 1) {
                int t1 =dp[1]+dp[0]+1;
                dp[0] =(int) ((dp[0]+ dp[2])%(1e9+7));
                dp[2] =(int) ((dp[2]+ dp[1])%(1e9+7));
                dp[1] = (int) (t1%(1e9+7));;
            }
            else if(temp % 3 == 2) {
                int t2 =dp[2]+dp[0]+1;
                dp[0] =(int) ((dp[0]+ dp[1])%(1e9+7));
                dp[1] =(int) ((dp[1]+ dp[2])%(1e9+7));
                dp[2] = (int) (t2%(1e9+7));;
            }
        }
        System.out.println(dp[0]);
    }

    /**
     * 方法二；
     *
     * @param str
     */
    private static void solve2(String str){
        double mod = 1e9 + 7;//结果取余

        int[][] dp = new int[51][3];//因为数组从0开始，而i代表是有多少数，所以最后一个数数组代表的是str.length
        for (int i = 1; i <= str.length(); i++) {
            int m = (str.charAt(i - 1) - '0') % 3;//数字对3取模
            for (int j = 0; j < 3; j++) {
                dp[i][j] = (int) ((dp[i - 1][j] + dp[i - 1][(j - m + 3) % 3]) % mod);//+3表示结果是非负的
            }
            dp[i][m] = (int) ((dp[i][m] + 1) % mod);//m位置要加上m本身，即当前数字符合取模则自增
        }
        System.out.println(dp[str.length()][0]);
    }
}